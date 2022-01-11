const axios = require('axios');
const cheerio = require('cheerio');

const url = 'https://sfbay.craigslist.org/d/software-qa-dba-etc/search/sof';

const scrapeResults = []

async function scrapeJobHeader() {
  try {
    
    const response = await axios.get(url);
    const htmlResult = response.data;
    
    const $ = cheerio.load(htmlResult);

    $('.result-info').each( (index, element) => {
      const title = $(element).children('.result-heading').children('.result-title').text();
      const url = $(element).children('.result-heading').children('.result-title').attr('href');
      const datePosted = $(element).children('.result-date').attr('datetime');
      const neighborhood = $(element).children('.result-meta').children('.result-hood').text().match(/\w+/gm).join(' ');
      const scrapeResult = { title, url, datePosted, neighborhood };
      scrapeResults.push(scrapeResult);

    });

    return scrapeResults;
    
  } catch (err) {
    console.error(err);
  }
}

async function scrapeDescription(jobsWithHeaders) {
  return await Promise.all(jobsWithHeaders.map( async (job) => {
    const response = await axios.get(job.url)
    const htmlResult = response.data;
    const $ = cheerio.load(htmlResult);

    // Removing previously element
    $('.print-qrcode-container').remove();

    console.log($.html())

    

    job.description = $('#posting').text();
    job.compensation = $('body > section > section > section > div.mapAndAttrs > p > span:nth-child(1) > b').text();

    return job;

  }))
}

async function scrapeCraiglist() {
  const jobsWithHeaders = await scrapeJobHeader();
  const jobsFullData = await scrapeDescription(jobsWithHeaders);

  
}

scrapeCraiglist();