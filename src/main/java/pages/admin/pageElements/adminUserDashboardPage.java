package pages.admin.pageElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class adminUserDashboardPage {

    // Test Scripted By: Faysal Sarder (Date: 26-09-2025)
    @FindBy(id = "name") public WebElement updateNameField;
    @FindBy(id = "email") public WebElement updateEmailField;
    @FindBy(xpath = "(//button[@type='submit'][normalize-space()='Update'])[1]") public WebElement updateBtn;
    @FindBy(xpath = "//button[@id='clear-admin-button']") public WebElement clearBtn;

    @FindBy(xpath = "//div[@id='home']//table//tbody//tr") public List <WebElement>  noOfRows;
    @FindBy(xpath = "//div[@id='home']//table//tbody//tr[1]//td") public List <WebElement> noOfColumns;
    @FindBy(id = "") public WebElement editBtn;





}
