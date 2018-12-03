package bl;

import io.restassured.response.Response;
import model.PetModel;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class PetBl {

    public PetBl () {}


    public PetModel createPetModel(Response response) {
        Assert.assertEquals(response.getStatusCode(), 200);
        PetModel petmodel = response.as(PetModel.class);
        return petmodel;
    }

    public List<PetModel> createPetModelList(Response response, int statusCodeExpected) {
        List<PetModel> petmodel = null;
        PetModel[] petmodelArray = response.as(PetModel[].class);
        return Arrays.asList(petmodelArray);
    }

    }




