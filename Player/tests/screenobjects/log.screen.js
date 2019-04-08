const SELECTORS = {
    EMAIL_SCREEN: "//*[@resource-id='sso_signin']",
    SMART_SCREEN:'//*[contains(@text, "About")]',
    PRIVACY_SCREEN:'//*[contains(@text, "Privacy")]',
    TERMS_SCREEN:'//*[contains(@text, "Terms")]',
};

class LogScreen {
    

    home () {
        $(SELECTORS.EMAIL_SCREEN).click();
    }

    smart () {
        $(SELECTORS. SMART_SCREEN).click();
    }

    privacy () {
        $(SELECTORS. PRIVACY_SCREEN).click();
    }

    term () {
        $(SELECTORS. TERMS_SCREEN).click();
    }

    help () {
        $(SELECTORS. HELP_SCREEN).click();
    }

    waitForShown() {
        $(SELECTORS.EMAIL_SCREEN).waitForDisplayed();
    }
}

export default new LogScreen();
