package config;

import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.PropertiesFileUtils;

public abstract class BaseApi {
    private final RequestSpecification requestSpecification;
    private final String baseUri = PropertiesFileUtils.getRestAssuredPropertiesFile("baseUri");

    public BaseApi() {
        this.requestSpecification = RestAssured.given()
                .baseUri(baseUri);
    }

    protected BaseApi setRequestBody(Object object) {
        this.requestSpecification.body(object);
        return this;
    }

    protected void setBasePath(String basePath) {
        this.requestSpecification.basePath(basePath);
    }

    protected BaseApi setAuthorization(String key,String value) {
        this.requestSpecification.header(key, value);
        return this;
    }

    protected BaseApi setContentType(ContentType contentType) {
        this.requestSpecification.contentType(contentType);
        return this;
    }

    protected BaseApi setHeader(String key, String value) {
        this.requestSpecification.header(key, value);
        return this;
    }

    protected BaseApi setBasicAuth(String username, String password) {
        this.requestSpecification.auth().preemptive().basic(username, password);
        return this;
    }

    protected void setPathParam(String paramName, Object paramValue) {
        this.requestSpecification.pathParam(paramName, paramValue);
    }

    public BaseApi loggAllSpecificResponseData(LogDetail logDetail) {
        this.requestSpecification.filter(new ResponseLoggingFilter(logDetail));
        return this;
    }

    public BaseApi loggAllSpecificRequestDetail(LogDetail logDetail) {
        this.requestSpecification.filter(new RequestLoggingFilter(logDetail));
        return this;
    }

    protected Response sendRequest(Method methodType){
        return switch (methodType) {
            case GET -> this.requestSpecification.when().get();
            case PUT -> this.requestSpecification.when().put();
            case POST -> this.requestSpecification.when().post();
            case PATCH -> this.requestSpecification.when().patch();
            case DELETE -> this.requestSpecification.when().delete();
            default -> throw new IllegalStateException("Input method type not supported: " + methodType);
        };
    }
}
