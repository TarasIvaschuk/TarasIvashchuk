const SELECTORS = {
    TITLE: '//android.widget.ScrollView/preceding-sibling::*[2]',

    MENU: '(//android.widget.ImageView)[1]',

    ACCOUNT:'(//android.widget.TextView)[6]',

    SIGNOUT:'(//android.widget.ImageView)[6]',

    CONNECTION_BUTTON:'(//android.widget.ImageView)[2]',
    
    LESSON:'//android.widget.ScrollView/./*',

    PAGE_LESSON_NUMBER:'(//android.widget.TextView)[6]',
};

class HomeScreen {
    
    menu () {
         $(SELECTORS. MENU).click();
    }

    getAccountText() {
        return $(SELECTORS. ACCOUNT).getText();
    }

    signout () {
        $(SELECTORS.SIGNOUT).click();
    }

    connect () {
        $(SELECTORS.CONNECTION_BUTTON).click();
    }

    openlesson () {
        $(SELECTORS.LESSON).click();
    }

    waitForShown() {
        $(SELECTORS.TITLE).waitForDisplayed();
    }

    getPageLessonNumber() {
        return $(SELECTORS.PAGE_LESSON_NUMBER).getText();
    }
}

export default new HomeScreen();
