package tests.admin;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.admin.actionMethods.AdminUserDashboard;

public class AdminInfoChangeRequestTest extends BaseTest {
    LoginTest login = new LoginTest();
    AdminUserDashboard adminInfo;

    private void loginPerform() {
        login.performLogin(driver);
    }

    @Test (priority = 1, alwaysRun = true, testName = "Admin information Change", description = "Verify that admin can change the admin user information")
    public void verifyAdminInformationChange_success(){
        loginPerform();
        // admin information change
        adminInfo = new AdminUserDashboard(driver);
        adminInfo.identifyAdmin();
        adminInfo.clearAdminName();
        adminInfo.clearAdminEmail();
        adminInfo.enterUpdatedAdminName();
        adminInfo.enterUpdatedEmailAddress();
        adminInfo.clickOnUpdate();
        adminInfo.verifyUpdate();
    }

    @Test (priority = 2, alwaysRun = true, testName = "Unable to change admin information Change", description = "Verify that admin can't change the admin name with invalid credential")
    public void verifyAdminNameChangeWithInvalidCredential(){
//        loginPerform();
        // admin information change
        adminInfo = new AdminUserDashboard(driver);
        adminInfo.identifyAdmin();
        adminInfo.clearAdminName();
        adminInfo.clearAdminEmail();
        adminInfo.enterUpdatedInvalidAdminName1();
        adminInfo.enterUpdatedEmailAddress();
        adminInfo.clickOnUpdate();
        adminInfo.verifyUpdate();   // Passed
    }

    @Test (priority = 3, alwaysRun = true, testName = "Duplicate email entry check", description = "Verify that admin can't enter the email that already exist it the database")
    public void verifyAdminEmailUniqueNess(){
//        loginPerform();
        // admin information change
        adminInfo = new AdminUserDashboard(driver);
        adminInfo.identifyAdmin();
        adminInfo.clearAdminName();
        adminInfo.clearAdminEmail();
        adminInfo.enterUpdatedValidAdminName();
        adminInfo.enterAlreadyExitEmailAddress();
        adminInfo.clickOnUpdate();
        adminInfo.verifyUpdate(); // Failed
    }
}
