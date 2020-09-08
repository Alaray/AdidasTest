package stepsdefinition;

import net.thucydides.core.annotations.Step;
import pageobjects.SearchPage;
import pageobjects.WeatherPage;
import runner.TestingRunner;

public class WeatherSteps extends TestingRunner {

    private SearchPage searchPage;
    private WeatherPage weatherPage;


    @Step
    public void isBrowserOpened() {
        searchPage.isBrowserOpened();
    }

    @Step
    public void searchFor(String searchTerm) {
        searchPage.searchFor(searchTerm);
    }

    @Step
    public void clickOnCorrectSite() {
        searchPage.clickOnCorrectSite();
    }

    @Step
    public void checkCorrectSiteIsOpened(String site) {
        weatherPage.checkCorrectSiteIsOpened(site);
    }

    @Step
    public void enterCityToSearch(String city) {
        weatherPage.enterCityToSearch(city);
    }

    @Step
    public void checkDropdownWithSuggestionsIsPresent() {
        weatherPage.checkDropdownWithSuggestionsIsPresent();
    }

    @Step
    public void chooseCity(String city) {
        weatherPage.chooseCity(city);
    }

    @Step
    public void checkWeatherForCityIsPresent(String city) {
        weatherPage.checkWeatherIsPresentForChosenCity(city);
    }

}
