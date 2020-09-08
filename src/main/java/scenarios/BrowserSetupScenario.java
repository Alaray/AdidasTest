package scenarios;

import stepsdefinition.BrowserSetupSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class BrowserSetupScenario {

    @Steps
    BrowserSetupSteps browserSetupSteps;

    @Given("The {string} driver is present")
    public void setupDriverForBrowser(String browser) {
        browserSetupSteps.getDriver(browser);
    }

    @When("I launch the {string} browser")
    public void launchBrowser(String browser) {
        browserSetupSteps.startBrowser(browser);
    }

    @Then("Browser should be opened")
    public void checkBrowserOpened() {
        browserSetupSteps.checkBrowserIsOpened();
    }
}
