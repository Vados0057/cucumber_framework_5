package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import pages.TechGlobalAlertsPage;
import pages.TechGlobalDynamicTablesPage;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalLoginPage;
import utils.AlertHandler;
import utils.Driver;
import utils.Waiter;

public class TechGlobalSteps {


    WebDriver driver;
    TechGlobalFrontendTestingHomePage techGlobalFrontendTestingHomePage;
    TechGlobalDynamicTablesPage techGlobalDynamicTablesPage;
    TechGlobalAlertsPage techGlobalAlertsPage;
    TechGlobalLoginPage techGlobalLoginPage;

    @Before
    public void setup() {
        driver = Driver.getDriver();
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalDynamicTablesPage = new TechGlobalDynamicTablesPage();
        techGlobalAlertsPage = new TechGlobalAlertsPage();
        techGlobalLoginPage = new TechGlobalLoginPage();
    }

    @When("user clicks on Practices dropdown in the header")
    public void userClicksOnPracticesDropdownInTheHeader() {
        techGlobalFrontendTestingHomePage.headerDropdown.click();
    }

    @And("user selects the {string} option")
    public void userSelectsTheOption(String option) {
        switch (option) {
            case "Frontend Testing":
                techGlobalFrontendTestingHomePage.headerDropdownOptions.get(0).click();
                break;
            case "Dynamic Tables":
            case "Alerts":
            case "Login Form":
                techGlobalFrontendTestingHomePage.clickOnCard(option);
                break;
            default:
                throw new NotFoundException("This option didn't defined properly in the feature file");
        }
//        Waiter.pause(3);
    }

    @Then("user should see {string} heading")
    public void userShouldSeeHeading(String headerText) {
        switch (headerText) {
            case "Dynamic Tables":
            case "Login Form":
                Assert.assertEquals(headerText, techGlobalDynamicTablesPage.headingText.getText());
                break;
            case "Alerts":
                Assert.assertEquals(headerText, techGlobalAlertsPage.headingText.getText());
                break;
            default:
                throw new NotFoundException("This option didn't defined properly in the feature file");
        }
    }

    @When("user clicks the {string} button")
    public void userClicksTheButton(String argument) {
        switch (argument) {
            case "ADD PRODUCT":
                techGlobalDynamicTablesPage.addProductButton.click();
                break;
            case "CLOSE":
                techGlobalDynamicTablesPage.closeButton.click();
                break;
            default:
                throw new NotFoundException("This option didn't defined properly in the feature file");
        }
    }

    @Then("validate {string} pop-up is displayed")
    public void validatePopUpIsDisplayed(String popup) {
        Assert.assertEquals(popup, techGlobalDynamicTablesPage.modalCardTitle.getText());
    }

    @Then("user should not see Add New Product pop-up")
    public void userShouldNotSeeAddNewProductPopUp() {
        try {
            Assert.assertFalse(techGlobalDynamicTablesPage.modalCardTitle.isDisplayed());
        } catch (NoSuchElementException e) {
            Assert.assertTrue(true);
        }
    }

    @And("user should see buttons as {string}, {string}, and {string}")
    public void userShouldSeeButtonsAsAnd(String alert1, String alert2, String alert3) {
        String[] expected = {alert1, alert2, alert3};
        for (int i = 0; i < expected.length; i++) {
            Assert.assertTrue(techGlobalAlertsPage.alertButton.get(i).isDisplayed());
            Assert.assertEquals(expected[i], techGlobalAlertsPage.alertButton.get(i).getText());
        }
    }

    @And("user should see {string} text")
    public void userShouldSeeText(String expectedText) {
        Assert.assertTrue(techGlobalAlertsPage.resultTitle.isDisplayed());
        Assert.assertEquals(expectedText, techGlobalAlertsPage.resultTitle.getText());
    }

    @When("user clicks on {string} box")
    public void userClicksOnBox(String expectedText) {
        techGlobalAlertsPage.clickOnAlert(expectedText);
    }

    @Then("user should see a popup displaying message {string}")
    public void userShouldSeeAPopupDisplayingMessage(String expectedText) {
//        Waiter.pause(2);
        Assert.assertEquals(expectedText, AlertHandler.getAlertText(driver));
//        Waiter.pause(2);
        AlertHandler.acceptAlert();
    }

    @When("user enters username as {string} and password as {string}")
    public void userEntersUsernameAsAndPasswordAs(String email, String password) {
        techGlobalLoginPage.username.sendKeys(email);
        techGlobalLoginPage.password.sendKeys(password);
        techGlobalLoginPage.loginButton.click();
    }

    @Then("user should see a {string} message")
    public void userShouldSeeAMessage(String arg0) {
    Assert.assertTrue(techGlobalLoginPage.errorMessage.isDisplayed());
    Assert.assertEquals(arg0, techGlobalLoginPage.errorMessage.getText());
    }
}