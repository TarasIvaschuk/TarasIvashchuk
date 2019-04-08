const SELECTORS = {
    MESSAGE: 
    // ,'//*[@resource-id="header"]/following-sibling::*[1]/*[1]/*[1]'
    "(//android.view.View[contains(@text,'static')])[1]"
      };

class SmartScreen {

    Message () {
         return $(SELECTORS. MESSAGE).getText();
    }

    waitForShown() {
        $(SELECTORS.MESSAGE).waitForDisplayed();
    }

}

export default new SmartScreen();
