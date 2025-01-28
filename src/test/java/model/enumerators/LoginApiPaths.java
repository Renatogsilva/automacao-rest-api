package model.enumerators;

import io.restassured.http.Method;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum LoginApiPaths {
    AUTHENTICATION("/api/v1/auth/login", Method.POST);

    private final String path;
    private final Method methodType;
}
