const axios = require('axios')
const cheerio = require('cheerio');

async function main () {
  const result = await axios.get("https://www.codingwithstefan.com/table-example/");

  const $ = cheerio.load(result.data);

  $("body > table > tbody > tr").each( (index, el) => {

    const tds = $(el).find('td');

    if($(tds).text() !== '') console.log(`
      name: ${$(tds[0]).text()}
      contact: ${$(tds[1]).text()}
      country: ${$(tds[2]).text()}
    `)
  });

}

main();
