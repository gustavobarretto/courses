const axios = require('axios');
const cheerio = require('cheerio');
const { testElement } = require('domutils');


async function main () {

  const { data } = await axios.get('https://www.booking.com/searchresults.pt-br.html?label=gen173nr-1DCAEoggI46AdILVgEaCCIAQGYAS24ARfIAQzYAQPoAQH4AQKIAgGoAgO4AsfT4pEGwAIB0gIkYTFlM2QzMDEtZmYxNC00YmJjLWE4ZWUtYjFjZjdiYmNjYjJj2AIE4AIB&lang=pt-br&sid=6e8d23d270e10e3a6c0b8f53f6c4fef1&sb=1&sb_lp=1&src=index&src_elem=sb&error_url=https%3A%2F%2Fwww.booking.com%2Findex.pt-br.html%3Flabel%3Dgen173nr-1DCAEoggI46AdILVgEaCCIAQGYAS24ARfIAQzYAQPoAQH4AQKIAgGoAgO4AsfT4pEGwAIB0gIkYTFlM2QzMDEtZmYxNC00YmJjLWE4ZWUtYjFjZjdiYmNjYjJj2AIE4AIB%3Bsid%3D6e8d23d270e10e3a6c0b8f53f6c4fef1%3Bsb_price_type%3Dtotal%26%3B&ss=Porto+de+Galinhas%2C+Pernambuco%2C+Brasil&is_ski_area=0&checkin_year=&checkin_month=&checkout_year=&checkout_month=&group_adults=2&group_children=0&no_rooms=1&b_h4u_keep_filters=&from_sf=1&ss_raw=Porto+de+Galinhas&ac_position=0&ac_langcode=xb&ac_click_type=b&dest_id=-663612&dest_type=city&place_id_lat=-8.50468&place_id_lon=-35.005&search_pageview_id=1eee74e308260348&search_selected=true');
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

  // const text = []
  // const description = $('#property_description_content').children().each( (index, element) => {
  //   text.push($(element).text());
  // })

  // console.log(text.join(' '))


  const starsList = [];
    $('._bebcf8d60').each( (index, element) => {
      const starsCounted = $(element).children().length;
      starsList.push(starsCounted);
    });

  console.log(starsList);

  


  // $('.hotel-facilities').find('.hotel-facilities__most-popular').children().children().each( (index, element) => {
  //   if(index > 0) {
  //     const text = $(element).text().replace(/^\s+|\s+$/g, '')
  //     const svg = $(element).html().match(/.+/, 'g')[0]
  //   } 
  // })
  



}

main();