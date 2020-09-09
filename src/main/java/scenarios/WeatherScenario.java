package scenarios;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.SearchPage;
import pageobjects.WeatherPage;

public class WeatherScenario extends BrowserSetup{

    private SearchPage searchPage;
    private WeatherPage weatherPage;

    @Before
    public void initPOs() {
        setDriver();
        this.searchPage = new SearchPage(driver);
        this.weatherPage = new WeatherPage(driver);
    }

    @Given("I am at google search")
    public void navigateToSearch() {
        searchPage.navigateToSearch();
    }

    @When("^I search for \"([^\"]*)\"$")
    public void searchFor(String searchTerm) {
        searchPage.searchFor(searchTerm);
    }

    @And("Click on correct site in search results")
    public void clickCorrectSite(){
        searchPage.clickOnCorrectSite();
    }

    @Then("^Site \"([^\"]*)\" is opened$")
    public void checkCorrectSiteIsOpened(String site) {
        weatherPage.checkCorrectSiteIsOpened(site);
    }

    @When("^\"(.+)\" city entered in search$")
    public void enterCityToSearch(String city) {
        weatherPage.enterCityToSearch(city);
    }

    @Then("Dropdown with suggestions appear")
    public void checkDropdownWithSuggestionsIsPresent() {
        weatherPage.checkDropdownWithSuggestionsIsPresent();
    }

    @When("^\"(.+)\" city is chosen$")
    public void chooseRequiredCity(String city) {
        weatherPage.chooseCity(city);
    }

    @Then("^Weather for the \"(.+)\" city appear$")
    public void checkForecast(String city) {
        weatherPage.checkWeatherIsPresentForChosenCity(city);
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }

}
