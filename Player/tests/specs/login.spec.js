import WelcomeScreen from '../screenobjects/welcome.screen';
import Gestures from '../helpers/Gestures';
import LogScreen from '..//screenobjects/log.screen';
import HomeScreen from '..//screenobjects/home.screen';

describe ("Verify login/unlogin", function() {
    describe ('verify login', function(){
        before(function() {
            browser.reset();
            WelcomeScreen.waitForShown();
            Gestures.swipeLeft();
            Gestures.swipeLeft();
            WelcomeScreen.login(); 
            LogScreen.waitForShown();       
        });

        it('click on account button', function () {
            LogScreen.home();
        });

        it('click on menu button', function () {
            HomeScreen.waitForShown();
            HomeScreen.menu();
        });

        it('verify the account message text', function () {
            expect(HomeScreen.getAccountText().toLowerCase()).to.contain("tarasivashchuk");
        });
    });  
    
    describe('verify successful unlogin',function(){
        before(function() {
            browser.reset();
            WelcomeScreen.waitForShown();
            Gestures.swipeLeft();
            Gestures.swipeLeft();
            WelcomeScreen.login(); 
            LogScreen.waitForShown();       
        });

        it ('click on account button',function(){
            LogScreen.home();

        });

        it ('click on menu button',function(){
            HomeScreen.waitForShown();
            HomeScreen.menu();
        });

        it ('click on the Signout button', function(){
            HomeScreen.waitForShown();
            HomeScreen.signout();
        })

        it ('verify successful unlogin',function(){         
            expect(WelcomeScreen.textWelcome()).to.contain('Welcome!'); 
        });
    });    
})
