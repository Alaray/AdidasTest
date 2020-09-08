package pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.By.xpath;

public class WeatherPage extends PageObject {


    @FindBy(xpath = "//div[@id='LocationSearch_listbox']/button")
    List<WebElementFacade> cities;

    public WeatherPage(WebDriver driver) {
        super(driver);
    }

    public void checkCorrectSiteIsOpened(String site) {
        assertEquals(getDriver().getCurrentUrl(), site);
    }

    public void enterCityToSearch(String city) {
        assertEquals(getDriver().getCurrentUrl(), "https://www.google.com");
    }

    public void checkDropdownWithSuggestionsIsPresent() {
        assertEquals(false, cities.isEmpty());
    }

    public void chooseCity(String city) {
        cities.stream().filter(e -> e.getText().contains(city)).findFirst().get().click();
    }

    public void checkWeatherIsPresentForChosenCity(String city) {
        find(xpath("//section[contains(@aria-label,'Current Conditions for " + city + "]"));
    }
}
