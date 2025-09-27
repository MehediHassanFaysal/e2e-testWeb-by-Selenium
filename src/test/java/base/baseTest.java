package base;

import drivers.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import pages.admin.actionMethods.adminLogin;
import utils.dateTime;
import freemarker.log.Logger;

import java.io.File;
import java.io.IOException;

// Test Scripted by Faysal Sarder

public class baseTest {
    static dateTime date = new dateTime();

    protected WebDriver driver;

//    @BeforeMethod
    @BeforeClass
    public void setUp() {
        driver = driverFactory.initDriver(); // initialize static driver
        driverFactory.launchApplication("http://127.0.0.1:8000/");
    }

//    @AfterMethod
    @AfterClass
    public void tearDown() {
        driverFactory.quitDriver(); // quit after each test
    }






    // ==================================== For Reporting Purpose (Start) =========================================
    static ExtentReports report;
    public static ExtentTest test;
    public static Logger log = Logger.getLogger(String.valueOf(adminLogin.class));      // declare for logger

    @BeforeTest
    public void setExtent(){
        // new instance
        report = new ExtentReports("extent-Reports/"+date.dateFormat+"/"+"Admin Login-"+date.dateFormat+".html");

        // starting test
        test = report.startTest("Test Web App-Test Automation Report", "E2E Test Web Test Automation");

        report.addSystemInfo("Server", "Test Server");
        report.addSystemInfo("Application URL", "http://http://127.0.0.1:8000/");
        report.addSystemInfo("Framework", "Selenium");
        report.addSystemInfo("Language", "Java");
        report.addSystemInfo("IDEA", "IntelliJ IDEA");
        report.addSystemInfo("Browser", "Chrome");
        report.addSystemInfo("QA Engineer", "Faysal Sarder (Associate QA Engineer)");
        report.addSystemInfo("Current Date & Time", date.dtf.format(date.now));
    }

    @AfterTest
    public void endReport() {
        // ending test
        report.endTest(test);
        // writing everything to document
        report.flush();
    }


    // capture screenshots in Extent Report
    public static String capture(WebDriver driver) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File Dest = new File("failure-Screen-Shots/"+date.dateFormat +"/"+ date.dateFormat + ".png");
        String errflpath = Dest.getAbsolutePath();
        FileUtils.copyFile(scrFile, Dest);
        return errflpath;
    }
}
