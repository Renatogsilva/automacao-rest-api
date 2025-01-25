package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public abstract class PropertiesFileUtils {

    private static Properties apiProperties;

    private static Properties propertyLoader(String filePath) {
        Properties properties = new Properties();
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            try {
                properties.load(bufferedReader);
                bufferedReader.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
                throw new RuntimeException("Failed to load properties file " + filePath);
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
            throw new RuntimeException("Properties file not found at " + filePath);
        }

        return properties;
    }

    public static String getRestAssuredPropertiesFile(String property) {
        if (apiProperties == null) {
            apiProperties = propertyLoader("src/test/resources/application.properties");
        }

        if (apiProperties.containsKey(property)) {
            return apiProperties.getProperty(property);
        }

        throw new IllegalArgumentException(property + " does not exist in application.properties");
    }
}