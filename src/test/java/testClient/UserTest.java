package testClient;

import bl.AssertionsBase;
import bl.UserBl;
import builder.UserBuilder;
import client.UserClient;
import io.qameta.allure.Description;
import io.restassured.http.Header;
import io.restassured.response.Response;
import model.UserModel;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class UserTest {

    UserModel userModel;
    UserClient userClient;
    UserBl userBl;
    AssertionsBase asst;

    @BeforeTest
    public void init() {
        long thr = Thread.currentThread().getId();
        System.out.println("BeforeUserTest thread is " + thr);
        userClient = new UserClient();
        userBl = new UserBl();
        asst = new AssertionsBase();
        userModel = new UserBuilder()
                .userName("testUserName")
                .id(55)
                .firstName("testFirstName")
                .lastName("testlastName")
                .email("test@gmail.com")
                .password("testPassword")
                .phone("testPhone")
                .userStatus(55)
                .build();
    }

    @Test
    @Description("Post the User with valid data")
    public void PostUser() {
        long thr = Thread.currentThread().getId();
        System.out.println("PostUser thread is " + thr);
        Response response = userClient.postUser(userModel);
        for (Header header : response.headers()) {
            System.out.println(header.getName() + ":" + header.getValue());

        }

        asst.validateStatusLine200(response);

    }

    @Test
    @Description("Login the User with name and password")
    public void LoginUser() {
        long thr = Thread.currentThread().getId();
        System.out.println("LoginUser thread is " + thr);
        Response responseLoginUser = userClient.loginUser("test", "test");
        responseLoginUser.headers();
        for (Header header : responseLoginUser.headers()) {
            System.out.println(header.getName() + ":" + header.getValue());

        }
        ;
        asst.validateStatusLine200(responseLoginUser);
    }

    @Test
    @Description("Create the Users with array")
    public void createUserWithArray() {
        long thr = Thread.currentThread().getId();
        System.out.println("createUserWithArray thread is " + thr);
        List<UserModel> userModelList = new ArrayList<UserModel>();
        UserModel userModel1 = new UserBuilder()
                .userName("testUserName1")
                .id(551)
                .firstName("testFirstName1")
                .lastName("testlastName1")
                .email("test1@gmail.com")
                .password("testPassword1")
                .phone("testPhone1")
                .userStatus(551)
                .build();

        UserModel userModel2 = new UserBuilder()
                .userName("testUserName2")
                .id(552)
                .firstName("testFirstName2")
                .lastName("testlastName2")
                .email("test2@gmail.com")
                .password("testPassword2")
                .phone("testPhone2")
                .userStatus(552)
                .build();

        userModelList.add(userModel1);
        userModelList.add(userModel2);


        Response responseCreateUserList = userClient.createUserList(userModelList);
        responseCreateUserList.headers();
        for (Header header : responseCreateUserList.headers()) {
            System.out.println(header.getName() + ":" + header.getValue());

        }
        ;
        asst.validateStatusLine200(responseCreateUserList);
    }


    @Test
    @Description("Get the User by the name")
    public void getUserByName() {
        long thr = Thread.currentThread().getId();
        System.out.println("getUserByName thread is " + thr);
        Response responseLoginUser = userClient.getUser("string");
        responseLoginUser.headers();
        for (Header header : responseLoginUser.headers()) {
            System.out.println(header.getName() + ":" + header.getValue());
        }
        ;
        userBl.createUserModel(responseLoginUser);
        asst.validateUserName(responseLoginUser, "string");
    }

    @Test
    @Description("Update the User")
    public void updateUser() {
        long thr = Thread.currentThread().getId();
        System.out.println("updateUser thread is " + thr);
        Response responseLoginUser = userClient.updateUser("string", userModel);
        responseLoginUser.headers();
        for (Header header : responseLoginUser.headers()) {
            System.out.println(header.getName() + ":" + header.getValue());
        }
        ;
        asst.validateStatusLine200(responseLoginUser);
    }

    @Test
    @Description("Delete the User with valid name")
    public void delUserNameValid() {
        long thr = Thread.currentThread().getId();
        System.out.println("delUserNameValid thread is " + thr);
        Response response = userClient.postUser(userModel);
        Assert.assertEquals(response.statusCode(), 200);
        System.out.println("User created!");
        Response responseLoginUser = userClient.delPetByUserName("testUserName");
        responseLoginUser.headers();
        for (Header header : responseLoginUser.headers()) {
            System.out.println(header.getName() + ":" + header.getValue());
        }
        ;
        asst.validateStatusLine200(responseLoginUser);
    }


    @Test
    @Description("Delete the User with invalid name")
    public void delUserNameInValid() {
        long thr = Thread.currentThread().getId();
        System.out.println("delUserNameInValid thread is " + thr);
        Response response = userClient.postUser(userModel);
        asst.validateStatusLine200(response);
        System.out.println("User created!");
        Response responseLoginUser = userClient.delPetByUserName("Tessssssjhhjhjhjhjshh");
        responseLoginUser.headers();
        for (Header header : responseLoginUser.headers()) {
            System.out.println(header.getName() + ":" + header.getValue());
        }
        ;
        asst.validateStatusCode404(responseLoginUser);
    }

    @Test
    @Description("Log out the User")
    public void logOutUser() {
        long thr = Thread.currentThread().getId();
        System.out.println("logOutUser thread is " + thr);
        Response response = userClient.logOutUser();
        for (Header header : response.headers()) {
            System.out.println(header.getName() + ":" + header.getValue());
        }
        ;
        asst.validateStatusLine200(response);
    }

    @AfterTest
    void back() {
        long thr = Thread.currentThread().getId();
        System.out.println("AfterUserTest thread is " + thr);
        userClient.delPetByUserName("testUserName");
    }
}








