package com.vytrack.pages;


import com.vytrack.utilities.BrowserUtilities;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//POM
public class LoginPage  extends AbstractPageBase{

    //use these on top of instance variables
    @FindBy(id = "prependedInput")
    private WebElement username;
    //above or below locators are same
    //public WebElement username2 = Driver.getDriver().findElement(By.id("prependedInput"))

    @FindBy(id = "prependedInput2")
    private WebElement password;

    @FindBy(id = "_submit")
    private WebElement login;

    @FindBy(linkText = "Forgot your password?")
    private WebElement forgotPassword;

    @FindBy(css = "[class='alert alert-error']")
    private WebElement warningMessage;


    //WE REMOVED CONSTRUCTOR BECAUSE WE EXTENDED PAGEBASE CLASS, BECAUSE WE NEED NAVIGATEto() METHOD IN STEP DEFINITIOS CLASS
    //PageFactory basically initializes the elements if we don't use it,
    //it means we can not access the elements which is stored in class
    //When you create LoginPage Object it call PageFactory.initElements method and you initialize
    // all the elements defined by FindBy elements
    //and then you are able to move on for the next steps
    //public LoginPage(){
        //to connect our webDriver, page class and page factory
        //pageFactory - used to use @FindBy annotations
        //PageFactory - helps to find elements easier
     //   PageFactory.initElements(Driver.getDriver(),this);
        //this => refers to the this page object
        //or =>   PageFactory.initElements(Driver.getDriver(), LoginPage.class);
   // }

    //method that returns a text of warning message web element. Call it in the test class
    public String getWarningMessageText(){
        return warningMessage.getText();
    }

    /**
     * Method to login, version #1
     * Login as specifis user
     * @param usernameValue
     * @param passwordValue
     */
    //inside test class we will just have implementations
    public void login(String usernameValue, String passwordValue){
        username.sendKeys(usernameValue);
        //this. => refers instances of this class
        password.sendKeys(passwordValue, Keys.ENTER);
        //we can overload this method
        BrowserUtilities.wait(3);
    }

    /**
     * method to login, version #2
     * Login as a default user
     * Credentials will be retrieved from configuration.properties file
     */
    public void login(){
        BrowserUtilities.wait(2);
       username.sendKeys(ConfigurationReader.getProperty("store_manager"));

       password.sendKeys(ConfigurationReader.getProperty("password"), Keys.ENTER);
        BrowserUtilities.wait(5);
    }

    /**
     * this method stands for login based on user type
     * For example: if parameter is equals to driver, user will login as a driver
     * if parameter is not correct method will throw exception
     * @param role driver , sales manager or store manager
     */
    public void login(String role){
        String userName = "";
        if(role.equalsIgnoreCase("driver")){
            userName = "user15";
        }else if(role.equalsIgnoreCase("sales manager")){
            userName = "salesmanager118";
        }else if(role.equalsIgnoreCase("store manager")){
            userName = "storemanager85";
        }else{
            throw new RuntimeException("Invalid role!");
        }
        System.out.println("Login as " + role);
        login(userName, "UserUser123");
    }

}
/*
march 28/ saturday
VYTrack consist on bunch of pages, open app is one page, login is one page.. every page consist of elements,
every element can be taken by selenium webDriver, represent as webElement than we can do whatever we want.

It is not acceptable to continuously repeat to finding same webElement
We must have minimum code duplication
In terms of web elements ; up until now we did not have concept to store and manage locators efficiently
Every test class we repeat same web elements like login
We will come up with design approach that will allow us to create classes => based on pages
We will store locators that represent web elements
login page class => login page locators  => PAGE OBJECT MODEL
we are not gonna keep finding locators again and again!

POM => we will create page classes for every page that will be tested
POM => store locators
Configuration Properties file => store credentials - connection url's - info about servers
keep elements inside class not in properties
if you put them in properties file ; you have to always keep checking what is the keyname to use that locator, this isn't convenient

"so when you create a page class are you storing all the WebElement locators as variables,
and then have basic navigation methods built in as well that you can call upon? " -yes (Jordan)

Before page object we create page class
create class => give corresponding name (login page => LoginPage class)
instantiate that class

pages package => is collection of page classes  (com.automation.pages)
under pages package => we create LoginPage (corresponding name to the page that we will test)

finding web element in POM : selenium has sth to improve this process : Page Factory
helps to find element easier, syntax is shorter, more organized
@FindBy
@FindBys
@FindAll
@FindBys == &&  FindBys==>and
@FindAll == ||  FindAll==>or

we use this annotations and put the locator in parenthesis
to be able to use annotations :
first initialize page factory that comes from selenium
create constructor
    public LoginPage(){
            //to connect our webDriver, page class and page factory
            //PageFactory - used to use @FindBy annotations
            //PageFactory - helps to find elements easier
            PageFactory.initElements(Driver.getDriver(), this);
    }

and write locators - annotations on the top of page :
    //use these on top of instance variables
    @FindBy(id = "prependedInput")
    public WebElement username;

    @FindBy(id = "prependedInput2")
    public WebElement password;

    @FindBy(id = "_submit")
    public WebElement login;

march 29/ sunday
test ng allowed us to create lots of test in the same class
organization became more professional with @BeforeMethod @AfterMethod
they are supporting our tests
also gave us verification features; if there is no assertion that test is useless
but our problem with duplication was still there
for ex to perform navigation and test the function everytime we logged in
all over test classes username and password had this part
if sth will happen with the log in it has to be changed => so you have to update every single class manually that has log in part
this is really time consuming, instead of writing new things; you will have to spend time on maintenance
we have to come up with an idea, concept; we store them in same class, if we need to update it go one place
and everything will be updated that related to that code
create page classes => for every page that you will test
OOP ; create class class define properties base on class create object based on object you have everything to interact with the  webelements
page logic; locators with webElements
page classes have the same name as web pages
in our test we can use page objects and methods that page object have
the goal is to organize the code in the best known way
Organize the test automation framework
logical connection between page name and test


They might ask in interview in this way !
********  object repository - pages package --> where is your page classes --> from page classes you create page objects
*/










