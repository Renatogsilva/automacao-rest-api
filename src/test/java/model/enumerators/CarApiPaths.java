package model.enumerators;

import io.restassured.http.Method;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CarApiPaths {
    CREATE_CAR("/api/v1/car", Method.POST),
    GET_CAR_BY_ID("/api/v1/car/{id}", Method.GET),
    GET_ALL_CARS("/api/v1/car", Method.GET),
    ENABLE_CAR_BY_ID("/api/v1/car/active/{id}", Method.PATCH),
    DISABLE_CAR_BY_ID("/api/v1/car/desactive/{id}", Method.PATCH),;

    private final String path;
    private final Method methodType;
}
