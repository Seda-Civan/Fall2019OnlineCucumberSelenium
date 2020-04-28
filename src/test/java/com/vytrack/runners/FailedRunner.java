package com.vytrack.runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        glue = "com/vytrack/step_definitions",
        features = "@target/rerun.txt",
        plugin = {
                "html:target/failed-default-report ",
                "json:target/failed_report.json",
        }
)
public class FailedRunner extends AbstractTestNGCucumberTests {
}

/*
after fixing the broken code, we come to FailedRunner class,
@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/vytrack/step_definitions",
        //instead of adding plugin, FailedRunner class generates list of failed scenarios
        //tags are not needed, we have to run everything listed in feature file
        //dryrun is not needed, steps are already implemented
        //path to rerun.txt file
        features = "@target/rerun.txt",
        //tags = "@view_calendar_events",
        //command + shift + f => to deep search where tags (activities) is used
        plugin = {
                "html:target/failed-default-report ",
                "json:target/failed_report.json",
                //generate list of scenarios that failed during test execution
                //"rerun:target/rerun.txt"
        }
)
public class FailedRunner {
}

 */