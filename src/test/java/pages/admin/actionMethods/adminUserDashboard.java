package pages.admin.actionMethods;

//Scripted By Faysal Sarder (Date: 26-09-2025)

import org.openqa.selenium.By;
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
    public adminUserDashboard(WebDriver d){
        driver = d;
        PageFactory.initElements(d, this); // allow the page elements
    }


    public void enterUpdatedAdminName(){
        try{
            setAdminName(testData.adminName);
        }catch (NoSuchElementException e){
            System.out.println("Name field isn't found." + e.getMessage());
        }
    }

    public void enterUpdatedEmailAddress(){
        try{
            setAdminEmailAddress(testData.adminEmail);
        }catch (NoSuchElementException e){
            System.out.println("Email field isn't found." + e.getMessage());
        }
    }

    public void clickOnUpdate(){
        try{
            waitUtils.fluentWaitForElement(driver, updateBtn).click();
        }catch (NoSuchElementException e){
            System.out.println("Update button isn't found." + e.getMessage());
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
            int getNoOfRows = noOfRows.size();
            System.out.println("Total no. of rows in admin table is " + getNoOfRows);
            for (int r = 1; r < getNoOfRows; r++){
                String captureName = nameTextLocator(r).getText();
                String captureEmail = emailTextLocator(r).getText();
                if(captureName.equals(getNameFromRow(1)) && captureEmail.equals(getEmailFromRow(1))){
                    System.out.println("Matched");
                    try{
                        int getNoOfColumns = noOfColumns.size();
                        System.out.println("Total no. of rows in admin table is " + getNoOfColumns);
                        // Find and click Edit button dynamically
                        for(int c = 3; c <= getNoOfColumns; c ++){
                            WebElement editButton = editBtn(r, c);
                            String getButtonName = editButton.getText();
                            if(getButtonName.contains(getBtnNameFormTable())){
                                editButton.click();
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
            System.out.println("Table not found in admin change info page from dashboard");e.getMessage();
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
