package tests.user;

import base.baseTest;
import org.testng.annotations.Test;
import pages.user.actionMethods.cashWithdraw;

public class cashWithdrawTest extends baseTest {
    loginTest login = new loginTest();

    public void loginPerform(){
        login.performLogin(driver);
    }

    @Test(priority = 1, alwaysRun = true, testName = "Cash Withdraw Test - Positive", description = "Verify that user can withdraw their cash.")
    void cashWithdrawTest_Success(){
        loginPerform();

        cashWithdraw withdraw = new cashWithdraw(driver);
        withdraw.navigateToCashWithdraw();
        withdraw.enterWithdrawAmount();
        withdraw.enterRemarks();
        withdraw.clickOnSubmit();
    }
}
