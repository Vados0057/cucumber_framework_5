package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utils.Driver;

public class GoogleSteps {

    WebDriver driver;
    @Before
    public void setup(){
        driver = Driver.getDriver();
    }

    @When("user search for {string}")
    public void user_search_for(String key) {
    driver.findElement(By.name("q")).sendKeys(key + Keys.ENTER);

    }

    @Then("user should see {string} in the url")
    public void user_should_see_in_the_url(String key) {
        Assert.assertTrue(driver.getCurrentUrl().contains(key));
    }

    @Then("user should see {string} in the title")
    public void user_should_see_in_the_title(String key) {
        Assert.assertTrue(driver.getTitle().contains(key));
    }


}
