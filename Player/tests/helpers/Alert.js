const SELECTORS = {
        ALERT_TITLE: '//android.widget.TextView[@resource-id="android:id/alertTitle"]',
        ALERT_BUTTON: '//android.widget.Button[@text="{BUTTON_TEXT}"]',
    
};




class Alert {

    static waitForIsShown (isShown=true) {
         $(SELECTORS.ALERT_TITLE).waitForExist(30000, !isShown);
    }

    static waitForShown(){
        $(SELECTORS.ALERT_TITLE).waitForDisplayed();
    }

    static pressButton (selector) {
        const buttonSelector = SELECTORS.ALERT_BUTTON.replace(/{BUTTON_TEXT}/, selector);
        $(buttonSelector).click();
    }

    static getAlertText () {
        return driver.getAlertText();
    }

    static getText () {
        return $(SELECTORS.ALERT_TITLE).getText();
    }
}

export default Alert;
