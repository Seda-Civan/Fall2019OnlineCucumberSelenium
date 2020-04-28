package com.vytrack.step_definitions;

import com.vytrack.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before (order = 2) //before comes from ==> import io.cucumber.java.Before;  !!!
    public void setup(){
        System.out.println("Test setup");
        Driver.getDriver().manage().window().maximize();
    }
    @Before(value = "@driver", order = 1)
    public void specialSetup(){
        //this setup will be executed for the ones have driver tag
        System.out.println("Setup for driver only");
    }
    @After("driver")
    public void specialTearDown(){
        //this setup will be executed for the ones have driver tag
        //ui database api integration testing, how data is coming from another app,
        //add hook responsible for connection to another database
        //only fr specific scenarios
        System.out.println("Tear down for driver only");
    }

    @After //After comes from ==> import io.cucumber.java.After;  !!!
    public void tearDown(Scenario scenario){
        //how to check if scenario failed
        //scenario comes from io cucumber => import io.cucumber.java.Scenario;
        if(scenario.isFailed()){
            TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
            //get scenarios output as array byte
            byte[] image = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            //attach screenshot to the report
            scenario.embed(image,"image/png", scenario.getName());
        }
        System.out.println("Test clean up");
        Driver.closeDriver();
    }
}
