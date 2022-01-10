const puppeteer = require('puppeteer');
const cheerio = require('cheerio');

const scrapingResults = [
  {
    title: " Senior Full-stack Engineer | $140,000 - $180,000 per year",
    datePosted: new Date("2019-07-26 12:00:00"),
    neighbourhood: "(palo alto)",
    url: "https://sfbay.craigslist.org/sfc/sof/d/san-francisco-senior-full-stack/7429472263.html",
    jobDescription: "If you're interested in applying for the role, you can check it out here: https://www.hireart.com/jobs/3506e90b/apply",
    compensation: "compensation: $140,000 - $180,000 per year"
  }
]


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

async function scrapeJobScriptions(listings, page) {
  for(let i = 0; i < listings.length; i++) {
    await page.goto(listings[i].url);
    const html = await page.content();
  }
}

async function main() {
  const browser = await puppeteer.launch({ headless: false });
  const page = await browser.newPage();
  const listings = await scrapeListings(page);
  const listingsWithJobDescriptions = await scrapeJobScriptions(listings, page);

  console.log(listings);
}

main();
