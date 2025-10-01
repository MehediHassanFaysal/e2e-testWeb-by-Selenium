package pages.user.actionMethods;

import base.baseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pages.admin.pageElements.adminLoginPage;
import pages.user.assertValue.loginAssertVal;
import pages.user.testInput.loginUserCredential;
import utils.waitUtils;

import java.io.IOException;

import static base.baseTest.capture;

public class userLogin extends adminLoginPage {
    loginUserCredential val = new loginUserCredential();
    loginAssertVal assertVal = new loginAssertVal();
    WebDriver driver;

    baseTest report = new baseTest();

    // Constructor - webDriver call
    public userLogin(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);  // allow the page elements
    }


    // Action Methods
    public void enterEmailAddress(){
        try{
            if(emailField.isDisplayed() && emailField.isEnabled()){
                clearEmail();
                setEmail();
                System.out.println("Email address entered successfully.");
                report.log.info("Email address entered successfully."); // for logger
                report.test.log(LogStatus.PASS, "Email address entered successfully.");  // for report
            }else{
                System.out.println("Email field not visible or enabled.");
                report.test.log(LogStatus.FAIL,report.test.addScreenCapture(capture(driver))+ "Test Failed: Failed to landing on dashboard");
            }
        }catch (NoSuchElementException e){
            System.out.println("Email field not found. " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void enterPassword(){
        try{
            if(passwordField.isDisplayed() && passwordField.isEnabled()){
                clearPassword();
                setPassword();
                System.out.println("Password entered successfully.");
            }else{
                System.out.println("Password field not visible or enabled.");
            }
        }catch (NoSuchElementException e){
            System.out.println("Password field not found. " + e.getMessage());
        }
    }

    public void selectUserType(){
        try{
            if(userTypeDropdownField.isDisplayed() && userTypeDropdownField.isEnabled() ){
                if(userTypeDropdownField.isSelected()){
                    System.out.println("User type already selected.");
                }else{
                    setUserType();
                    System.out.println("User selection successful.");
                }
            }else{
                System.out.println("User type dropdown is either not displayed or not enabled.");
            }

        }catch (NoSuchElementException e){
            System.out.println("User type dropdown field not found. " + e.getMessage());
        }
    }

    public void clickOnLogin(){
        try{
            if(loginBtn.isDisplayed() && loginBtn.isEnabled()){
                System.out.println("Click on login button.");
                loginBtn.click();
                Thread.sleep(1000);
///*
                // Validation
                String alert = getAlert();
                System.out.println("Alert --------------------------- " + alert);

                if (alert == null){
                    System.out.println("Successfully Logged In. <Test Passed>");
                    assert true;
                }else{
                    boolean isSuccess = (alert != null && !alert.contains(assertVal.failureAlert));

                    if (isSuccess) {
                        System.out.println("Successfully Logged In. <Test Passed>");
                        assert true;
                    } else {
                        System.out.println("Login failed. <Test Failed>");
                        assert false;
                    }
                }




// */

            }else{
                System.out.println("Login button is either not displayed or not enabled.");
            }
        }catch (NoSuchElementException e){
            System.out.println("Login button not found.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    // Getter and Setter
    void setEmail(){
        waitUtils.fluentWaitForElement(driver, emailField).sendKeys(val.email);
//        emailField.sendKeys(val.email);

    }
    void clearEmail(){
        emailField.clear();
    }
    void setPassword(){
        passwordField.sendKeys(val.password);
    }
    void clearPassword(){
        passwordField.clear();
    }
    void setUserType(){
        Select admin = new Select(userTypeDropdownField);
        admin.selectByVisibleText(val.type);
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

//    // Gets the alert message if present; returns null otherwise
//    public String getAlert() {
//        try {
//            if (alertLocator.isDisplayed()) {
//                String alert = alertLocator.getText();
//                System.out.println("Alert found: " + alert);
//                return alert;
//            } else {
//                System.out.println("Alert locator found, but not visible.");
//            }
//        } catch (NoSuchElementException e) {
//            System.out.println("No alert found. Continuing... " + e.getMessage());
//        }
//        return null;
//    }
}
