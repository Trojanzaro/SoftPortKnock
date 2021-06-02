const puppeteer = require('puppeteer');

//Usage: node open_ports.js <gateway_password> <port_to_delete>

(async () => {
    const browser = await puppeteer.launch();
    const page = await browser.newPage();
    await page.goto('http://192.168.0.1/');

    await page.type('#login-password', process.argv[2]);
    await page.click('#subBtn');
    await page.waitForNavigation({ waitUntil: 'networkidle0' });
    await page.click('a[href="#advance"]');

    await page.click('#adv_virtualServer');
    await page.frames()[1].waitForSelector('#portBody');

    //pulled this from stackoverflow. hope it works
    const numberOfRows = await page.frames()[1].$$eval('table > tbody#portBody > tr', rows => rows.length)
    for (let n = 1; n < numberOfRows + 1; n++) {
        const currentUser = `table > tbody#portBody > tr:nth-child(${n}) > td:nth-child(2)` // nth row 2nd column
        const currentOpti = `table > tbody#portBody > tr:nth-child(${n}) > td:nth-child(5) > span` // nth row 3rd column
        const currentUserString = await page.frames()[1].$eval(currentUser, el => el.innerHTML)
        if (currentUserString === process.argv[3]) {
            try {
                await page.frames()[1].click(currentOpti)
            } catch {}
        }
    }

    await page.close();
    process.exit(1);
})();
