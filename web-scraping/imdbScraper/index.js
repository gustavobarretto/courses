const cheerio = require('cheerio');
const axios = require('axios');
const nightmare = require('nightmare');

const sampleResult = {
  title: 'Bohemian Rhapsody',
  rank: 1,
  imdbRating: 8.4,
  descriptionUrl: 'https://www.imdb.com/title/tt0111161/?pf_rd_m=A2FGELUUNOQJNL&pf_rd_p=1a264172-ae11-42e4-8ef7-7fed1973bb8f&pf_rd_r=VBVBHW484Q7D247B1CJ4&pf_rd_s=center-1&pf_rd_t=15506&pf_rd_i=top&ref_=chttp_tt_1',
  postedUrl: 'https://www.imdb.com/title/tt0111161/mediaviewer/rm10105600/?ref_=tt_ov_i'
}

async function scrapeTitlesRanksAndRatings() {
  const { data } = await axios.get('https://www.imdb.com/chart/top/?ref_=nv_mv_250')
  const $ = await cheerio.load(data);
  
  const movies = $('td.titleColumn > a').map((i, el) => {
    return $(el).text();
  })
  .get();

  console.log(movies)


}

scrapeTitlesRanksAndRatings();



