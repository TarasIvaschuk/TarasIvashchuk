const SELECTORS = {
    MESSAGE: '//*[@resource-id="Content"]/../*[1]',
      };

class PrivacyScreen {

    Message () {
         return $(SELECTORS. MESSAGE).getText();
    }

    waitForShown() {
        $(SELECTORS.MESSAGE).waitForDisplayed();
    }
}

export default new PrivacyScreen();
