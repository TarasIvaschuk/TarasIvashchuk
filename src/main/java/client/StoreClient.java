package client;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.StoreModel;
import net.minidev.json.JSONObject;

import static io.restassured.RestAssured.given;

public class StoreClient {

    public void InvByStatus() {
        RequestSpecification request = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON);

        String getInvByStatus=
                given(request).auth().preemptive().basic("username", "password")
                        .when().get("https://petstore.swagger.io/v2/store/inventory").then().statusCode(200).toString();
        System.out.println(getInvByStatus);

    }
    public Response postStore(JSONObject jsonObj) {

        RequestSpecification request = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://petstore.swagger.io/v2/store/order")
                .build()
                .body(jsonObj);
                Response response= given(request).post();
        return response;

    }
//overloading
    public Response postStore(StoreModel storeModel) {

        RequestSpecification request = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://petstore.swagger.io/v2/store/order")
                .build()
                .body(storeModel);
        Response response= given(request).post();
        return response;
    }

    public Response findOrderByIdValid (long id) {

            Response findOrderByIdValid = given()
                    .baseUri("https://petstore.swagger.io/v2/store/order/"+id)
                    .contentType(ContentType.JSON)
                    .get();

            return findOrderByIdValid;
        }

    public Response deleteOrderById (long id) {

        Response deleteOrderById = given()
                .baseUri("https://petstore.swagger.io/v2/store/order/"+id)
                .contentType(ContentType.JSON)
                .delete();

        return deleteOrderById;
    }


}

