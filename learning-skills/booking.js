const axios = require('axios');
const cheerio = require('cheerio');
const { testElement } = require('domutils');


async function main () {

  const { data } = await axios.get('https://www.booking.com/hotel/br/you-stay-at-vila-olimpia.pt-br.html?aid=304142;label=gen173nr-1DCAEoggI46AdILVgEaCCIAQGYAS24ARfIAQzYAQPoAQH4AQKIAgGoAgO4Apja1pEGwAIB0gIkYWEwNTc4N2UtZTQ2ZC00OGEyLThmYWQtMWNhZTBlMTIxODU22AIE4AIB;sid=6e8d23d270e10e3a6c0b8f53f6c4fef1;dist=0;group_adults=2;group_children=0;hapos=1;hpos=1;no_rooms=1;req_adults=2;req_children=0;room1=A%2CA;sb_price_type=total;sr_order=popularity;srepoch=1647684896;srpvid=2e79480f842300c9;type=total;ucfs=1&#hotelTmpl');
  const $ = cheerio.load(data);
  // $('.bh-photo-grid-item').each( (index, element) => console.log($(element).attr('style').match( /(https:\/\/.+)\)/, 'g')[1] ));

  // $('.ee947f0dc1').each( (index, element) => {
  //   const icon = $(element).find('._3ae5d40db').html();
  //   const iconName = $(element).find('._dc55ee131').text();
  //   console.log({
  //     iconName,
  //     icon
  //   })
  // });

  // console.log($('.hp_address_subtitle').text());

  const text = []
  const description = $('#property_description_content').children().each( (index, element) => {
    text.push($(element).text());

    
    
  })

  console.log(text.join(' '))

  


  // $('.hotel-facilities').find('.hotel-facilities__most-popular').children().children().each( (index, element) => {
  //   if(index > 0) {
  //     const text = $(element).text().replace(/^\s+|\s+$/g, '')
  //     const svg = $(element).html().match(/.+/, 'g')[0]
  //   } 
  // })
  



}

main();