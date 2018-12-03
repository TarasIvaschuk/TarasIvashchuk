package bl;

import io.restassured.response.Response;
import model.PetModel;
import org.testng.Assert;

import java.util.Iterator;
import java.util.List;

public class AssertionsBase {

    public AssertionsBase() {
    }

    public void validatePetName(Response response, String nameExpected) {
        String nameActual = response.getBody().asString();
        Assert.assertTrue(nameActual.contains(nameExpected), "Error getPetName");
    }

    public void validatePetStatus(List<PetModel> PetModelList, String status) {
        Iterator itr = PetModelList.iterator();
        while (itr.hasNext()) {
            String actualStatus = ((PetModel) itr.next()).getStatus();
            Assert.assertEquals(actualStatus, status);
        }
    }

    public void validateStatusLine200(Response response) {
        String Actual = response.statusLine();
        Assert.assertEquals(Actual, "HTTP/1.1 200 OK", "Error validateStatusLine200");
    }

    public void validateStatusCode404(Response response) {
        int Actual = response.statusCode();
        Assert.assertEquals(Actual, 404, "validateStatusCode404");
    }
    public void validateServer(Response response) {
        String Actual = response.header("server");
        Assert.assertEquals(Actual, "Jetty(9.2.9.v20150224)", "Error validateServer");
    }

    public void validateId(Response response, int id) {
        int Actual = response.getBody().jsonPath().get("id");
        Assert.assertEquals(Actual, id, "Error validateId ");
    }

    public void findOrderByIdInValid(Response response, int id) {
        try {
            int Actual = response.getBody().jsonPath().get("id");
        } catch (NullPointerException e) {
            System.out.println("Exception error verified");
        }
    }
    public void validateUserName(Response response, String name) {
        String Actual = response.getBody().jsonPath().get("username");
        Assert.assertEquals(Actual, name, "Error validateId ");
    }

}


