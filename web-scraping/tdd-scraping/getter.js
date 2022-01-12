const axios = require("axios");
const fs = require("fs");

async function getHtml(url) {
  const response = await axios.get(url);
  const html = response.data;
  return html;
}

function saveHtmlTofile(html) {
  fs.writeFileSync('./test.html', html);
}


async function main() {
  const html = await getHtml("https://sfbay.craigslist.org/d/musicians/search/muc");
  saveHtmlTofile(html);
}

main();