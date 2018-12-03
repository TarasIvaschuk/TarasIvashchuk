package client;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.UserModel;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserClient {

    public UserClient() {
    }


    public Response getUser(String userName) {

        Response ResponseGetUserByUserName = given()
                .baseUri("https://petstore.swagger.io/v2/user/")
                .contentType(ContentType.JSON)
                .get(userName);
        return ResponseGetUserByUserName;
    }

    public Response postUser(UserModel userModel) {

        RequestSpecification request = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://petstore.swagger.io/v2/user")
                .build();
        return given(request)
                .body(userModel)
                .post();

    }

    public Response loginUser(String name, String password) {

        Response responseLoginUser = given()
                .queryParam("username", name)
                .queryParam("password", password)
                .baseUri("https://petstore.swagger.io/v2/user/login")
                .contentType(ContentType.JSON)
                .get();

        return responseLoginUser;
    }
    public Response createUserList(List<UserModel> userModelList) {

        Response createUserList = given()
                .baseUri("https://petstore.swagger.io/v2/user/createWithArray")
                .contentType(ContentType.JSON)
                .body(userModelList)
                .post();

        return createUserList;
    }

    public Response updateUser(String userName, UserModel userModel) {

        Response updateUser = given()
                .baseUri("https://petstore.swagger.io/v2/user/"+userName)
                .contentType(ContentType.JSON)
                .body(userModel)
                .put();

        return updateUser;
    }

    public Response delPetByUserName(String userName) {
        RequestSpecification request = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON);

        Response delPetByUserName = given(request)
                .delete("https://petstore.swagger.io/v2/user/" + userName);

        return delPetByUserName;

    }

    public Response logOutUser() {
        Response logOutUser = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .get("https://petstore.swagger.io/v2/user/logout");
        return logOutUser;

    }
}


