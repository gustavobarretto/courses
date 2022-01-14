const puppeteer = require("puppeteer");

async function main() {
  try {
    const browser = await puppeteer.launch( { headless: false} )
    const page = await browser.newPage();
    await page.goto("https://www.ifood.com.br/");
    await page.click('#__next > section.landing-v2-multi-categories > div.landing-v2-multi-categories__wrapper > div > div:nth-child(1) > div', puppeteer.MouseButton)
    await page.click('body > div > div > div > div > div > div > div > div > div > div > div > button', puppeteer.MouseButton)
    await page.type('body > div:nth-child(19) > div > div > div > div > div > div:nth-child(2) > div > div.address-search-step > div.address-search-input.address-search-input--sticky > input', '41830380');
    await page.click('body > div:nth-child(19) > div > div > div > div > div > div:nth-child(2) > div > div.address-search-step > div.address-search-step__results > ul > li:nth-child(1) > div > button', puppeteer.MouseButton)

  } catch (err) {
    console.error(err);
  }
}

main();
