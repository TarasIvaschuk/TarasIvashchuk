package testClient;

import bl.AssertionsBase;
import bl.PetBl;
import builder.PetBuilder;
import client.PetClient;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import model.CategoryPet;
import model.PetModel;
import model.TagModel;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class PetTest {

    PetModel petModel;
    PetClient petClient;
    PetBl petBl;

    //todo add alure anotations
    @BeforeTest
    void init() {
        long thr = Thread.currentThread().getId();
        System.out.println("BeforePetTest thread is " + thr);
        petClient = new PetClient();
        petBl = new PetBl();
        CategoryPet categoryPet = new CategoryPet();
        categoryPet.setId(5000);
        categoryPet.setName("Doggie");

        ArrayList<TagModel> tags = new ArrayList<TagModel>();
        TagModel tagModel = new TagModel("Doggie", 5000);
        tags.add(tagModel);
        ArrayList<String> photoUrls = new ArrayList<String>();
        photoUrls.add("Newimage.jpg");
        petModel = new PetBuilder()
                .name("Doggie")
                .id(5000)
                .status("pending")
                .category(categoryPet)
                .tags(tags)
                .photoUrls(photoUrls)
                .build();

        Response response = petClient.postPet(petModel);
        petBl.createPetModel(response);
    }

    @Test
    @Description("Post the Pet with the Json Model")
    public void postPet() {
        long thr = Thread.currentThread().getId();
        System.out.println("postPet thread is " + thr);
        Response postPet = petClient.postPet(petModel);
        petBl.createPetModel(postPet);
        Response getPetById = petClient.getPetById(5000);
        (new AssertionsBase()).validatePetName(getPetById, "Doggie");
    }

    @Test
    @Description("Delete the Pet with valid status")
    public void getPetByStatusValid() {
        long thr = Thread.currentThread().getId();
        System.out.println("getPetByStatusValid thread is " + thr);
        Response getPetByStatus = petClient.getPetByStatus("sold");
        List<PetModel> PetModelList = petBl.createPetModelList(getPetByStatus, 200);
        (new AssertionsBase()).validatePetStatus(PetModelList, "sold");

    }

    @Test
    @Description("Delet the Pet with invalid status")
    public void getPetByStatusInvalid() {
        long thr = Thread.currentThread().getId();
        System.out.println("getPetByStatusInvalid thread is " + thr);
        Response getPetByStatus = petClient.getPetByStatus("test");
        List<PetModel> PetModelList = petBl.createPetModelList(getPetByStatus, 400);
        (new AssertionsBase()).validatePetStatus(PetModelList, "test");

    }

    @Test
    @Description("Delete the Pet with valid id")
    public void getPetByIdValid() {
        long thr = Thread.currentThread().getId();
        System.out.println("getPetByIdValid thread is " + thr);
        Response getPetByIdValid = petClient.getPetById(5000);
        petBl.createPetModel(getPetByIdValid);
        (new AssertionsBase()).validateStatusLine200(getPetByIdValid);

    }

    @Test
    @Description("Delete the Pet with invalid id")
    public void getPetByIdInvalid() {
        long thr = Thread.currentThread().getId();
        System.out.println("getPetByIdInvalid thread is " + thr);
        Response getPetByIdInvalid = petClient.getPetById(0);
        (new AssertionsBase()).validateStatusCode404(getPetByIdInvalid);
    }

    @Test
    @Description("Update the Pet with form data")
    public void updatePetWithFormData() {
        long thr = Thread.currentThread().getId();
        System.out.println("updatePetWithFormData thread is " + thr);
        petClient.updatePetWithFormData(5000, "Doggie3", "sold");
        Response getPetByIdValid = petClient.getPetById(5000);
        (new AssertionsBase()).validatePetName(getPetByIdValid, "Doggie3");
    }

    @Test
    @Description("Upload the image to Pet with valid id")
    public void UploadImageValidId() {
        long thr = Thread.currentThread().getId();
        System.out.println("UploadImageValidId thread is " + thr);
        Response UploadImageValidId = petClient.postPetByUploadImage(4, "test", "D:\\workspace\\TestApi\\src\\test\\resources\\NewImage.jpg");
        petBl.createPetModel(UploadImageValidId );
        (new AssertionsBase()).validateStatusLine200(UploadImageValidId );
    }

    @Test
    @Description("Upload the image to Pet with invalid id")
    public void UploadImageInValidId() {
        long thr = Thread.currentThread().getId();
        System.out.println("postPetByUploadImageInValidId thread is " + thr);
        Response UploadImageInValidId= petClient.postPetByUploadImage(4449444044499999977l, "test", "D:\\workspace\\TestApi\\src\\test\\resources\\NewImage.jpg");
        (new AssertionsBase()).validateStatusCode404(UploadImageInValidId);

    }

    @Test
    @Description("Put the Pet")
    public void putPet() {
        long thr = Thread.currentThread().getId();
        System.out.println("putPet thread is " + thr);
        Response putPet = petClient.putPet(petModel);
        petBl.createPetModel(putPet);
        (new AssertionsBase()).validateServer(putPet);
    }

    @Test
    @Description("Delete the Pet with valid id")
    public void delPetByIdValidId() {
        long thr = Thread.currentThread().getId();
        System.out.println("delPetByIdValidId thread is " + thr);
        Response delPetByIdValidId = petClient.delPetById(5000l, "test");
        (new AssertionsBase()).validateStatusLine200(delPetByIdValidId);

    }

    @Test
    @Description("Delete the Pet with invalid id")
    public void delPetByInvalidId() {
        long thr = Thread.currentThread().getId();
        System.out.println("delPetByInvalidId thread is " + thr);
        Response delPetByInvalidId = petClient.delPetById(1, "test");
        (new AssertionsBase()).validateStatusCode404(delPetByInvalidId);

    }

    @AfterTest
    void back() {
        long thr = Thread.currentThread().getId();
        System.out.println("AfterPetTest thread is " + thr);
        petClient.delPetById(5000l, "test");
    }
}




