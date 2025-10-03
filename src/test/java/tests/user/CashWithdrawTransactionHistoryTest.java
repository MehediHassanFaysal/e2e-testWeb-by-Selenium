package tests.user;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.user.actionMethods.CashWithdrawTransactionHistory;

public class CashWithdrawTransactionHistoryTest extends BaseTest {
    LoginTest login = new LoginTest();

    public void loginPerform(){
        login.performLogin(driver);
    }

    @Test(priority = 1, alwaysRun = true, testName = "Cash Withdraw Transaction History - Positive", description = "Verify that user view cash withdraw transaction history by providing valid account number.")
    void cashWithdrawTransactionHistoryTest_Success(){
        loginPerform();

        CashWithdrawTransactionHistory history = new CashWithdrawTransactionHistory(driver);
        history.navigateToCashDepositHistory();
        history.enterAccountNumber();
        history.clickOnSearch();
    }
}
