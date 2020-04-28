$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/Login.feature");
formatter.feature({
  "name": "Login",
  "description": "  As user, I want to be able to login with username and password",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Login as sales manager and verify that title is Dashboard",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@sales_manager"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is on the login page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.vytrack.step_definitions.LoginStepDefinitions.user_is_on_the_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user logs in as a sales manager",
  "keyword": "When "
});
formatter.match({
  "location": "com.vytrack.step_definitions.LoginStepDefinitions.user_logs_in_as_a_sales_manager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user should verify that title is a Dashboard",
  "keyword": "Then "
});
formatter.match({
  "location": "com.vytrack.step_definitions.LoginStepDefinitions.user_should_verify_that_title_is_a_Dashboard()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Login as store manager and verify that title is Dashboard",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@store_manager"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is on the login page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.vytrack.step_definitions.LoginStepDefinitions.user_is_on_the_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user logs in as a store manager",
  "keyword": "When "
});
formatter.match({
  "location": "com.vytrack.step_definitions.LoginStepDefinitions.user_logs_in_as_a_store_manager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user should verify that title is a Dashboard",
  "keyword": "Then "
});
formatter.match({
  "location": "com.vytrack.step_definitions.LoginStepDefinitions.user_should_verify_that_title_is_a_Dashboard()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Login as driver and verify that title is a Dashboard",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@driver"
    },
    {
      "name": "@dashboard"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is on the login page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.vytrack.step_definitions.LoginStepDefinitions.user_is_on_the_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user logs in as a driver",
  "keyword": "When "
});
formatter.match({
  "location": "com.vytrack.step_definitions.LoginStepDefinitions.user_logs_in_as_a_driver()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user should verify that title is a Dashboard",
  "keyword": "Then "
});
formatter.match({
  "location": "com.vytrack.step_definitions.LoginStepDefinitions.user_should_verify_that_title_is_a_Dashboard()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});