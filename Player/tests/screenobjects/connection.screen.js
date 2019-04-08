const SELECTORS = {
      TITLE: '(//android.view.ViewGroup/android.widget.TextView)[1]'
    , ДОШКА1:'//android.view.ViewGroup/android.widget.TextView[@text="дошка1"]'
    , BOA2CRD:'//android.view.ViewGroup/android.widget.TextView[@text="boa%2Crd"]'
};

class ConnectionScreen {

    getTitleText () {
         return $(SELECTORS. TITLE).getText();
    }

    board (boardName) {

        $(SELECTORS[boardName.toUpperCase()]).click();
    }

    waitForShown() {
        $(SELECTORS.TITLE).waitForDisplayed();
    }
}

export default new ConnectionScreen();
