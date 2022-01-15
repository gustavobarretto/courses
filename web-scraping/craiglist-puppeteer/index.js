const puppeteer = require("puppeteer");
const cheerio = require("cheerio");

async function main() {
  try {
    const browser = await puppeteer.launch( { headless: false} )
    const page = await browser.newPage();
    await page.goto("https://www.ifood.com.br/");


    // Click in restaurant
    await page.click('#__next > section.landing-v2-multi-categories > div.landing-v2-multi-categories__wrapper > div > div:nth-child(1) > div', puppeteer.MouseButton)


    await sleep(1000);

    // Click in modal input to write the zipcoded
    await page.waitForSelector('.address-search-input__button')
    await page.click('.address-search-input__button');

    // Wait for rendering and type the zipcode
    await page.waitForSelector('.address-search-input__field')
    await page.type('.address-search-input__field', '41830380');

    // Wait for rendering and click on the button for the first zipcode address showed by the website
    await page.waitForSelector('.btn-address.btn-address--simple.btn-address__container')
    await page.click('.btn-address.btn-address--simple.btn-address__container');

    // Selecting the empty number in the street
    await page.waitForSelector('#addressEmptyNumber')
    await page.click('#addressEmptyNumber');

    // Confirm the address
    await sleep(3000);
    await page.waitForSelector('body > div:nth-child(16) > div > div > div > div > div > div:nth-child(2) > div > div.address-number.address-number--visible > div > form > button');
    await page.click('body > div:nth-child(16) > div > div > div > div > div > div:nth-child(2) > div > div.address-number.address-number--visible > div > form > button');

    // Confirm the map location
    await sleep(3000);
    await page.waitForSelector('body > div:nth-child(16) > div > div > div > div > div > div:nth-child(3) > div.address-maps__map > button');
    await page.click('body > div:nth-child(16) > div > div > div > div > div > div:nth-child(3) > div.address-maps__map > button');

    await page.waitForSelector('body > div:nth-child(16) > div > div > div > div > div > div:nth-child(3) > div.address-finder__complete-form.address-finder__complete-form--active > div.complete-address > form > div.complete-address--reference-point > div > label > input');
    await page.type('body > div:nth-child(16) > div > div > div > div > div > div:nth-child(3) > div.address-finder__complete-form.address-finder__complete-form--active > div.complete-address > form > div.complete-address--reference-point > div > label > input', '.')

    await page.click('body > div:nth-child(16) > div > div > div > div > div > div:nth-child(3) > div.address-finder__complete-form.address-finder__complete-form--active > div.complete-address > form > div.complete-address--favorites > div > button:nth-child(1)')
    await page.click('body > div:nth-child(16) > div > div > div > div > div > div:nth-child(3) > div.address-finder__complete-form.address-finder__complete-form--active > div.complete-address > form > div.complete-address--save-btn > button')


    await sleep(10000);
    const html = page.content();

    const $ = cheerio.load(html);

    console.log($.html());

    console.log('Cheguei aqui')

    console.log($('.small-banner-item'));

    $('.small-banner-item').each( (index, element) => {
      console.log($(element).attr('href'));
    })




  } catch (err) {
    console.error(err);
  }
}

async function sleep(miliseconds) {
  return new Promise( resolve => setTimeout(resolve, miliseconds));
}

main();
