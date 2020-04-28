package com.vytrack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//@RunWith => comes from Junit. It allows to have custom test configuration
//cucumber has it's own flow to run test - during runtime turns into executable test
//@CucumberOptions => stands for parameterization for test execution
//glue => tri ass needs to know where are step definition and feature file
//path to package with step definition methods. right click on step_definitions - copy from source root
//features => specifies path to the folder/directory with feature files. right click on features folder- copy from content root
//these 2 parameters are mandatory
//dryRun => stands for checking if every test step has code implementation or not, if not cucumber will generate steps
//throws code snippet and will make you implement , true will do verification
//dryRun = false => real execution
//dryRun = true => DON'T execute test, just checking every step is implemented or not
//our framework creates json file, some plugin takes jason file and generates a nice HTML report
//json looks like plain text, has "properties,values" , arrays,Strings,integers,
//json object vs java object
//json object has only properties no method; java object has both properties and methods
//We add json plugin => "json:target/cucumber.json" => to let it generate by our framework
//and we added plugin to pom xml => maven-surefire-plugin
@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/vytrack/step_definitions",
        features = "src/test/resources/features",
        dryRun = false,
        strict = false,
        tags = "@view_calendar_events",
        //command + shift + f => to deep search where tags (activities) is used
        plugin = {
                  "html:target/default-report ",
                 "json:target/cucumber1.json",
                 //generate list of scenarios that failed during test execution
                 "rerun:target/rerun.txt"
                }
)
public class CucumberRunner{

}





