package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtilities;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
This class will be extended by page classes
And common webElements /locators can be stored here
Since navigation menu doesn't belong to particular page
We can not really create a dedicated page class to store
elements from that menu
 */
//test classes will extend => TestBase
//Page classes will extend=> PageBase


public abstract class AbstractPageBase {

    protected WebDriver driver = Driver.getDriver();
    //all child classes will be able to use this wait. not to repeat again and again
    //also test classes can't see not to have mess in that test classes
    protected WebDriverWait wait = new WebDriverWait(driver, 15);
    //encapsulation is all about design, what is visible to the user of object
    //there is a restarurant; you do not see the kitchen unless it is intentially opened to you
    //mostly kitchens are closed, what you should see what you shouldn't
    //you should see the food not ingredients
    //same in methods, you see result not codes

    //where we store the web element of current user name locator => in abstractPageBase ; because every page has that webelement
    @FindBy(css = "#user-menu>a")
    protected WebElement currentUser;
    //we want to make this webElement available in subclasses so made it protected
    //where we store the web element of owner name locator => abstractPageBase !
    //anything in  common we will store in abstractPageBase
    //usermenu is in li => list then we need direct child with the tag name a
    //hashtad and > sign works in css selector
    //#user-menu>a direct child
    //#user-menu a all childs
    ///a[@class="dropdown-toggle" and contains(text(),'Pearl Wuckert')]
    //we can not use usernames name as locator not reliable!

    @FindBy(css = "[class='btn-group pull-right'] > button")
    protected WebElement saveAndClose;


    //done once in the parent class
    public AbstractPageBase() {
        PageFactory.initElements(driver, this);
        //it is VERY important ! it serves to initialize the object and it finds the Elements!!
        //without it NO PAGE Object Model class will work !!!
        //finding web elements in POM : selenium has smth to improve this process : Page Factory class
        // It helps to find element easier, syntax is shorter, more organized

    }

    //same button for all pages
    public void clickOnSaveAndClose(){
        BrowserUtilities.wait(3);
        //all 3 method are doing the job
        //wait until clickable and then click
        wait.until(ExpectedConditions.elementToBeClickable(saveAndClose)).click();
        //BrowserUtilities.clickWithJS(saveAndClose);
        //saveAndClose.click();
        waitForLoaderMask();
    }

    //We come up with method that will wrap up locator not to have duplication
    // by using webElements directly in test class
    public String getCurrentUserName() {
        //vytrack is so slow so we add waits
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(currentUser));
        return currentUser.getText().trim();
    }


    /**
     * Method for VYTrack navigation. Provide tabname and module name to navigate
     * @param tabName,    like Dashboards, Fleet or Customers
     * @param moduleName, like Vehicles, Vehicles Odometer and Vehicles Costs
     */
    public void navigateTo(String tabName, String moduleName) {
        //refers to tabNames on vytrack website
        String tabNameXpath = "//span[@class='title title-level-1' and contains(text(),'" + tabName + "')]";
        //module name = visible when you hover over on dropdown, options
        String moduleXpath = "//span[@class='title title-level-2' and text()='" + moduleName + "']";

        WebElement tabElement = driver.findElement(By.xpath(tabNameXpath));
        WebElement moduleElement = driver.findElement(By.xpath(moduleXpath));

        Actions actions = new Actions(driver);

        BrowserUtilities.wait(3);

        actions.moveToElement(tabElement).
                pause(2000).
                click(moduleElement).
                build().perform();

        //increase this wait rime if still failing
        BrowserUtilities.wait(4);
        //wait until page loading icon is invisible
        waitForLoaderMask();
    }

    /**
     * this method can be used to wait until that terrible loader mask (spinning wheel) will be gone
     * if loader mask is present, website is loading some data and you can not perform any operations
     */
    public void waitForLoaderMask(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[class*='loader-mask']")));
    }
}
