package api.user;

import config.BaseApi;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import model.dto.LoginRequestDto;

public class UserPostRequest extends BaseApi {

    public UserPostRequest() {
        super();
        super.setContentType(ContentType.JSON);
    }


    public Response login(LoginRequestDto loginRequestDto) {
        super.setRequestBody(loginRequestDto);
        super.setBasePath("/api/v1/auth/login");
        return super.sendRequest(Method.POST);
    }
}
