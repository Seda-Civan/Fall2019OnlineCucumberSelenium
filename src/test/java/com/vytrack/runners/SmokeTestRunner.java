package com.vytrack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/vytrack/step_definitions",
        features = "src/test/resources",
        dryRun = false,
        strict = false,
        tags = "@smoke_test",
        //command + shift + f => to deep search where tags (activities) is used
        plugin =
                {"html:target/smoke_test_default-report ",
                        "json:target/cucumber1.json",
                        "json:target/failed_report.json",
                        "rerun:target/rerun.txt"
                }
)


public class SmokeTestRunner {
}
