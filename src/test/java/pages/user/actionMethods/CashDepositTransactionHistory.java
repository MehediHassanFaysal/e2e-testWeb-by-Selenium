package pages.user.actionMethods;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import pages.user.assertValue.cashDepositTransactionHistoryAssertValue;
import pages.user.pageElements.cashDepositTransactionHistoryPage;
import pages.user.testInput.cashDepositTransactionHistoryTestCredentials;
import utils.waitUtils;

public class CashDepositTransactionHistory extends cashDepositTransactionHistoryPage {
    WebDriver driver;
    cashDepositTransactionHistoryAssertValue assertValue = new cashDepositTransactionHistoryAssertValue();
    cashDepositTransactionHistoryTestCredentials val = new cashDepositTransactionHistoryTestCredentials();

    public CashDepositTransactionHistory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void navigateToCashDepositHistory(){
        try {
            Actions actions = new Actions(driver);    // Actions object to hover
            navToTransactionHistory.click();
//            actions.moveToElement(navToCashTransactionHistory).perform();  // Hover to show submenu
//            navToCashTransactionHistory.click();
            waitUtils.waitForVisibility(driver, navToCashTransactionHistory, 10).click();


        }catch (RuntimeException e){
            e.getMessage();
        }
    }
    public void enterAccountNumber(){
        if(getAccount().isEmpty()){
            setAccountNumber();
        }else{
            clearAccountNumber();
            setAccountNumber();
        }
    }
    public void clickOnSearch(){
        try{
            if(searchBtn.isDisplayed() && searchBtn.isEnabled()){
                searchBtn.click();

                // validation
                String alert = getAlert();

                    boolean isSuccess = alert.contains(assertValue.successMessage);
                    if(isSuccess){
                        validation ();
                        assert true;
                    }else{
                        System.out.println("<Test Failed>");
                        assert false;
                    }

            }else{
                assert false;
            }
        }catch (RuntimeException e){
            e.getMessage();
        }
    }

    private void validation() {
        try {
            int noOfRows = NoOfRows.size();
            System.out.println("No of Rows: " + noOfRows);
            if(assertValue.expectedRow <= noOfRows){
                assert true;
                System.out.println("<Test Passed>");
            }else{
                System.out.println("<Test Failed> -------");
                assert false;
            }
        }catch (RuntimeException e){
            e.getMessage();
        }
    }

    // setter and getter
    private void setAccountNumber(){
        try{
            accountNumberField.sendKeys(val.accountNumber);
        }catch (RuntimeException e){
            e.getMessage();
        }
    }

    private void clearAccountNumber(){
        try{
            accountNumberField.clear();
        }catch (RuntimeException e){
            e.getMessage();
        }
    }

    String getAccount(){
        try{
            String accNo = accountNumberField.getAttribute("value");
            return accNo;
        }catch (RuntimeException e){
            e.getMessage();
        }
        return null;
    }

    String getAlert(){
        String alert = null;
        try{
            if (alertTxt.isDisplayed()){
                alert = alertTxt.getText();
                System.out.println("Alert found. The alert is " + alert);
            }else{
                System.out.println("Alert not found. The alert is " + alert);
            }
        }catch (NoSuchElementException e){
            // Alert not found — safely ignored
            System.out.println("No alert found. Continuing..." + e.getMessage());
        }
        return alert;
    }

}
