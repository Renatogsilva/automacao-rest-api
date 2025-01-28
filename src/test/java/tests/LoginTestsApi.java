package tests;

import api.user.UserPostRequest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import utils.Factory;
import utils.VariaveisGlobais;

public class LoginTestsApi {
    private UserPostRequest postRequest = new UserPostRequest();

    @Test
    public void testLogin() {
        Response response = this.postRequest.login(Factory.createLoginRequestDto());
        response.then().assertThat().statusCode(200);
        VariaveisGlobais.token = "Bearer " + response.then().extract().path("token");
    }
}