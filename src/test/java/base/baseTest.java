package base;

import drivers.driverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class baseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = driverFactory.initDriver(); // initialize static driver
        driverFactory.launchApplication("http://127.0.0.1:8000/");
    }

    @AfterMethod
    public void tearDown() {
//        driverFactory.quitDriver(); // quit after each test
    }
}
