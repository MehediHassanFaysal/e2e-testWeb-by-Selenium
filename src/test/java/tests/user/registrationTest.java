package tests.user;

import base.baseTest;
import org.testng.annotations.Test;
import pages.user.actionMethods.registration;

public class registrationTest extends baseTest {
    registration register;

    @Test
    public void verifyRegistration() throws InterruptedException {
        register = new registration(driver);
        register.clickOnRegisterToggleBtn();
        register.enterName();
        register.enterEmail();
        register.enterPassword();
        register.enterConfirmPassword();
//        register.clickOnRegisterBtn();
    }
}
