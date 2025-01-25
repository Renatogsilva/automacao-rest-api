package utils;

import com.github.javafaker.Faker;

public abstract class TestDataHelper {

    private static Faker FAKER = Faker.instance();

    public static Faker getFaker(){
        return FAKER;
    }
}
