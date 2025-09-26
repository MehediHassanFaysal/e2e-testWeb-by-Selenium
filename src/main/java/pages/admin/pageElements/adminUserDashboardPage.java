package pages.admin.pageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static drivers.driverFactory.driver;

public class adminUserDashboardPage {

    // Test Scripted By: Faysal Sarder (Date: 26-09-2025)
    // Normal Way
    @FindBy(id = "name") public WebElement updateNameField;
    @FindBy(id = "email") public WebElement updateEmailField;
    @FindBy(xpath = "(//button[@type='submit'][normalize-space()='Update'])[1]") public WebElement updateBtn;
    @FindBy(xpath = "//button[@id='clear-admin-button']") public WebElement clearBtn;

    @FindBy(xpath = "//div[@id='home']//table//tbody//tr") public List <WebElement>  noOfRows;
    @FindBy(xpath = "//div[@id='home']//table//tbody//tr[1]//td") public List <WebElement> noOfColumns;
//    @FindBy(id = "") public WebElement editBtn;

    @FindBy(xpath = "//div[normalize-space()='Successfully User Data Fetched!']") public WebElement alertLocator;

//    Parameterized Method
    public WebElement nameTextLocator(int rowNumber) {
        return driver.findElement(By.xpath("//div[@id='home']//table/tbody/tr[" + rowNumber + "]/td[1]"));
    }

    public WebElement emailTextLocator(int rowNumber) {
        return driver.findElement(By.xpath("//div[@id='home']//table/tbody/tr[" + rowNumber + "]/td[2]"));
    }

    public String getNameFromRow(int rowNumber) {
        WebElement element = driver.findElement(
                By.xpath("//div[@id='home']//table/tbody/tr[" + rowNumber + "]/td[1]"));
        return element.getText();
    }

    public String getEmailFromRow(int rowNumber) {
        WebElement element = driver.findElement(
                By.xpath("//div[@id='home']//table/tbody/tr[" + rowNumber + "]/td[2]"));
        return element.getText();
    }


    public WebElement editBtn(int row, int column) {
//        return driver.findElement(By.xpath("//div[@id='home']//table//tbody//tr["+row+"]//td["+column+"]//button[contains(text(),'Edit')]"));
        return driver.findElement(By.xpath("//div[@id='home']//table//tbody//tr["+row+"]//td["+column+"]"));
    }

    public String getBtnNameFormTable() {
        WebElement element = driver.findElement(
                By.xpath("//div[@id='home']//table//tbody//tr[1]//td[4]//button[contains(text(),'Edit')]"));
        return element.getText();
    }
}
