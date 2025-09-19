package pages.user.actionMethods;

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
        registerToggleBtn.click();
        Thread.sleep(1000);
    }

    public void enterName() throws InterruptedException {
        nameTxtField.clear();
        nameTxtField.sendKeys(val.name);
        Thread.sleep(1000);
    }

    public void enterEmail() throws InterruptedException {
        emailField.clear();
        emailField.sendKeys(val.emailAddress);
        Thread.sleep(1000);
    }

    public void enterPassword() throws InterruptedException {
        passwordField.clear();
        passwordField.sendKeys(val.password);
        Thread.sleep(1000);
    }

    public void enterConfirmPassword() throws InterruptedException {
        confirmPasswordField.clear();
        confirmPasswordField.sendKeys(val.confirmPassword);
        Thread.sleep(1000);
    }

    public void clickOnRegisterBtn() throws InterruptedException {
        registerConfirmBtn.click();
        Thread.sleep(1000);
    }

}
