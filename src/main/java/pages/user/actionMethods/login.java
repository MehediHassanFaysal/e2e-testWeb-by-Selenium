package pages.user.actionMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.user.assertValue.loginAssertVal;
import pages.user.pageElements.loginPage;
import pages.user.testInput.loginUserCredential;

public class login extends loginPage {
    loginUserCredential userInput = new loginUserCredential();
    loginAssertVal val = new loginAssertVal();


    WebDriver driver;

    // #################### WebDriver Calls #########################
    public login(WebDriver d){
        driver = d;
        PageFactory.initElements(d,this);
    }

    // #################### Action Methods #########################

    public void enterEmailAddress() throws InterruptedException {
        Thread.sleep(3000);
        useridLocator.sendKeys(userInput.email);
    }

}
