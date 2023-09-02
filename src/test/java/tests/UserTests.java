package tests;

import dataprovider.MyDataProvider;
import endpoints.UserEndPoints;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.reqpojos.User;
import reports.ExtentLogger;

import java.util.Map;

public class UserTests {


    @Test(priority = 1, dataProvider = "getUserData", dataProviderClass = MyDataProvider.class)
    public void createUserTest(Map<String, String> map) {
        User user = new User();
        user.setId(Integer.parseInt(map.get("user_id")));
        user.setUsername(map.get("username"));
        user.setFirstName(map.get("firstname"));
        user.setLastName(map.get("lastname"));
        user.setEmail(map.get("email"));
        user.setPassword(map.get("password"));
        user.setPhone(map.get("phone"));

        Response response = UserEndPoints.createUser(user);
        response.then().log().all();

        ExtentLogger.logResponse(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 2, dataProvider = "getUserData", dataProviderClass = MyDataProvider.class)
    public void getUserTest(Map<String, String> map) {
        Response response = UserEndPoints.getUser(map.get("username"));
        response.then().log().all();

        ExtentLogger.logResponse(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    //
//    @Test(priority = 3)
//    public void updateUserTest(){
//
//        user.setFirstName(faker.name().firstName());
//        user.setLastName(faker.name().lastName());
//        user.setEmail(faker.internet().safeEmailAddress());
//
//        Response response = UserEndPoints.updateUser(user,user.getUsername());
//        response.then().log().all();
//
//        Assert.assertEquals(response.getStatusCode(), 200);
//
//        Response responseafterUpdate = UserEndPoints.getUser(user.getUsername());
//        responseafterUpdate.then().log().all();
//
//        Assert.assertEquals(responseafterUpdate.getStatusCode(), 200);
//    }
//
//    @Test(priority = 4, dataProvider = "getUserData", dataProviderClass = MyDataProvider.class)
//    public void deleteUserTest(Map<String, String> map) {
//        Response response = UserEndPoints.deleteUser(map.get("username"));
//        response.then().log().all();
//
//        Assert.assertEquals(response.getStatusCode(), 200);
//    }

}
