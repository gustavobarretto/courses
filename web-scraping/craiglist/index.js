const request = require('request-promise');
const cheerio = require('cheerio');

async function scrapeCraiglist() {
  try {
    const htmlResult = await request.get('https://sfbay.craigslist.org/d/software-qa-dba-etc/search/sof');
    console.log(htmlResult);
  } catch (err) {
    console.error(err);
  }
}

scrapeCraiglist();