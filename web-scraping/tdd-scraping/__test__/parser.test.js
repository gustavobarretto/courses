const { isTag } = require("domhandler")
const parser = require("../parser")
const fs = require("fs");
const { hasUncaughtExceptionCaptureCallback } = require("process");
let html;
let listings;

beforeAll( () => {
  html = fs.readFileSync("./test.html");
  listings = parser.listings(html)
})

// const listings = [{
//   title: "Guitarist & 6 string bassist needed for new power trio",
//   url: "https://sfbay.craigslist.org/sfc/muc/d/san-francisco-guitarist-string-bassist/7432652582.html",
//   datePosted: new Date("2022-01-14"),
//   hood: "SOMA / south beach"

// }]

it("should give the correct number of listings", () => {
  expect(listings.length).toBe(120);
})

it("should get correct title", () => {
  expect(listings[0].title).toBe("Guitarist & 6 string bassist needed for new power trio");
})

it("should get correct url", () => {
  expect(listings[0].url).toBe("https://sfbay.craigslist.org/sfc/muc/d/san-francisco-guitarist-string-bassist/7432652582.html");
})

it("should get hood from listings correct", () => {
  expect(listings[0].hood).toBe("(SOMA / south beach)")
})

it("should get correct date from listings", () => {
  expect(listings[0].datePosted).toStrictEqual(new Date("2022-01-14 00:49"));
})
