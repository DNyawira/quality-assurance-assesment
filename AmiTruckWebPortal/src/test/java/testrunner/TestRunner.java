package testrunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ={"src/test/resources/features"},
        glue = {"stepdefinition", "apphooks"},
        tags = "@Tests",
        plugin = {"pretty"}
)
public class TestRunner {
}
