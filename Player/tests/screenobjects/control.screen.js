const SELECTORS = {
    WAIT: '(//android.widget.TextView)[3]',
};

class ControlScreen {
    acceptWait() {
        $(SELECTORS.WAIT).waitForDisplayed();
        $(SELECTORS.WAIT).click();
    }
}
export default new ControlScreen();
