package pages.user.pageElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// Scripted By: Faysal Sarder (Date: 19-09-2025)
public class registrationPage {
    // Registration page components
    @FindBy(xpath = "//button[@class='toggle-btn']") public WebElement registerToggleBtn;

    @FindBy(id = "name") public WebElement nameTxtField;
    @FindBy(id = "reg-email") public WebElement emailField;
    @FindBy(id = "reg-password") public WebElement passwordField;
    @FindBy(id = "password_confirmation") public WebElement confirmPasswordField;
    @FindBy(css = "button[type='submit']") public WebElement registerConfirmBtn;
}
