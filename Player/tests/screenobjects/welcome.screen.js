const SELECTORS = {
    WELCOME_SCREEN: '//*[@text="Welcome!"]',
    ACCESS_SCREEN: '//*[@text="Access anywhere"]',
    ROAM_SCREEN: '//*[@text="Room to roam"]',
    LOGIN_SCREEN:'//*[@text="Room to roam"]/following-sibling::*[2]',
   };

class WelcomeScreen {
    
    textWelcome () {
        return $(SELECTORS. WELCOME_SCREEN).getText();
    }

    textAccess() {// 
        return $(SELECTORS. ACCESS_SCREEN).getText();
    }


    textRoam() {
        return $(SELECTORS. ROAM_SCREEN).getText();
    }

    login () {
        $(SELECTORS. LOGIN_SCREEN).click();
    }

    waitForShown() {
        $(SELECTORS.WELCOME_SCREEN).waitForDisplayed();
    }

    back () {
        browser.sendKeyEvent('4');
    }
}

export default new WelcomeScreen();
