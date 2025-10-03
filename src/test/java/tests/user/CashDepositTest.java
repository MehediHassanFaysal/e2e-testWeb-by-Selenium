package tests.user;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.user.actionMethods.AashDeposit;

public class CashDepositTest extends BaseTest {
    LoginTest login = new LoginTest();

    public void loginPerform(){
        login.performLogin(driver);
    }

    @Test(priority = 1, alwaysRun = true, testName = "Cash Deposit Test - Positive", description = "Verify that user can processed cash deposit.")
    void cashDepositTest_Success(){
        loginPerform();

        AashDeposit deposit = new AashDeposit(driver);
        deposit.enterDepositAmount();
        deposit.enterRemarks();
        deposit.clickOnSubmit();
    }
}
