package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public static WebDriver driver;

    public static WebDriver initDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*", "--disable-notifications");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void launchApplication(String url) {
        driver.get(url);
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
