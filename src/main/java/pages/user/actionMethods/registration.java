package pages.user.actionMethods;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.user.assertValue.registrationAssertVal;
import pages.user.pageElements.registrationPage;
import pages.user.testInput.registrationTestCredential;

// Test Scripted By: Faysal Sarder (Date: 19-09-2025)
public class registration extends registrationPage {

    registrationTestCredential val = new registrationTestCredential();
    registrationAssertVal assertVal = new registrationAssertVal();


    public WebDriver driver;
    // Constructor - WebDriver Calls
    public registration(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Action Methods

    public void clickOnRegisterToggleBtn() throws InterruptedException {
        Thread.sleep(1000);
        try{
            registerToggleBtn.click();
            Thread.sleep(1000);
        }catch (NoSuchElementException e){
            System.out.println("Register Toggle Button Not Found.");
        }
    }


    public void enterName() throws InterruptedException {
        try{
            if(nameTxtField.isDisplayed() && nameTxtField.getDomAttribute("value").isEmpty()){
                setName();
            }else{
                clearName();
                setName();
            }
            Thread.sleep(1000);
        }catch (NotFoundException e){
            System.out.println("Name Text Field Not Found.");
        }

    }

    public void enterEmail() throws InterruptedException {
        try{
            if(emailField.isDisplayed() && emailField.getDomAttribute("value").isEmpty()){
                setEmail();
            }else{
                clearEmail();
                setEmail();
            }
            Thread.sleep(1000);
        }catch (NotFoundException e){
            System.out.println("Email Field is Not Found.");
        }
    }

    public void enterPassword() throws InterruptedException {
        try{
            if(passwordField.isDisplayed() && passwordField.getDomAttribute("value").isEmpty()){
                setPassword();
            }else{
                clearPassword();
                setPassword();
            }
            Thread.sleep(1000);
        }catch (NotFoundException e){
            System.out.println("Password Field is Not Found.");
        }
    }

    public void enterConfirmPassword() throws InterruptedException {
        confirmPasswordField.clear();
        confirmPasswordField.sendKeys(val.confirmPassword);
        Thread.sleep(1000);
        try{
            if(confirmPasswordField.isDisplayed() && confirmPasswordField.getDomAttribute("value").isEmpty()){
                setConfirmPassword();
            }else{
                clearConfirmPassword();
                setConfirmPassword();
            }
            Thread.sleep(1000);
        }catch (NotFoundException e){
            System.out.println("Password Field is Not Found.");
        }
    }

    public void clickOnRegisterBtn() throws InterruptedException {

        try{
            registerConfirmBtn.click();
            Thread.sleep(1000);
        }catch (NoSuchElementException e){
            System.out.println("Submit (Register) button is not found.");
        }
    }

   // setter
    public void setName(){
        nameTxtField.sendKeys(val.name);
    }

    public void clearName(){
        nameTxtField.clear();
    }


    public void  setEmail(){
        emailField.sendKeys(val.emailAddress);
    }

    public void clearEmail(){
        emailField.clear();
    }


    public void  setPassword(){
        passwordField.sendKeys(val.password);
    }

    public void clearPassword(){
        passwordField.clear();
    }

    public void  setConfirmPassword(){
        confirmPasswordField.sendKeys(val.confirmPassword);
    }

    public void clearConfirmPassword(){
        confirmPasswordField.clear();
    }


    public String getAlert() {
        String failureTxt = null;
        if (failureAlert.isDisplayed()) {
            failureTxt = failureAlert.getText();
            System.out.println("Register alert: " + failureTxt);
        }
        return failureTxt;
    }
}
