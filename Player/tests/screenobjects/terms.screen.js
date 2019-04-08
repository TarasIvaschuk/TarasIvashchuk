const SELECTORS = {
    MESSAGE: '//*[@resource-id="Content"]/*[1]',
      };

class TermsScreen {

    Message () {
         return $(SELECTORS. MESSAGE).getText();
    }

    waitForShown() {
        $(SELECTORS.MESSAGE).waitForDisplayed();
    }
}

export default new TermsScreen();
