package tests;

import api.car.CarDeleteRequest;
import api.car.CarGetRequest;
import api.car.CarPostRequest;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import model.domain.Car;
import org.junit.jupiter.api.*;
import utils.Factory;

@DisplayName(value = "Testing car functionality")
@Owner( value = "Renato Gomes Silva")
public class CarTestsApi {
    private CarPostRequest postRequest = new CarPostRequest();
    private CarGetRequest getRequest = new CarGetRequest();
    private CarDeleteRequest deleteRequest = new CarDeleteRequest();

    @BeforeAll
    public static void setup() {
        LoginTestsApi loginTestsApi = new LoginTestsApi();
        loginTestsApi.testLogin();

    }

    @Test
    @DisplayName(value = "Should return a new car when data provid is valid")
    @Tag("priority")
    @Severity(SeverityLevel.NORMAL)
    public void shouldReturnNewCarWhenDataValid() {
        Response response = this.postRequest.createCar(Factory.createCarRequestDto());

        response.then().assertThat().statusCode(201);
    }

    @Test
    @DisplayName(value = "Should return a car by ID")
    @Tag("Essentials")
    @Severity(SeverityLevel.NORMAL)
    public void shouldReturnACarByIdValid() {
        Response responseCreateCar = this.postRequest.createCar(Factory.createCarRequestDto());
        responseCreateCar.then().assertThat().statusCode(201);
        Car carCreate = responseCreateCar.as(Car.class);

        Response responseGetCar = this.getRequest.getCarById(carCreate.getCarId());
        responseGetCar.then().assertThat().statusCode(200);
        Car getCar = responseGetCar.as(Car.class);

        Assertions.assertNotNull(getCar);
        Assertions.assertNotNull(getCar.getCarId());
        Assertions.assertEquals(carCreate.getMark(), getCar.getMark());
        Assertions.assertEquals(carCreate.getColor(), getCar.getColor());
        Assertions.assertEquals(carCreate.getEngine(), getCar.getEngine());
    }

    @Test
    @DisplayName(value = "Should return all cars")
    @Tag("priority")
    @Severity(SeverityLevel.NORMAL)
    public void shouldReturnAllCars() {
        Response responseGetCar = this.getRequest.getAllCars();
        responseGetCar.then().assertThat().statusCode(200);
    }

    @Test
    @DisplayName(value = "Should return an updated car")
    @Tag("Essentials")
    @Severity(SeverityLevel.NORMAL)
    public void shouldReturnAnUpdatedCar() {
        Response responseCreateCar = this.postRequest.createCar(Factory.createCarRequestDto());
        responseCreateCar.then().assertThat().statusCode(201);
        Car carCreate = responseCreateCar.as(Car.class);

        carCreate.setMark("Fiat");
        carCreate.setColor("Red");

        Response responseUpdateCar = this.getRequest.getCarById(carCreate.getCarId());
        responseUpdateCar.then().assertThat().statusCode(200);
        Car updateCar = responseUpdateCar.as(Car.class);

        updateCar.setMark("Fiat");
        updateCar.setColor("Red");

        Assertions.assertNotNull(updateCar);
        Assertions.assertNotNull(updateCar.getCarId());
        Assertions.assertEquals(carCreate.getMark(), updateCar.getMark());
        Assertions.assertEquals(carCreate.getColor(), updateCar.getColor());
        Assertions.assertEquals(carCreate.getEngine(), updateCar.getEngine());
    }

    @Test
    @DisplayName(value = "should activate a car")
    @Tag("Essentials")
    @Severity(SeverityLevel.NORMAL)
    public void shouldActivateACar() {
        Response responseCreateCar = this.postRequest.createCar(Factory.createCarRequestDto());
        responseCreateCar.then().assertThat().statusCode(201);
        Car carCreate = responseCreateCar.as(Car.class);

        Response responseUpdateCar = this.deleteRequest.enableCar(carCreate.getCarId());
        responseUpdateCar.then().assertThat().statusCode(204);
    }

    @Test
    @DisplayName(value = "should inactivate a car")
    @Tag("Essentials")
    @Severity(SeverityLevel.NORMAL)
    public void shouldInactivateACar() {
        Response responseCreateCar = this.postRequest.createCar(Factory.createCarRequestDto());
        responseCreateCar.then().assertThat().statusCode(201);
        Car carCreate = responseCreateCar.as(Car.class);

        Response responseUpdateCar = this.deleteRequest.disableCar(carCreate.getCarId());
        responseUpdateCar.then().assertThat().statusCode(204);
    }
}