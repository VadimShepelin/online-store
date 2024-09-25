package online_store_project.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesHelper {
    private static final Properties PROPERTIES = new Properties();

    static {
        loadProperties();
    }

    private PropertiesHelper() {}

    private static void loadProperties() {
        try (InputStream properties = PropertiesHelper.class.getClassLoader().getResourceAsStream("application.properties")) {
            PROPERTIES.load(properties);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Properties getInstance() {
        return PROPERTIES;
    }


}
