const SELECTORS = {
     PAGE :'(//android.widget.ImageView)[4]',
     WAIT :'(//android.widget.ImageView)[1]',
};

class LessonScreen {

    waitForShown () {
        $(SELECTORS.WAIT).waitForDisplayed();
    }

    clickPage(){
        $(SELECTORS.PAGE).waitForDisplayed();
        // browser.pause(10000);
        $(SELECTORS.PAGE).click();
        browser.pause(7000);
    }
}
 export default new LessonScreen ();
