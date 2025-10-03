package pages.user.actionMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.user.assertValue.cashDepositAssertValue;
import pages.user.pageElements.cashDepositPage;
import pages.user.testInput.cashDepositTestCredentials;

public class AashDeposit extends cashDepositPage {
    cashDepositTestCredentials val = new cashDepositTestCredentials();
    cashDepositAssertValue assertValue = new cashDepositAssertValue();

    WebDriver driver;

    public AashDeposit(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public void enterDepositAmount(){
        if(getUserName ().isEmpty() || getMemberCode ().isEmpty() || getMobileNumber ().isEmpty() ||
                getNidNumber().isEmpty() || getAccountType().isEmpty() || getAccountNumber ().isEmpty()){
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
    public void clickOnSubmit(){
        try{
            submitBtn.click();

            // validation
            String alert = getAlert();

            if (alert == null){
                System.out.println("Cash Deposit Successful <Test Passed>");
                assert true;
            }else{
                boolean isSuccess = (alert != null && alert.contains(assertValue.message));
                if(isSuccess){
                    System.out.println("Cash Deposit Successful <Test Passed>");
                    assert true;
                }else{
                    System.out.println("Failed to Cash Deposit Request <Test Failed>");
                    assert false;
                }
            }

        }catch (NoSuchElementException e){
            throw  new RuntimeException(e.getMessage());
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

    String getAccountType (){
        try{
            if(accountTypeReadOnlyField.isDisplayed()){
//                js.executeScript("arguments[0].removeAttribute('disabled')", accountTypeReadOnlyField);
                String accountType = accountTypeReadOnlyField.getAttribute("value");
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
