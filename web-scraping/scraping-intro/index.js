const axios = require('axios');
const fs = require('fs');
const cheerio = require('cheerio');

async function main() {
  const html = await axios.get("https://www.reactnativetutorial.net/css-selectors/lesson2.html");
  console.log(html.data)
  fs.writeFileSync('./test.html', html.data);
  const $ = await cheerio.load(html.data);

  $("h2").each( (index, element)  => {
    console.log($(element).text())
  })


  const ifoodTeste = await axios.get("https://www.ifood.com.br/restaurantes")
  const $2 = await cheerio.load(ifoodTeste.data);

  console.log($2(".address-search-input__button"));

}

main();