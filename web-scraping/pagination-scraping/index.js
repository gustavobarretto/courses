const axios = require('axios');
const cheerio = require('cheerio');

async function scrape() {
  for(let i = 0; i <= 360; i = i + 120) {
    const response = await axios.get("https://sfbay.craigslist.org/search/muc?s=" + i);
    const html = response.data;
    const $ = cheerio.load(html);

    $('.result-title').each( (index, element) => console.log( $(element).text() ) );
     console.log("At page number " + i);
  }

}

scrape();