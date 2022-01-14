const cheerio = require("cheerio");

function getDatedPosted($, element) {
  return new Date($(element).find(".result-date").attr("datetime"))
}

function getHood($, element) {
  return $(element).find(".result-hood").text().trim();
}

exports.listings = (html) => {
  const $ = cheerio.load(html);
  return $(".result-info").map( (index, element) => {
    const title = $(element).find(".result-title.hdrlnk").text();
    const url = $(element).find(".result-title.hdrlnk").attr("href");
    const hood = getHood($, element);
    const datePosted = getDatedPosted($, element);
    return { title, url, hood, datePosted }
  }).get()
}