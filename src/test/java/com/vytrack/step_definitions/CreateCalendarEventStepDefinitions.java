package com.vytrack.step_definitions;

import com.vytrack.pages.activities.CalendarEventsPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

//step definitions class is not inherits any class or not supposed to be inherited
//we just create page classes objects, and use their methods in StepDefinitions class
public class CreateCalendarEventStepDefinitions {

    CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

    //When part was in loginStepDefinitions
    @Then("user clicks on create calendar event button")
    public void user_clicks_on_create_calendar_event_button() {
        System.out.println("User clicks on create calendar event button");
        calendarEventsPage.clickToCreateCalendarEvent();
    }

    @Then("user enters {string} as a title")
    public void user_enters_as_a_title(String string) {
        System.out.println("User enters title: " + string);
        calendarEventsPage.enterCalendarEventTitle(string);
    }

    @Then("user enters {string} as a description")
    public void user_enters_as_a_description(String string) {
        System.out.println("User enters description: " + string);
        calendarEventsPage.enterCalendarEventDescription(string);
    }

    @Then("user click on save and close button")
    public void user_click_on_save_and_close_button() {
        System.out.println("User click on save and close button");
        calendarEventsPage.clickOnSaveAndClose();
    }

    @Then("user verifies that description of new calendar event is {string}")
    public void user_verifies_that_description_of_new_calendar_event_is(String string) {
        Assert.assertEquals(string, calendarEventsPage.getGeneralInfoDescriptionText());
    }

    @Then("user verifies that title of new calendar event is {string}")
    public void user_verifies_that_title_of_new_calendar_event_is(String string) {
        Assert.assertEquals(string, calendarEventsPage.getGeneralInfoTitleText());
    }

    //And user enters new calendar event information:
    //      | description | On this meeting we discuss what went well, what went wrong and what can be improved |
    //      | title       | Sprint Retrospective
    //          keys            values
    // dataTable.get( KEYS ) => gives value
    @Then("user enters new calendar event information:")
    public void user_enters_new_calendar_event_information(Map<String, String> dataTable) {
       calendarEventsPage.enterCalendarEventDescription(dataTable.get("description"));
       calendarEventsPage.enterCalendarEventTitle(dataTable.get("title"));
    }

    @Then("user verifies that new calendar event was created successfully")
    public void user_verifies_that_new_calendar_event_was_created_successfully(Map<String, String> dataTable) {
        Assert.assertEquals(dataTable.get("description"), calendarEventsPage.getGeneralInfoDescriptionText());
        Assert.assertEquals(dataTable.get("title"), calendarEventsPage.getGeneralInfoTitleText());
    }



}
