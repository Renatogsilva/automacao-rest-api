package api.car;

import config.BaseApi;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.dto.CarRequestDto;
import model.enumerators.CarApiPaths;
import utils.VariaveisGlobais;

public class CarPostRequest extends BaseApi {

    public CarPostRequest() {
        super();
        super.setContentType(ContentType.JSON);
        super.loggAllSpecificRequestDetail(LogDetail.ALL);
        super.loggAllSpecificResponseData(LogDetail.ALL);
    }

    public Response createCar(CarRequestDto carRequestDto) {
        super.setAuthorization("Authorization", VariaveisGlobais.token);
        super.setBasePath(CarApiPaths.CREATE_CAR.getPath());
        super.setRequestBody(carRequestDto);
        return super.sendRequest(CarApiPaths.CREATE_CAR.getMethodType());
    }
}
