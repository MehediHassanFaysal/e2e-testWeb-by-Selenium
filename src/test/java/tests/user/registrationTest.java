package tests.user;

import base.baseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.user.actionMethods.registration;
import pages.user.assertValue.registrationAssertVal;

// Test Scripted By: Faysal Sarder (Date: 19-09-2025)
public class registrationTest extends baseTest {
    registrationAssertVal assertVal = new registrationAssertVal();
    registration register;

    @Test (priority = 1, alwaysRun = true, testName = "Verify user registration", description = "Verify that user can register the system using valid credentials")
    public void verifyRegistration() throws InterruptedException {
        register = new registration(driver);
        register.clickOnRegisterToggleBtn();
        register.enterName();
        register.enterEmail();
        register.enterPassword();
        register.enterConfirmPassword();
        register.clickOnRegisterBtn();

        Assert.assertEquals(register.getAlert(), assertVal.successAlert, "User registration failed.");
    }
}
