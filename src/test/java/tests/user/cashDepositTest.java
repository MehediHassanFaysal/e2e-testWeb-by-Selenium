package tests.user;

import base.baseTest;
import org.testng.annotations.Test;
import pages.user.actionMethods.cashDeposit;

public class cashDepositTest extends baseTest {
    loginTest login = new loginTest();

    public void loginPerform(){
        login.performLogin(driver);
    }

    @Test(priority = 1, alwaysRun = true, testName = "Cash Deposit Test - Positive", description = "Verify that user can processed cash deposit.")
    void cashDepositTest_Success(){
        loginPerform();

        cashDeposit deposit = new cashDeposit(driver);
        deposit.enterDepositAmount();
        deposit.enterRemarks();
        deposit.clickOnSubmit();
    }
}
