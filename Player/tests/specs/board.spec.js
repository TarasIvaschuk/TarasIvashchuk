import WelcomeScreen from '../screenobjects/welcome.screen';
import Gestures from '../helpers/Gestures';
import LogScreen from '../screenobjects/log.screen';
import HomeScreen from '../screenobjects/home.screen';
import Alert from '../helpers/Alert';
import ConnectionScreen from '../screenobjects/connection.screen';
import {offlineBoard} from '../constants';
import {onlineBoard} from '../constants';

describe('verify boards',function (){
    describe('verify non cached successful connection, when board is offline',function (){
        before (function (){
            browser.reset();
            WelcomeScreen.waitForShown();
            Gestures.swipeLeft();
            Gestures.swipeLeft();
            WelcomeScreen.login();
            LogScreen.waitForShown();  
            LogScreen.home();
            HomeScreen.waitForShown();
        });

        it ('click connect button',function(){
            HomeScreen.connect();
        });            
            
        it ('click the offline board button',function(){
            ConnectionScreen.waitForShown();
            ConnectionScreen.board(offlineBoard);
        });

        it ('verify "is offline" message',function(){
            Alert.waitForShown();
            expect(Alert.getText().toLowerCase()).to.contain("is offline");
        });
    });
            
    describe('verify cancel is successful, when board is offline', function() {
        before (function (){
            browser.reset();
            WelcomeScreen.waitForShown();
            Gestures.swipeLeft();
            Gestures.swipeLeft();
            WelcomeScreen.login();
            LogScreen.waitForShown();  
            LogScreen.home();
            HomeScreen.waitForShown();
        });

        it ('click connect button', function(){
            HomeScreen.connect();
        });

        it ('click the offline board button',function(){
            ConnectionScreen.waitForShown();
            ConnectionScreen.board(offlineBoard);   
        });

        it ('click the cancel button',function(){
            Alert.waitForShown();
            Alert.pressButton("Cancel");
        });
            
        it ('verify alert successfully dissapeared', function(){
            expect(Alert.waitForIsShown(false)).to.equal(undefined);        
        });        
    });
    
    describe('verify cached successful connection, when board is offline', function() {
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
            ConnectionScreen.waitForShown();
            ConnectionScreen.board(offlineBoard);
            Alert.waitForShown();
        });

        it ('close App and wait for 7 seconds',function(){
            browser.closeApp();
            browser.pause(7000);
        });

        it ('launch App and wait for automatic connection',function(){
            browser.launchApp();
            Alert.waitForShown();
        });

        it ('verify the board is offline',function(){
            expect(Alert.getText().toLowerCase()).to.contain("is offline");
        });
            
    });
    
    describe('verify cancel is successful, when cached board is offline', function() {
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
            ConnectionScreen.waitForShown();
            ConnectionScreen.board(offlineBoard);
            Alert.waitForShown();
        });

        it('to close App and wait for 7 seconds',function(){
            browser.closeApp();
            browser.pause(7000);
        });

        it('launch App wait for automatic connection',function(){
            browser.launchApp();
            Alert.waitForShown();
        });

        it ('click "Cancel" button',function(){
            Alert.pressButton("Cancel");
        });  
        
        it ('verify the alert has been successfuly dissapeared',function(){
            expect(Alert.waitForIsShown(false)).to.equal(undefined);
        });  
    });

    describe.only('verify non cached online board successful connection', function (){
        before(function (){
            browser.reset();
            WelcomeScreen.waitForShown();
            Gestures.swipeLeft();
            Gestures.swipeLeft();
            WelcomeScreen.login();
            LogScreen.waitForShown(); 
            LogScreen.home();
            HomeScreen.waitForShown();  
        });

        it('click connect button', function() {
            HomeScreen.connect(); 
            ConnectionScreen.waitForShown ();
        });

        it ('click board button', function(){
            ConnectionScreen.board(onlineBoard);
        });

        it ('click connect button',function(){
            HomeScreen.connect(); 
        });

        it ('verify "connected to" message', function(){
            Alert.waitForShown();
            expect(Alert.getText().toLowerCase()).to.contain("connected to");
        }); 
    });
             
    describe.only('verify non cached online board successful disconnection', function() {
        before(function (){
            browser.reset();
            WelcomeScreen.waitForShown();
            Gestures.swipeLeft();
            Gestures.swipeLeft();
            WelcomeScreen.login();
            LogScreen.waitForShown(); 
            LogScreen.home();
            HomeScreen.waitForShown();  
        });

        it ('click connect button', function (){
            HomeScreen.connect();
            ConnectionScreen.waitForShown ();  
        })

        it ('click board button', function (){
            ConnectionScreen.board(onlineBoard);
            HomeScreen.waitForShown ();
        });

        it ('click connect button',function(){
            HomeScreen.connect(); 
        });

        it ('click "Disconnect" button',function(){
            Alert.waitForShown();
            Alert.pressButton("Disconnect");
        });

        it ('to verify successful disconnection by checking the alert to have successfully dissapeared',function(){
            expect(Alert.waitForIsShown(false)).to.equal(undefined);   
        });
    });
    
    describe ('verify cached successful connection, when board is online', function() {
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
            ConnectionScreen.waitForShown();
            ConnectionScreen.board(onlineBoard);
            HomeScreen.waitForShown();
        });

        it ('close App and wait for 7 seconds', function(){
            browser.closeApp();
            browser.pause(7000);
        });

        it ('launch App and wait for automatic connection',function(){
            browser.launchApp();
            HomeScreen.waitForShown();
        });

        it ('click connect button',function(){
            HomeScreen.connect();
        });

        it ('verify the successful connection',function(){
            Alert.waitForShown();
            expect(Alert.getText().toLowerCase()).to.contain("connected to");
        });
            
    });
        
    describe('verify disconnection is successful, when cached board is online', function() {
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
            ConnectionScreen.waitForShown();
            ConnectionScreen.board(onlineBoard);
            HomeScreen.waitForShown();
        });
            
        it ('close App and wait for 7 seconds',function(){
            browser.closeApp();
            browser.pause(7000);    
        });

        it ('launch App and wait for automatic connection',function(){
            browser.launchApp();
            HomeScreen.waitForShown();
        });

        it ('click connect button',function(){
            HomeScreen.connect();
        });

        it ('click "Disconnect" button',function(){
            Alert.waitForShown();
            Alert.pressButton("Disconnect");
        });

        it ('verify the allert has been successfuly dissapeared',function(){
            expect(Alert.waitForIsShown(false)).to.equal(undefined);
        });
    });
});
          



            
            
