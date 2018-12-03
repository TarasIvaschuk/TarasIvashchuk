package testClient;

import bl.AssertionsBase;
import bl.StoreBl;
import builder.StoreBuilder;
import client.StoreClient;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.StatusEnum;
import model.StoreModel;
import net.minidev.json.JSONObject;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class StoreTest {

    StoreModel storeModel;
    StoreClient storeClient;
    StoreBl storeBl;
    RequestSpecification request;
    JSONObject newStoreModel;
    AssertionsBase asst;

    @BeforeTest
    void init() {
        long thr = Thread.currentThread().getId();
        System.out.println("BeforeStoreTest thread is " + thr);
        asst = new AssertionsBase();
        request = RestAssured.given();
        storeClient = new StoreClient();
        storeBl = new StoreBl();
        newStoreModel = new JSONObject();
        newStoreModel.put("id", 45l);
        newStoreModel.put("petId", 45l);
        newStoreModel.put("quantity", 4l);
        newStoreModel.put("shipDate", "2018-11-25T13:19:23.059Z");
        newStoreModel.put("statusEnum", StatusEnum.SOLD.toString());
        newStoreModel.put("complete", true);

        storeModel = new StoreBuilder()
                .id(12)
                .petId(12)
                .quantity(2)
                .shipDate("2018-10-25T13:19:23.059Z")
                .status(StatusEnum.PENDING)
                .complete(true)
                .build();
    }

    @Test
    @Description("Get Store by the status")
    void getStoreByStatus() {
        long thr = Thread.currentThread().getId();
        System.out.println("getStoreByStatus thread is " + thr);
        storeClient.InvByStatus();
    }

    @Test
    @Description("Post the Store with valid data")
    void postStore() {
        long thr = Thread.currentThread().getId();
        System.out.println("postStore thread is " + thr);
        Response response = storeClient.postStore(newStoreModel);
        storeBl.createStoreModel(response);
        asst.validateServer(response);

    }

    @Test
    @Description("Find the Order with valid id")
    void findOrderByIdValid() {
        long thr = Thread.currentThread().getId();
        System.out.println("findOrderByIdValid thread is " + thr);
        Response response = storeClient.findOrderByIdValid(9);
        storeBl.createStoreModel(response);
        asst.validateId(response, 9);
    }

    @Test
    @Description("Find the Order with invalid id")
    void findOrderByIdInValid() {
        long thr = Thread.currentThread().getId();
        System.out.println("findOrderByIdInValid thread is " + thr);
        Response response = storeClient.findOrderByIdValid(90);
        asst.findOrderByIdInValid(response, 90);
    }

    @Test
    @Description("Delete the Order with valid id")
    void deleteOrderById() {
        long thr = Thread.currentThread().getId();
        System.out.println("deleteOrderById thread is " + thr);
        storeClient.postStore(storeModel);
        storeClient.deleteOrderById(12);
        Response response2 = storeClient.findOrderByIdValid(12);
        asst.findOrderByIdInValid(response2, 12);
    }

    @Test
    @Description("Delete the Order with invalid id")
    void deleteOrderByInValidId() {
        long thr = Thread.currentThread().getId();
        System.out.println("deleteOrderByInValidId thread is " + thr);
        storeClient.postStore(storeModel);
        Response response = storeClient.deleteOrderById(122);
        asst.validateStatusCode404(response);

    }

    @AfterTest
    void back() {
        long thr = Thread.currentThread().getId();
        System.out.println("AfterStoreTest thread is " + thr);
        storeClient.deleteOrderById(12);
    }
}


