package bl;

import io.restassured.response.Response;
import model.StoreModel;
import org.testng.Assert;

public class StoreBl {
public StoreBl (){};
    public StoreModel createStoreModel(Response response) {
        Assert.assertEquals(response.getStatusCode(), 200);
        StoreModel storeModel = response.as(StoreModel.class);
        return storeModel;
    }
}
