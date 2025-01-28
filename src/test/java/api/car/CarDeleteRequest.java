package api.car;

import config.BaseApi;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.enumerators.CarApiPaths;
import utils.VariaveisGlobais;

public class CarDeleteRequest extends BaseApi {

    public CarDeleteRequest() {
        super();
        super.setContentType(ContentType.JSON);
        super.loggAllSpecificRequestDetail(LogDetail.URI);
        super.loggAllSpecificResponseData(LogDetail.BODY);
    }

    public Response enableCar(Long id) {
        super.setAuthorization("Authorization", VariaveisGlobais.token);
        super.setBasePath(CarApiPaths.ENABLE_CAR_BY_ID.getPath());
        super.setPathParam("id", id);
        return super.sendRequest(CarApiPaths.ENABLE_CAR_BY_ID.getMethodType());
    }

    public Response disableCar(Long id) {
        super.setAuthorization("Authorization", VariaveisGlobais.token);
        super.setBasePath(CarApiPaths.DISABLE_CAR_BY_ID.getPath());
        super.setPathParam("id", id);
        return super.sendRequest(CarApiPaths.DISABLE_CAR_BY_ID.getMethodType());
    }
}
