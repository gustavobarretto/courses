const axios = require('axios');
const cheerio = require('cheerio');


async function main () {

  const { data } = await axios.get('https://www.booking.com/hotel/br/you-stay-at-vila-olimpia.pt-br.html?label=gen173nr-1DCAEoggI46AdILVgEaCCIAQGYAS24ARfIAQzYAQPoAQH4AQKIAgGoAgO4Apja1pEGwAIB0gIkYWEwNTc4N2UtZTQ2ZC00OGEyLThmYWQtMWNhZTBlMTIxODU22AIE4AIB&sid=6e8d23d270e10e3a6c0b8f53f6c4fef1&aid=304142&ucfs=1&arphpl=1&group_adults=2&req_adults=2&no_rooms=1&group_children=0&req_children=0&hpos=1&hapos=1&sr_order=popularity&srpvid=2e79480f842300c9&srepoch=1647684896&from_sustainable_property_sr=1&from=searchresults#hotelTmpl');
  const $ = cheerio.load(data);
  $('.bh-photo-grid-item').each( (index, element) => console.log($(element).attr('style').match( /(https:\/\/.+)\)/, 'g')[1] ));
}

main();