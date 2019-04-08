const { join } = require('path');

config = {
    specs:['./tests/specs/**/*.spec.js'],
    port:4723,
    capabilities:[{  
        deviceName: 'Redmi',
        platformName: 'Android',
        platformVersion: '6.0.1',
        orientation: 'PORTRAIT',
        appPackage: "com.smarttech.teacher",
        appActivity: "com.smarttech.teacher.MainActivity",
        noReset: true,
        newCommandTimeout: 54,
    }],
    suites: {
        login: [
            './tests/specs/welcome.spec.js',
            './tests/specs/link.spec.js'
        ],
    },
    runner: 'local',
    framework: 'mocha',
    mochaOpts: {
        ui: 'bdd',
        timeout: 90000,
        compilers: ['js:@babel/register'],
    },
    sync: true,
    logLevel: 'debug',
    deprecationWarnings: true,
    bail: 0,
    waitforTimeout: 88000,
    connectionRetryTimeout: 100000,
    connectionRetryCount: 3,
    reporters: ['allure'],
    reporterOptions: {
        allure: {
            outputDir: 'allure-results',
            disableWebdriverStepsReporting: false,
            disableWebdriverScreenshotsReporting: false,
            useCucumberStepReporter: false
        }
    },

    before: function() {
        var chai = require('chai');
        global.expect = chai.expect;
        chai.Should();
    },

    afterTest: function(test) {
        if (test.error !== undefined) {
          browser.takeScreenshot();
        }
      },  
}


exports.config = config;