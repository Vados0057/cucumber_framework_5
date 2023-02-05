package runners;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = "steps",
        tags = "@Smoke",
        dryRun = true,
        monochrome = false
)

public class Runner {

}
