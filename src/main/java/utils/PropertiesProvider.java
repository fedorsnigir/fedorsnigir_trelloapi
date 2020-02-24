package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesProvider {

    private static String PROPERTIES_PATH = "src/main/resources/api.properties";

    public static String getPropertyByName(String key) {

        Properties properties = new Properties();

        try (InputStream input = new FileInputStream(PROPERTIES_PATH)) {
            properties.load(input);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return properties.getProperty(key);
    }
}