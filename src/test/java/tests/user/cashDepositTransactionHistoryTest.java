package tests.user;

import base.baseTest;
import org.testng.annotations.Test;
import pages.user.actionMethods.cashDepositTransactionHistory;

public class cashDepositTransactionHistoryTest extends baseTest {
    loginTest login = new loginTest();

    public void loginPerform(){
        login.performLogin(driver);
    }

    @Test(priority = 1, alwaysRun = true, testName = "Cash Deposit Transaction History - Positive", description = "Verify that user view cash deposit transaction history by providing valid account number.")
    void cashDepositTransactionHistoryTest_Success(){
        loginPerform();

        cashDepositTransactionHistory history = new cashDepositTransactionHistory(driver);
        history.navigateToCashDepositHistory();
        history.enterAccountNumber();
        history.clickOnSearch();
    }
}
