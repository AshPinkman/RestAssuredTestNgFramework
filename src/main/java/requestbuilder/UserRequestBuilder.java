package requestbuilder;

import endpoints.Routes;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.reqpojos.User;

import static io.restassured.RestAssured.given;

public final class UserRequestBuilder {

    private UserRequestBuilder(){

    }

    public static Response createUser(User user) {
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(user)
                .when()
                .post(Routes.getPostUrl());

    }

    public static Response getUser(String userName) {
        return given()
                .pathParam("username", userName)
                .when()
                .get(Routes.getGetUrl());

    }

    public static Response updateUser(User user, String userName) {
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username", userName)
                .body(user)
                .when()
                .put(Routes.getUpdateUrl());

    }

    public static Response deleteUser(String userName) {
        return given()
                .pathParam("username", userName)
                .when()
                .delete(Routes.getDeleteUrl());

    }

}