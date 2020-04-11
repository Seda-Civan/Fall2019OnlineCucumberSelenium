package com.vytrack.pages.activities;

import com.vytrack.pages.AbstractPageBase;
import com.vytrack.utilities.BrowserUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CalendarEventsPage extends AbstractPageBase {

    //findBy coming from pageFactory/ pom is not page factory page factory is finding webElement with this findBy
    @FindBy(css = "[title='Create Calendar event']")
    private WebElement createCalendarEvent;

    //.select2-chosen  =>> . classname
    //image self closable element does not have text so we find text(name) from span class
    @FindBy(className = "select2-chosen")
    private WebElement owner;

    //^ is startswith in css selector
    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_start']")
    private WebElement startDate;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_start']")
    private WebElement startTime;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_end']")
    private WebElement endTime;

    @FindBy(className = "grid-header-cell__label")
    private List<WebElement> columnNames;

    //to enter calendar event title
    @FindBy(css = "[id^='oro_calendar_event_form_title-uid']")
    private WebElement title;

    //description is inside iframe
    //first we need to switch
    //visible text usually don't change
    @FindBy(css = "iframe[id^='oro_calendar_event_form_description-uid']")
    //@FindBy(xpath = "//*[text()='Description']/../following-sibling::div//iframe")
    private WebElement descriptionFrame;

    //to enter a description
    @FindBy(id = "tinymce")
    private WebElement descriptionTextArea;

    @FindBy(css = "[class='btn-group pull-right'] > button")
    private WebElement saveAndClose;

    //(xpath)[2] means find all xpaths that I typed and find 2nd one
    //xpath[2] means find xpath that I typed as a 2nd child
    //@FindBy(xpath = "//label[text()='Title']/..//div[@class='control-label']")
    @FindBy(xpath = "(//div[@class='control-label'])[1]")
    private WebElement generalInfoTitle;

    @FindBy(xpath = "//label[text()='Description']/following-sibling::div/div")
    //@FindBy(xpath = "//label[text()='Description']/following-sibling::div//p[1]")
    private WebElement generalInfoDescription;

    public List<String> getColumnNames(){
        BrowserUtilities.waitForPageToLoad(20);
        return BrowserUtilities.getTextFromWebElements(columnNames);
    }

    public void enterCalendarEventTitle(String titleValue){
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(title)).sendKeys(titleValue);
    }

    //With enterCalendarEventDescription method in page class;
    //you do not need to switch frame inside test,
    //everything is covered is covered inside page; all kind of page interactions
    public void enterCalendarEventDescription(String description){
        BrowserUtilities.waitForPageToLoad(20);
        //wait for frame element to be available for driver and switched to it(wait + switch => frameToBeAvailableAndSwitchToIt)
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(descriptionFrame));
        descriptionTextArea.sendKeys(description);
        driver.switchTo().defaultContent();
        //exit from the frame
        //so you will be able to see other elements,
        //you can not see anything else outside; when you are inside frame
    }

    public void clickOnSaveAndClose(){
        BrowserUtilities.waitForPageToLoad(20);
        //all 3 method are doing the job
        //wait until clickable and then click
        wait.until(ExpectedConditions.elementToBeClickable(saveAndClose)).click();
        //BrowserUtilities.clickWithJS(saveAndClose);
        //saveAndClose.click();
    }

    public String getGeneralInfoTitleText(){
        BrowserUtilities.waitForPageToLoad(20);
        return generalInfoTitle.getText();
    }

    public String getGeneralInfoDescriptionText(){
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Description']/following-sibling::div/div")));
        return generalInfoDescription.getText();
    }

    //*************************************

    public String getOwnerName() {
        //we wait up to 10 seconds
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("select2-chosen")));
        wait.until(ExpectedConditions.visibilityOf(owner));
        return owner.getText().trim();
    }

    public void clickToCreateCalendarEvent() {
        BrowserUtilities.waitForPageToLoad(10);
        //waitForPageToLoad method => is coming from BrowserUtilities class
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[title='Create Calendar event']")));
        wait.until(ExpectedConditions.elementToBeClickable(createCalendarEvent)).click();
        //until method can return web element, this wait is => inherited from abstractBasePAge class
        BrowserUtilities.waitForPageToLoad(20);
    }


    public String getStartDate() {
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(startDate));
        BrowserUtilities.scrollTo(startDate);
        return startDate.getAttribute("value");
    }

    public String getStartTime(){
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(startTime));
        return startTime.getAttribute("value");
    }

    public String getEndTime(){
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(endTime));
        return endTime.getAttribute("value");
    }


    //Why we put current user element under base page class and owner element under create calender event page class???
    //current owner element belongs to top menu.
    //top menu, navigation menu doesn't belong to particular page.
    //since top menu elements are shared, we can store them in base page class
    //where we store the web element of current user name locator => in abstractPageBase ; because every page has that webElement
    //owner name locator =>  in calenderEventsPage since it is belong to calender event

    //anything in  common we will store in abstractPageBase
    //user menu is in li => list then we need direct child with the tag name a
    //hashtag and > sign works in css selector
    //#user-menu>a direct child
    //#user-menu a all child's
    ///a[@class="dropdown-toggle" and contains(text(),'Pearl Wuckert')]
    //we can not use user names name as locator not reliable!

}

