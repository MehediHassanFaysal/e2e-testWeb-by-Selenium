package tests;

import base.baseTest;
import org.testng.annotations.Test;
import pages.actionMethods.login;

public class test extends baseTest {
    login LoginPage;
    @Test
    public void verifyLogin() throws InterruptedException {
        LoginPage = new login(driver);
        LoginPage.enterEmailAddress();
    }

}
