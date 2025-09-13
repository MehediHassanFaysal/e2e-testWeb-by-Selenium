package config;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class configReader {
    private static Properties prop;

    // Load config.properties once at runtime
    public static void loadProperties() {
        prop = new Properties();
        try (FileInputStream fis = new FileInputStream("src/test/resources/config.properties")) {
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties file.", e);
        }
    }

    // Get property value by key
    public static String getProperty(String key) {
        if (prop == null) {
            loadProperties(); // lazy loading
        }
        return prop.getProperty(key);
    }

    // Get property with default value
    public static String getProperty(String key, String defaultValue) {
        if (prop == null) {
            loadProperties();
        }
        return prop.getProperty(key, defaultValue);
    }
}
