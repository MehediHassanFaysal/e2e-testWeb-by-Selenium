package base;
import drivers.driverFactory;
import org.testng.annotations.*;

public class baseTest{
    driverFactory df = new driverFactory();
    @BeforeMethod
    public void setUp() {
        df.initDriver();
    }

    @AfterMethod
    public void tearDown() {
        df.quitDriver();
    }
}
