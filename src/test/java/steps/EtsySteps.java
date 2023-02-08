package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.EtsyPage;
import utils.Driver;

public class EtsySteps {

    WebDriver driver;
    EtsyPage etsyPage;

    @Before
    public void setup() {
        driver = Driver.getDriver();
        etsyPage = new EtsyPage();
    }

    @Then("user should see below headers")
    public void user_should_see_below_languages_around_the_logo(DataTable headers) {
        for (int i = 0; i < headers.asList().size(); i++) {
            System.out.println(headers.asList().get(i));
            Assert.assertEquals(headers.asList().get(i), etsyPage.etsyHeaderDropdowns.get(i).getText());
        }
    }
}
