package bl;

import io.restassured.response.Response;
import model.UserModel;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class UserBl {
    public UserBl () {}

    public UserModel createUserModel(Response response) {
        Assert.assertEquals(response.getStatusCode(), 200);
        UserModel userModel = response.as(UserModel.class);
        return userModel;
    }
    public List<UserModel> createUserModelList(Response response, int statusCodeExpected) {
        Assert.assertEquals(response.getStatusCode(), 200);
        UserModel[] userModelArr = response.as(UserModel[].class);
        return Arrays.asList(userModelArr);
    }

}
