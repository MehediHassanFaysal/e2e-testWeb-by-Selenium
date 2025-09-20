package tests.admin;

import base.baseTest;
import org.testng.annotations.Test;
import pages.admin.actionMethods.adminLogin;

public class loginTest extends baseTest {
    adminLogin login;

    @Test
    void verifyAdminLogin(){
        login = new adminLogin(driver);
        login.enterEmailAddress();
        login.enterPassword();
        login.selectUserType();
        login.clickOnLogin();
    }
}
