package tests.admin;

import base.baseTest;
import org.testng.annotations.Test;
import pages.admin.actionMethods.adminLogin;

public class loginTest extends baseTest {
    adminLogin login;

    @Test (priority = 0, alwaysRun = true, testName = "Verify admin login with test credentials" , description = "Admin can login the admin panel with valid credentials")
    void verifyAdminLogin(){
        login = new adminLogin(driver);
        login.enterEmailAddress();
        login.enterPassword();
        login.selectUserType();
        login.clickOnLogin();
    }
}
