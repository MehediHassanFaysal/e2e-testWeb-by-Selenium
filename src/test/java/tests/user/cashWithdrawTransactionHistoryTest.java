package tests.user;

import base.baseTest;
import org.testng.annotations.Test;
import pages.user.actionMethods.cashWithdrawTransactionHistory;

public class cashWithdrawTransactionHistoryTest extends baseTest {
    loginTest login = new loginTest();

    public void loginPerform(){
        login.performLogin(driver);
    }

    @Test(priority = 1, alwaysRun = true, testName = "Cash Withdraw Transaction History - Positive", description = "Verify that user view cash withdraw transaction history by providing valid account number.")
    void cashWithdrawTransactionHistoryTest_Success(){
        loginPerform();

        cashWithdrawTransactionHistory history = new cashWithdrawTransactionHistory(driver);
        history.navigateToCashDepositHistory();
        history.enterAccountNumber();
        history.clickOnSearch();
    }
}
