package scenarios;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import stepsdefinition.BrowserSetupSteps;
import stepsdefinition.WeatherSteps;

public class WeatherScenario {

    @Steps
    BrowserSetupSteps browserSetupSteps;

    @Steps
    WeatherSteps weatherSteps;


    @Given("Any Browser is Opened")
    public void isBrowserOpened() {
        browserSetupSteps.checkBrowserIsOpened();
    }

    @When("I search for {string}")
    public void searchFor(String searchTerm) {
        weatherSteps.searchFor(searchTerm);
    }

    @And("Click on correct site in search results")
    public void clickCorrectSite(){
        weatherSteps.clickOnCorrectSite();
    }

    @Then("Correct site {string} is opened")
    public void checkCorrectSiteIsOpened(String site) {
        weatherSteps.checkCorrectSiteIsOpened(site);
    }

    @When("{string} city entered in search")
    public void enterCityToSearch(String city) {
        weatherSteps.enterCityToSearch(city);
    }

    @Then("Dropdown with suggestions appear")
    public void checkDropdownWithSuggestionsIsPresent() {
        weatherSteps.checkDropdownWithSuggestionsIsPresent();
    }

    @When("{string} city is chosen")
    public void chooseRequiredCity(String city) {
        weatherSteps.chooseCity(city);
    }

    @Then("Weather for the {string} city appear")
    public void checkForecast(String city) {
        weatherSteps.checkWeatherForCityIsPresent(city);
    }
}
