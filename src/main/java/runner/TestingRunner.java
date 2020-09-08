package runner;

import io.cucumber.testng.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.annotations.Managed;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/java/resources/io/cucumber/features"},
        glue = {"stepsDefinition"},
        tags = ""
)
public class TestingRunner {

    @Managed
    protected WebDriver driver;

}
