package tests.user;

import base.baseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.user.actionMethods.userLogin;

// Test conducted by Faysal Sarder

public class loginTest extends baseTest {

    private userLogin login;

    @Test(priority = 0, alwaysRun = true, testName = "User login test" , description = "Verify that user can login the system with valid credentials")
    void verifyUserLogin(){
        performLogin(driver);   // Explicitly pass the driver
    }

    // This method can be used by other classes that don't extend baseTest
    public void performLogin(WebDriver driver) {
        if (driver == null) {
            throw new IllegalStateException("WebDriver cannot be null");
        }
        try {
            login = new userLogin(driver);
            login.enterEmailAddress();
            login.enterPassword();
            login.selectUserType();
            login.clickOnLogin();
        } catch (Exception e) {
            throw new RuntimeException("Login failed: " + e.getMessage(), e);
        }
    }
}
