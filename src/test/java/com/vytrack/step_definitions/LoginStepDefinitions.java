package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtilities;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginStepDefinitions {

    LoginPage loginPage = new LoginPage();

    //Annotations work as a key for cucumber
    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        System.out.println("Open login page");
        String URL = ConfigurationReader.getProperty("qa3");
        Driver.getDriver().get(URL);
    }

    @When("user logs in as a sales manager")
    public void user_logs_in_as_a_sales_manager() {
        System.out.println("Login as sales manager");
        loginPage.login("salesmanager110", "UserUser123");
    }

    @When("user logs in as a store manager")
    public void user_logs_in_as_a_store_manager() {
        System.out.println("Login as sales manager");
        loginPage.login("storemanager85", "UserUser123");
    }

    @When("user logs in as a driver")
    public void user_logs_in_as_a_driver() {
        System.out.println("Login as a driver");
        loginPage.login("user19", "UserUser123");
    }

    @Then("user should verify that title is a Dashboard")
    public void user_should_verify_that_title_is_a_Dashboard() {
        System.out.println("Verify that title is a Dashboard");
        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(2);
        Assert.assertEquals("Dashboard", Driver.getDriver().getTitle());
    }
//  in feature file we wrote params in between double quotes "" like below =>
//  When user enters "storemanager85" user name and "UserUser123" password
//  then in runner class make dryRun true, get the implementation paste to the stepDefinition class
//  printf ==same as +""+, storemanager85 =>String    UserUser123=> String2
    @When("user enters {string} username and {string} password")
    public void user_enters_username_and_password(String string, String string2) {
        System.out.printf("Login with user name %s and %s password\n", string, string2);
        loginPage.login(string,string2);
    }

    //navigation will be used for many other test cases, not only for login, so we put it here
    @When("user navigates to {string} and {string}")
    public void user_navigates_to_and(String tab, String module) {
        //if step defines 2 parameter, implementation MUST have 2 parameters, order is from left to right
        System.out.printf("User clicks on the %s tab and navigates to %s module\n", tab, module);
        //above statement will print this line : User clicks on the Activities tab and navigates to Calendar Events module
        //%s => tab  %s => module - %s means String
        //just for debugging purpose, we wrote this message, normally we use loggers, to see what went wrong in which state
        loginPage.navigateTo(tab,module);
    }

    @Then("user name should be {string}")
    public void user_name_should_be(String string) {
        //call the function that gives us actual result in step definitions class
        //getCurrentUserName => returns the username of user
        //Page object model is not only having the locators organized, creating page  classes based on page names,
        //keeping webElements inside page classes
        //but it's also about : how do you write your tests ??
        //properly designing your test and by separating test logic from the test logic ==> we are creating another level of abstraction
        //providing the functions that gives very convenient and simple way to interact with a web application
        //you have method that does everything - you just call it and do not worry how things are done!
        //Everything should be handled inside page classes
        Assert.assertEquals(string, loginPage.getCurrentUserName());
    }

    //LoginDDT.feature
    @When("user logs in as {string}")
    public void user_logs_in_as(String userType) {
        //login based on specific row on feature file
        //we have overloaded login method in loginpage class
        loginPage.login(userType);
    }

    @Then("user verifies that page title is {string}")
    public void user_verifies_that_page_title_is(String string) {
        System.out.println("Verift that page title is: " +string);
        //expected comes from feature file -> string
       Assert.assertEquals(string, Driver.getDriver().getTitle());
    }


    //given setup
    //when actions
    //and verification
    //then verification



}

