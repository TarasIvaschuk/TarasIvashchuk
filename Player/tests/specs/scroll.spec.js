import WelcomeScreen from '../screenobjects/welcome.screen';
import Gestures from '../helpers/Gestures';
import LogScreen from '../screenobjects/log.screen';
import HomeScreen from '../screenobjects/home.screen';
import ConnectionScreen from '../screenobjects/connection.screen';
import LessonScreen from '../screenobjects/lesson.screen';
import ControlScreen from '../screenobjects/control.screen';
import {onlineBoard} from '../constants';


describe ('scroll tests',function (){
    before(function (){
        browser.reset();
        WelcomeScreen.waitForShown();
        Gestures.swipeLeft();
        Gestures.swipeLeft();
        WelcomeScreen.login();
        LogScreen.waitForShown();  
        LogScreen.home();
        HomeScreen.waitForShown();
        HomeScreen.connect();
        ConnectionScreen.board(onlineBoard);
        HomeScreen.waitForShown();
    });

    it ('open the lesson', function(){
        HomeScreen.openlesson();
    });

    it('accept the first message', function(){
        ControlScreen.acceptWait();
    });

    it('swipe to 4 page', function(){
        LessonScreen.waitForShown();
        Gestures.swipeUp();
    });
    
    it ('click the 4 page', function(){
        LessonScreen.clickPage();
    });

    it ('return to Home page',function(){
        Gestures.back();
    });

    it ('accept the second message',function(){
        ControlScreen.acceptWait();
    });

    it ('verify we are on the 4 page',function(){
        HomeScreen.waitForShown();
        expect(HomeScreen.getPageLessonNumber().toLowerCase()).to.contain("5");
    });        
})