package pages.admin.actionMethods;

//Scripted By Faysal Sarder (Date: 26-09-2025)

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.admin.assertValue.adminUserDashboardAssertVal;
import pages.admin.pageElements.adminUserDashboardPage;
import pages.admin.testInput.adminUserTestData;
import utils.waitUtils;
public class adminUserDashboard extends adminUserDashboardPage {
    adminUserTestData testData = new adminUserTestData();
    adminUserDashboardAssertVal val = new adminUserDashboardAssertVal();
    WebDriver driver;

    // Constructor calls and all this set in WebDriver
    public adminUserDashboard(WebDriver d){
        driver = d;
        PageFactory.initElements(d, this); // allow the page elements
    }

    // Setter and Getter
    void setAdminName(){
//        waitUtils.fluentWaitForElement(driver, )
    }
}
