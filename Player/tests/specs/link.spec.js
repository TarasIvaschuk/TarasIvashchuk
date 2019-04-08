import WelcomeScreen from '../screenobjects/welcome.screen';
import Gestures from '../helpers/Gestures';
import LogScreen from '..//screenobjects/log.screen';
import SmartScreen from '..//screenobjects/smart.screen';
import TermsScreen from '..//screenobjects/terms.screen';
import PrivacyScreen from '..//screenobjects/privacy.screen';


describe ('verify links',function(){
    
    describe('verify Smart link', function(){
        before(function(){
            browser.reset();
            WelcomeScreen.waitForShown();
            Gestures.swipeLeft();
            Gestures.swipeLeft();
            WelcomeScreen.login(); 
            LogScreen.waitForShown();     
        });
        it('click AboutSmart link button', function(){
            LogScreen.smart();
        });
    
        it('verify "transform static content" message', function(){ 
            SmartScreen.waitForShown();
            expect(SmartScreen.Message().toLowerCase()).to.contain("transform static content");
        });
    });

    describe('verify Privacy link', function(){
        before(function(){
            browser.reset();
            WelcomeScreen.waitForShown();
            Gestures.swipeLeft();
            Gestures.swipeLeft();
            WelcomeScreen.login(); 
            LogScreen.waitForShown();     
        });
        it('click Privacy link button',function(){
            LogScreen.privacy();
        });

        it('verify "privacy policies" message', function(){
            PrivacyScreen.waitForShown();
            expect(PrivacyScreen.Message().toLowerCase()).to.contain("privacy policies");
        });
    });

    describe('verify Terms link',function(){
        before(function(){
            browser.reset();
            WelcomeScreen.waitForShown();
            Gestures.swipeLeft();
            Gestures.swipeLeft();
            WelcomeScreen.login(); 
            LogScreen.waitForShown();     
        });
        it('click Terms Link button', function(){
            LogScreen.term();
        });
    
        it('verify "terms of use" message', function(){
            TermsScreen.waitForShown();          
            expect(TermsScreen.Message().toLowerCase()).to.contain("terms of use");
        });
    });
});
