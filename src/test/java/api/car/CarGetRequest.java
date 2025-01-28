package api.car;

import config.BaseApi;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.enumerators.CarApiPaths;
import utils.VariaveisGlobais;

public class CarGetRequest extends BaseApi {

    public CarGetRequest() {
        super();
        super.setContentType(ContentType.JSON);
        super.loggAllSpecificRequestDetail(LogDetail.URI);
        super.loggAllSpecificResponseData(LogDetail.BODY);
    }

    public Response getCarById(Long id) {
        super.setAuthorization("Authorization", VariaveisGlobais.token);
        super.setBasePath(CarApiPaths.GET_CAR_BY_ID.getPath());
        super.setPathParam("id", id);
        return super.sendRequest(CarApiPaths.GET_CAR_BY_ID.getMethodType());
    }

    public Response getAllCars() {
        super.setAuthorization("Authorization", VariaveisGlobais.token);
        super.setBasePath(CarApiPaths.GET_ALL_CARS.getPath());
        return super.sendRequest(CarApiPaths.GET_ALL_CARS.getMethodType());
    }
}
