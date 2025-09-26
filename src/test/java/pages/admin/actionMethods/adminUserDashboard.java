package pages.admin.actionMethods;

//Scripted By Faysal Sarder (Date: 26-09-2025)

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    public adminUserDashboard(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this); // allow the page elements
    }


    // Main Method
    public void enterUpdatedAdminName(String adminNameValue) {
        try {
            setAdminName(adminNameValue);
            System.out.println("Successfully entered admin name: " + adminNameValue);
        } catch (NoSuchElementException e) {
            System.out.println("Name field isn't found for: " + adminNameValue + " - " + e.getMessage());
        }
    }

    // Convenience methods that call the main dynamic method
    public void enterUpdatedAdminName() {
        enterUpdatedAdminName(testData.adminName);
    }

    public void enterUpdatedInvalidAdminName1() {
        enterUpdatedAdminName(testData.adminName1);
    }

    public void enterUpdatedValidAdminName() {
        enterUpdatedAdminName(testData.adminName2);
    }

    public void enterUpdatedEmailAddress(String mail){
        try{
            setAdminEmailAddress(mail);
        }catch (NoSuchElementException e){
            System.out.println("Email field isn't found for." + e.getMessage());
        }
    }

    public void enterUpdatedEmailAddress(){
        enterUpdatedEmailAddress(testData.adminEmail);
    }

    public void enterAlreadyExitEmailAddress(){
        enterUpdatedEmailAddress(testData.adminEmail2);
    }

    public void clickOnUpdate(){
        try{
            waitUtils.fluentWaitForElement(driver, updateBtn).click();
        }catch (NoSuchElementException e){
            System.out.println("Update button isn't found." + e.getMessage());
        }
    }

    public void verifyUpdate(){
        try{
            Thread.sleep(2000);
            int getNoOfRows = noOfRows.size();
            System.out.println("Total no. of rows in admin table is " + getNoOfRows);
            for (int r = 1; r < getNoOfRows; r++){
                String captureName = nameTextLocator(r).getText();
                String captureEmail = emailTextLocator(r).getText();
                if(captureName.equals(getNameFromRow(1)) && captureEmail.equals(getEmailFromRow(1))){
                    System.out.println("Admin information successfully changed. <Test Passed>");
                    assert true;
                }else{
                    System.out.println("Failed to change admin information. <Test Failed> ");
                    assert false;
                }
            }

        }catch (Exception e){
            System.out.println("Table not found in admin change info page from dashboard" + e.getMessage());
        }
    }



    // Setter and Getter
    void setAdminName(String name){
        waitUtils.fluentWaitForElement(driver, updateNameField).sendKeys(name);
    }

    void setAdminEmailAddress(String email){
        waitUtils.fluentWaitForElement(driver, updateEmailField).sendKeys(email);
    }

    public void clearAdminName(){
        try{
            waitUtils.fluentWaitForElement(driver, updateNameField).clear();
        }catch (Exception e){
            System.out.println("Name field is not found");
        }
    }

    public void clearAdminEmail(){
        try{
            waitUtils.fluentWaitForElement(driver, updateEmailField).clear();
        }catch (Exception e){
            System.out.println("Email field is not found");
        }

    }

    public void identifyAdmin(){
        try{
            Thread.sleep(2000);
            int getNoOfRows = noOfRows.size();
            System.out.println("Total no. of rows in admin table is " + getNoOfRows);
            for (int r = 1; r < getNoOfRows; r++){
                String captureName = nameTextLocator(r).getText();
                String captureEmail = emailTextLocator(r).getText();
                if(captureName.equals(getNameFromRow(1)) && captureEmail.equals(getEmailFromRow(1))){
                    System.out.println("Matched");
                    try{
                        int getNoOfColumns = noOfColumns.size();
                        System.out.println("Total no. of columns in admin table is " + getNoOfColumns);
                        // Find and click Edit button dynamically
                        for(int c = 3; c <= getNoOfColumns; c ++){
                            WebElement editButton = editBtn(r, c);
                            String getButtonName = editButton.getText();
                            System.out.println("Act: " + getButtonName);
                            System.out.println("Exp: " + getBtnNameFormTable());
                            if(getButtonName.contains(getBtnNameFormTable())){
                                editBtn1(r, c).click();
                                System.out.println("Clicked");

                                // Validation
                                String alert = getFetchAlert();
                                boolean isSuccess = (alert != null && alert.contains(val.successAlert));

                                if (isSuccess) {
                                    System.out.println("Fetch successful. <Test Passed>");
                                    assert true;
                                } else {
                                    System.out.println("Fetch failed. <Test Failed>");
                                    assert false;
                                }

                                break;
                            }else{
                                System.out.println("Continue finding the edit button...");
                            }
                        }
                    }catch (Exception e){
                        System.out.println("No column found in table");
                    }
                }else{
                    System.out.println("Continue finding...");
                }
            }

        }catch (Exception e){
            System.out.println("Table not found in admin change info page from dashboard" + e.getMessage());
        }
    }

    String getFetchAlert(){
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



}
