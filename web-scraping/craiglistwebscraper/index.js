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


async function main() {
  const browser = await puppeteer.launch({ headless: false });
  const page = await browser.newPage();
  await page.goto("https://sfbay.craigslist.org/d/software-qa-dba-etc/search/sof");

  const html = await page.content();
  const $ = cheerio.load(html);

  $(".result-title").each( (index, element) => console.log($(element).text()) );
  $(".result-title").each( (index, element) => console.log($(element).attr('href')) );

  browser.close();

}

main();
