package pages.admin.pageElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class adminLoginPage {
    @FindBy(id = "email") public WebElement emailField;
    @FindBy(id = "password") public WebElement passwordField;
    @FindBy(id = "user-type") public WebElement userTypeDropdownField;
    @FindBy(id = "loginButton") public WebElement loginBtn;

    @FindBy(xpath = "//div[@class='alert-fail error show']") public WebElement alertLocator;
}
