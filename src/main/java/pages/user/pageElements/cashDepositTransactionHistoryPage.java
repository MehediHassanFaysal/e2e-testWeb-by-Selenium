package pages.user.pageElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class cashDepositTransactionHistoryPage {

    // Test scripted by Faysal Sarder (date: 02-10-2025)

    @FindBy(xpath = "//a[normalize-space()='Transaction History']") public WebElement navToTransactionHistory;


    @FindBy(xpath = "//a[normalize-space()='Cash Deposit Transactions']") public WebElement navToCashTransactionHistory;

    @FindBy(id = "account_number") public WebElement accountNumberField;
    @FindBy(xpath = "//button[normalize-space()='Search']") public WebElement searchBtn;
    @FindBy(xpath = "//button[normalize-space()='Clear']") public WebElement clearBtn;
    @FindBy(xpath = "//div[@class='alert-success success show']") public WebElement alertTxt;

    @FindBy(xpath = "//table[@id='transaction-history-table']/tbody/tr") public List <WebElement> NoOfRows;



}
