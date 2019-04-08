import WelcomeScreen from '../screenobjects/welcome.screen';
import Gestures from '../helpers/Gestures';

describe ('verify Welcome messages',function (){
    browser.reset();
    it('verify "Welcome" message', function () {
        WelcomeScreen.waitForShown();
        expect(WelcomeScreen.textWelcome()).to.contain('Welcome');
    });

    it ('verify "Access" messaage', function () {
        Gestures.swipeLeft();
        expect(WelcomeScreen.textAccess()).to.contain('Access anywhere');
    });

    it ('verify "Room to roam" message', function () {
        Gestures.swipeLeft();
        expect(WelcomeScreen.textRoam()).to.contain('Room to roam');
    });
});