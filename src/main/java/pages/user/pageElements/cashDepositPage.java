package pages.user.pageElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class cashDepositPage {

    // Test conducted by Faysal Sarder (date: 01-10-2025)

    @FindBy (id = "username") public WebElement nameReadOnlyField;
    @FindBy (id = "member_code") public WebElement memberCodeReadOnlyField;
    @FindBy (id = "mobile_number") public WebElement mobileNumberReadOnlyField;
    @FindBy (id = "nid_card") public WebElement nidReadOnlyField;
    @FindBy (id = "account_type") public WebElement accountTypeReadOnlyField;
    @FindBy (id = "account_number") public WebElement accountNumberReadOnlyField;
    @FindBy (id = "amount") public WebElement depositAmountNumberField;
    @FindBy (id = "remarks") public WebElement remarksTextArea;
    @FindBy (xpath = "//button[normalize-space()='Submit']") public WebElement submitBtn;
    @FindBy (xpath = "//button[normalize-space()='Clear']") public WebElement clearBtn;

}
