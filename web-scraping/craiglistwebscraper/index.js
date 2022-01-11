const puppeteer = require('puppeteer');
const cheerio = require('cheerio');
const mongoose = require('mongoose');
const Listing = require('./model/Listining');

// password: webscrapping@teste

const scrapingResults = [
  {
    title: " Senior Full-stack Engineer | $140,000 - $180,000 per year",
    datePosted: new Date("2019-07-26 12:00:00"),
    neighbourhood: "(palo alto)",
    url: "https://sfbay.craigslist.org/sfc/sof/d/san-francisco-senior-full-stack/7429472263.html",
    jobDescription: "If you're interested in applying for the role, you can check it out here: https://www.hireart.com/jobs/3506e90b/apply",
    compensation: "compensation: $140,000 - $180,000 per year"
  }
];

async function connectToMongoDb() {
  const url = "mongodb+srv://admin:webscrapping%40teste@craiglist-database.wzavt.mongodb.net/craiglist-database?retryWrites=true&w=majority"
  await mongoose.connect(url);
  console.log("connected to the mongodb")

}


async function scrapeListings(page) {

  await page.goto("https://sfbay.craigslist.org/d/software-qa-dba-etc/search/sof");

  const html = await page.content();
  const $ = cheerio.load(html);

  const listings = $(".result-info").map( (index, element) => {
    const titleElement = $(element).find(".result-title");
    const timeElement = $(element).find(".result-date");
    const neighbourhoodElement = $(element).find(".result-hood");
    const title = $(titleElement).text();
    const url = $(titleElement).attr("href");
    const datePosted = new Date($(timeElement).attr("datetime"));
    const neighbourhood = $(neighbourhoodElement).text().match(/\w+/g).join(' ');

    return {
      title,
      url,
      neighbourhood,
      datePosted
    };
  }).get();

  return listings;
}

async function scrapeJobDescriptions(listings, page) {
  for(let i = 0; i < listings.length; i++) {
    await page.goto(listings[i].url);
    const html = await page.content();
    const $ = cheerio.load(html);

    const jobDescription = $('#postingbody').text();
    const compensation = $('.attrgroup')
      .text()
      .match(/compensation: [$a-zA-Z0-9. -]+/gm)

    listings[i].jobDescription = jobDescription;

    !compensation ? listings[i].compensation = 'not informed' :
      listings[i].compensation = compensation.join('').replace('compensation: ', '');
    
    const listingModel = new Listing(listings[i]);
    await listingModel.save();
    await sleep(1000) //1s second sleep;
}



async function sleep(miliseconds) {
  return new Promise( resolve => setTimeout(resolve, miliseconds));
}

async function main() {
  await connectToMongoDb();
  const browser = await puppeteer.launch({ headless: false });
  const page = await browser.newPage();
  const listings = await scrapeListings(page);
  const listingsWithJobDescriptions = await scrapeJobDescriptions(listings, page);

  console.log(listings);
}

main();
