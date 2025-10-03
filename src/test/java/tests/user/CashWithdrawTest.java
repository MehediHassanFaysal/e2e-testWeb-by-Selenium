package tests.user;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.user.actionMethods.CashWithdraw;

public class CashWithdrawTest extends BaseTest {
    LoginTest login = new LoginTest();

    public void loginPerform(){
        login.performLogin(driver);
    }

    @Test(priority = 1, alwaysRun = true, testName = "Cash Withdraw Test - Positive", description = "Verify that user can withdraw their cash.")
    void cashWithdrawTest_Success(){
        loginPerform();

        CashWithdraw withdraw = new CashWithdraw(driver);
        withdraw.navigateToCashWithdraw();
        withdraw.enterWithdrawAmount();
        withdraw.enterRemarks();
        withdraw.clickOnSubmit();
    }
}
