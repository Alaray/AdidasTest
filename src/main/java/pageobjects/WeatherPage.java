package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.time.Duration.ofSeconds;
import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.support.PageFactory.initElements;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class WeatherPage {

    @FindBy(xpath = "//input[@id='LocationSearch_input']")
    WebElement search;
    @FindBy(xpath = "//div[@id='LocationSearch_listbox']/button")
    List<WebElement> cities;

    private WebDriver driver;
    private WebDriverWait wait;

    public WeatherPage(WebDriver driver) {
        this.driver = driver;
        initElements(driver, this);
        wait = new WebDriverWait(driver, ofSeconds(5));
    }

    public void checkCorrectSiteIsOpened(String site) {
        assertEquals(driver.getCurrentUrl(), site);
    }

    public void enterCityToSearch(String city) {
        wait.until(elementToBeClickable(search));
        wait.until(visibilityOf(search));
        search.sendKeys(city);
    }

    public void checkDropdownWithSuggestionsIsPresent() {
        assertEquals(false, cities.isEmpty());
    }

    public void chooseCity(String city) {
        cities.stream().filter(e -> e.getText().contains(city)).findFirst().get().click();
    }

    public void checkWeatherIsPresentForChosenCity(String city) {
        driver.findElement(xpath("//section[contains(@aria-label,'Current Conditions for " + city + "')]"));
    }
}
