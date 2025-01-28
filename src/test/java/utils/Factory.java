package utils;

import model.dto.CarRequestDto;
import model.dto.LoginRequestDto;
import model.enumerators.EnumExchange;

public abstract class Factory {

    public static CarRequestDto createCarRequestDto() {
        return new CarRequestDto(null, TestDataHelper.getFaker().animal().name().toUpperCase(), 2021,
                "Branco", TestDataHelper.getFaker().artist().name(), EnumExchange.MANUAL.getCode(), "1.6", "Polo MSI");
    }

    public static LoginRequestDto createLoginRequestDto() {
        return new LoginRequestDto(PropertiesFileUtils.getRestAssuredPropertiesFile("username"),
                PropertiesFileUtils.getRestAssuredPropertiesFile("password"));
    }
}