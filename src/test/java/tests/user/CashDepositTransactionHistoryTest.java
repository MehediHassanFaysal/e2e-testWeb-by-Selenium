package tests.user;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.user.actionMethods.CashDepositTransactionHistory;

public class CashDepositTransactionHistoryTest extends BaseTest {
    LoginTest login = new LoginTest();

    public void loginPerform(){
        login.performLogin(driver);
    }

    @Test(priority = 1, alwaysRun = true, testName = "Cash Deposit Transaction History - Positive", description = "Verify that user view cash deposit transaction history by providing valid account number.")
    void cashDepositTransactionHistoryTest_Success(){
        loginPerform();

        CashDepositTransactionHistory history = new CashDepositTransactionHistory(driver);
        history.navigateToCashDepositHistory();
        history.enterAccountNumber();
        history.clickOnSearch();
    }
}
