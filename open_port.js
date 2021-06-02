const puppeteer = require('puppeteer');

//Usage: node open_ports.js <gateway_password> <ip_to_foward> <port_to_foward>
(async () => {
    const browser = await puppeteer.launch();
    const page = await browser.newPage();
    await page.goto('http://192.168.0.1/');

    await page.type('#login-password', process.argv[2]);
    await page.click('#subBtn');
    await page.waitForNavigation({ waitUntil: 'networkidle0' });
    await page.click('a[href="#advance"]');

    await page.click('#adv_virtualServer');
    await page.waitForXPath('//input');
    await page.frames()[1].type('#ip', process.argv[3]);
    await page.frames()[1].type('#outPort', process.argv[4]);
    await page.frames()[1].$eval('input[class="input-box span1"]', el => el.value = '');
    await page.frames()[1].type('input[class="input-box span1"]', process.argv[4]);

    await page.frames()[1].click('input[value="+New"]');

    await page.close();
    process.exit(1);
})();
