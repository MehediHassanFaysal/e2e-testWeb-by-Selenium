package pages.admin.actionMethods;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pages.admin.assertValue.adminLoginAssertVal;
import pages.admin.pageElements.adminLoginPage;
import pages.admin.testInput.adminLoginTestData;
import utils.waitUtils;

public class adminLogin extends adminLoginPage {
    adminLoginTestData val = new adminLoginTestData();
    adminLoginAssertVal assertVal = new adminLoginAssertVal();
    WebDriver driver;

    // Constructor - webDriver call
    public adminLogin (WebDriver driver){
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
            }else{
                System.out.println("Email field not visible or enabled.");
            }
        }catch (NoSuchElementException e){
            System.out.println("Email field not found. " + e.getMessage());
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

                // Validation
                String alert = getAlert();
                boolean isSuccess = (alert != null && alert.contains(assertVal.successAlert)) ||
                        driver.getTitle().equals(assertVal.landingPageTitle);

                if (isSuccess) {
                    System.out.println("Successfully Logged In. <Test Passed>");
                    assert true;
                } else {
                    System.out.println("Login failed. <Test Failed>");
                    assert false;
                }
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
