package com.vytrack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/vytrack/step_definitions",
        features = "src/test/resources/features/activities",
        dryRun = false,
        strict = false,
        tags = "@view_calendar_events",
        //command + shift + f => to deep search where tags (activities) is used
        plugin =
                {"html:target/default-report ",
                 "json:target/cucumber2.json"
                }
)
public class ActivitiesTestRunner {


}
