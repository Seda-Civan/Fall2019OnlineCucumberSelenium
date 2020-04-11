package com.vytrack.pages.fleet;


import com.vytrack.pages.AbstractPageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VehiclesPage extends AbstractPageBase {

    @FindBy(partialLinkText = "Create Car")
    private WebElement createCar;
    //drect access might not be reliable, need to wait until click loaded

    //why do we create method for simple click => to take care of wait issues
    //same code will be provided for every single caller of this method
    //We wrap it around with a method so click will be always successful
    public void clickToCreateCar(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(createCar)).click();

    }



}
