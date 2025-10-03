package tests.admin;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.admin.actionMethods.AdminLogin;

public class LoginTest extends BaseTest {
    private AdminLogin login;

    @Test (priority = 0, alwaysRun = true, testName = "Verify admin login with test credentials" , description = "Admin can login the admin panel with valid credentials")
    void verifyAdminLogin(){
        performLogin(driver);   // Explicitly pass the driver
    }

    // This method can be used by other classes that don't extend baseTest
    public void performLogin(WebDriver driver) {
        if (driver == null) {
            throw new IllegalStateException("WebDriver cannot be null");
        }
        try {
            login = new AdminLogin(driver);
            login.enterEmailAddress();
            login.enterPassword();
            login.selectUserType();
            login.clickOnLogin();
        } catch (Exception e) {
            throw new RuntimeException("Login failed: " + e.getMessage(), e);
        }
    }
}
