package pages.admin.pageElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
// Test Scripted By Faysal Sarder (Date: 27-09-2025)

public class accountCreationPage {
    // Page elements of Personal Information
    @FindBy(id = "input1-1") public WebElement memberCodeNoField;
    @FindBy(id = "input1-2") public WebElement mobileNumberNoField;
    @FindBy(id = "input1-3") public WebElement nidNoField;
    @FindBy(id = "input1-4") public WebElement dobField;
    @FindBy(id = "input1-5") public WebElement occupationDropdownList;
    @FindBy(id = "input1-6") public WebElement annualIncomeNoField;
    @FindBy(id = "input1-7") public WebElement presentAddressTxtField;
    @FindBy(id = "input1-8") public WebElement permanentAddressTxtField;
    @FindBy(id = "nextButton1") public WebElement next1Btn;


    // Page elements of Nominee Information
    @FindBy(id = "input2-1") public WebElement nomineeNameTxtField;
    @FindBy(id = "input2-2") public WebElement nomineeAgeTxtField;
    @FindBy(id = "input2-3") public WebElement nomineeMobileNoField;
    @FindBy(id = "input2-4") public WebElement nomineeNidNoField;
    @FindBy(id = "input2-5") public WebElement nomineeBirthIdNoField;
    @FindBy(id = "input2-6") public WebElement nomineePercentageNoField;
    @FindBy(id = "input2-7") public WebElement nomineeRelationList;
    @FindBy(id = "nextButton2") public WebElement next2Btn;

    // Page elements of Introducer Information
    @FindBy(id = "input3-1") public WebElement introducerAccountField;
    @FindBy(id = "input3-2") public WebElement introducerNameField;
    @FindBy(id = "input3-3") public WebElement introducerNidField;
    @FindBy(id = "input3-4") public WebElement introducerMobileNoField;
    @FindBy(id = "input3-5") public WebElement introducerRemarksField;
    @FindBy(id = "nextButton3") public WebElement next3Btn;

    // Page elements of Account Information
    @FindBy(id = "input3-1") public WebElement accountTypeField;
    @FindBy(id = "input3-2") public WebElement amountField;
    @FindBy(id = "nextButton4") public WebElement next4Btn;

    // Review and Submit
    @FindBy(id = "submitButton") public WebElement submitBtn;
}
