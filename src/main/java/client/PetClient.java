package client;

import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.PetModel;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;


public class PetClient {
    public PetClient(){}

    @Step("send a request and get a JSON response")
    public Response getPetById(int id) {

        Response responseGetPetById = given()
                .baseUri("https://petstore.swagger.io/v2")
                .contentType(ContentType.JSON)
                .get("/pet/" + id);
        return responseGetPetById;
    }

    public Response getPetByStatus(String statusValue) {

        Response responseGetPetByStatus = given()
                .queryParam("statusEnum", statusValue)
                .baseUri("https://petstore.swagger.io/v2")
                .contentType(ContentType.JSON)
                .get("/pet/findByStatus");

        return responseGetPetByStatus;
    }

    public Response postPet(PetModel petModel) {

        RequestSpecification request = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://petstore.swagger.io/v2/pet")
               // .setBody(petModel)
                .build();
       return given(request)
                .body(petModel)
                .post();

           }

    public Response updatePetWithFormData(int id, String updatedName, String updatedStatus) {

        Map<String, String> jsonAsMap = new HashMap<String, String>();
        jsonAsMap.put("name", updatedName);
        jsonAsMap.put("statusEnum", updatedStatus);

        RequestSpecification request = new RequestSpecBuilder()
                .addFormParams(jsonAsMap)
                .build();
        Response responseUpdatePetWithFormData = given(request).post("https://petstore.swagger.io/v2/pet/" + id);

        return responseUpdatePetWithFormData;

    }

    public Response postPetByUploadImage(long ids, String Metadata, String fileName) {

        RequestSpecification request = new RequestSpecBuilder()
                .addHeader("Content-Type", "multipart/form-data")
                .addFormParam("additionalMetadata", Metadata)
                .addMultiPart(new File(fileName))
                .setAccept(ContentType.JSON)
                .build();

        Response responsePostPetByUploadImage = given(request).post("https://petstore.swagger.io/v2/pet/" + ids + "/uploadImage");

        return responsePostPetByUploadImage;


    }

    public Response putPet(PetModel petmodel) {

        RequestSpecification request = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(petmodel);

        Response putPet =given(request).put(" https://petstore.swagger.io/v2/pet");

        return putPet;


    }

    public Response delPetById(long id, String apiKey) {
        RequestSpecification request = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON);

        Response delPetById = given(request)
                //.baseUri("https://petstore.swagger.io/v2")
                .header("api_key", apiKey)
                .delete("https://petstore.swagger.io/v2/pet/" + id);

        return delPetById;

    }
}
