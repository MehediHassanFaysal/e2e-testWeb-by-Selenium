package pages.user.actionMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.user.assertValue.cashWithdrawAssertValue;
import pages.user.pageElements.cashWithdrawPage;
import pages.user.testInput.cashWithdrawTestCredentials;

public class CashWithdraw extends cashWithdrawPage {
    cashWithdrawTestCredentials val = new cashWithdrawTestCredentials();
    cashWithdrawAssertValue assertValue = new cashWithdrawAssertValue();

    WebDriver driver;

    public CashWithdraw(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public void navigateToCashWithdraw(){
        try{
            cashWithdrawNavItem.click();
        }catch (NoSuchElementException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    public void enterWithdrawAmount(){
        if(getUserName ().isEmpty() || getMemberCode ().isEmpty() || getMobileNumber ().isEmpty() ||
                getNidNumber().isEmpty() || getAvailableAmount().isEmpty() || getAccountNumber ().isEmpty()){
            assert false;
        }else{
            if(getAccountNumber ().equals(val.accountNumber) && depositAmountNumberField.getAttribute("value").isEmpty()){
                depositAmountNumberField.sendKeys(Integer.toString(val.amount));
            }else{
                depositAmountNumberField.clear();
                depositAmountNumberField.sendKeys(Integer.toString(val.amount));
            }
        }
    }
    public void enterRemarks(){
        try{
            if(remarksTextArea.isDisplayed() && remarksTextArea.isEnabled() && remarksTextArea.getAttribute("value").isEmpty()){
                remarksTextArea.sendKeys(val.remarks);
            }else{
                remarksTextArea.clear();
                remarksTextArea.sendKeys(val.remarks);
            }
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    int initialBalance;
    int restOfBalance;
    String restOfBal;
    int restOfAmount;
    String restOfAmnt;
    public void clickOnSubmit(){
        try{
            initialBalance =  Integer.parseInt(getAvailableAmount ());  // convert string to int

            submitBtn.click();

            // validation
            String alert = getAlert();

            if (alert == null){
                System.out.println("Cash With Successful <Test Passed>");
                assert true;
                validation ();
            }else{
                boolean isSuccess = alert.contains(assertValue.message);
                if(isSuccess){
                    validation ();
                    assert true;
                }else{
                    System.out.println("Failed to With Deposit Request <Test Failed>");
                    assert false;
                }
            }

        }catch (NoSuchElementException e){
            throw  new RuntimeException(e.getMessage());
        }
    }

    private void validation() {
        // After withdraw
        restOfBalance =  Integer.parseInt(getAvailableAmount ());  // convert string to int
        restOfBal =String.valueOf(restOfBalance);

        // calculation
        restOfAmount = initialBalance - val.amount;
        restOfAmnt = Integer.toString(restOfAmount);
        if(restOfAmnt.equals(restOfBal)){
            System.out.println("Cash With Successful <Test Passed>");
            assert true;
        }else{
            System.out.println("Failed to With Deposit Request <Test Failed>");
            assert false;
        }
    }

    // getter and setter
    String getUserName (){

        try{
            Thread.sleep(1000);
//            js.executeScript("arguments[0].removeAttribute('disabled')", nameReadOnlyField);
            if(nameReadOnlyField.isDisplayed()){
                String userName = nameReadOnlyField.getAttribute("value");
                return userName;
            }else{
                return null;
            }
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    String getMemberCode (){
        try{
            if(memberCodeReadOnlyField.isDisplayed()){
//                js.executeScript("arguments[0].removeAttribute('disabled')", memberCodeReadOnlyField);
                String memberCode = memberCodeReadOnlyField.getAttribute("value");
                return memberCode;
            }else{
                return null;
            }
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    String getMobileNumber (){
        try{
            if(mobileNumberReadOnlyField.isDisplayed()){
//                js.executeScript("arguments[0].removeAttribute('disabled')", mobileNumberReadOnlyField);
                String mobileNo = mobileNumberReadOnlyField.getAttribute("value");
                return mobileNo;
            }else{
                return null;
            }
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    String getNidNumber (){
        try{
            if(nidReadOnlyField.isDisplayed()){
//                js.executeScript("arguments[0].removeAttribute('disabled')", nidReadOnlyField);
                String nid = nidReadOnlyField.getAttribute("value");
                return nid;
            }else{
                return null;
            }
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    String getAvailableAmount (){
        try{
            if(availableAmountField.isDisplayed()){
//                js.executeScript("arguments[0].removeAttribute('disabled')", accountTypeReadOnlyField);
                String accountType = availableAmountField.getAttribute("value");
                return accountType;
            }else{
                return null;
            }
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    String getAccountNumber (){
        try{
            if(accountNumberReadOnlyField.isDisplayed()){
                String accountNo = accountNumberReadOnlyField.getAttribute("value");
                return accountNo;
            }else{
                return null;
            }
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    String getAlert(){
        String alert = null;
        try{
            if (alertLocator.isDisplayed()){
                alert = alertLocator.getText();
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
