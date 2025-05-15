package StepDefinition;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.TMPage;
import Utilities.CommonDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;


public class MyStepdefs extends CommonDriver
{
    @Given("I logged into TurnUp portal successfully")
    public void iLoggedIntoTurnUpPortalSuccessfully() throws InterruptedException
    {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver();

        driver = new ChromeDriver(options);
        LoginPage loginPageObj = new LoginPage();
        loginPageObj.LoginActions(driver);

        //User has logged in successfully
        loginPageObj.VerifyUserInHomePage(driver);
    }

    @When("I navigate to Time and Material page")
    public void iNavigateToTimeAndMaterialPage() throws InterruptedException {
        //Home page object initialization and definition
        HomePage homePageObj = new HomePage();
        homePageObj.NavigateToTMPage(driver);
    }

    @When("I create a time record")
    public void iCreateATimeRecord() throws InterruptedException {
        TMPage tMPageObj = new TMPage();
        tMPageObj.CreateTimeRecord(driver);
    }

    @Then("the record should be created successfully")
    public void theRecordShouldBeCreatedSuccessfully()
    {
        TMPage tMPageObj = new TMPage();

        String newCode = tMPageObj.GetCode(driver);
        String newDescription = tMPageObj.GetDescription(driver);

        String expectedCode = "ABC";
        String expectedDescription = "ABCDescription";

        Assert.assertEquals(newCode, expectedCode, "Actual Code and expected Code do not match.");
        Assert.assertEquals(newDescription, expectedDescription, "Actual Description and expected Description do not match.");

    }

    @When("I update the {string} and {string} on an existing Time record")
    public void iUpdateTheCodeAndDescriptionOnAnExistingTimeRecord(String code, String description) throws InterruptedException {
        TMPage tMPageObj = new TMPage();
        tMPageObj.EditTimeRecord(driver, code, description);
    }

    @Then("the record should have the updated {string} and {string}")
    public void theRecordShouldHaveTheUpdatedCodeAndDescription(String code, String description)
    {
        TMPage tMPageObj = new TMPage();
        String editedCode = tMPageObj.GetEditedCode(driver);
        String editedDescription = tMPageObj.GetEditedDescription(driver);

        Assert.assertEquals(editedCode, code, "Expected Edited Code and actual edited code do not match.");
        Assert.assertEquals(editedDescription,description, "Expected Edited Description and actual edited description do not match.");

    }
}
