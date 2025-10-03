package tests;

import base.BaseTest;
import pages.user.actionMethods.login;

public class Test extends BaseTest {
    login LoginPage;
    @org.testng.annotations.Test
    public void verifyLogin() throws InterruptedException {
        LoginPage = new login(driver);
        LoginPage.enterEmailAddress();
    }

}
