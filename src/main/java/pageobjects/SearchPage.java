package pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.By.name;
import static org.openqa.selenium.Keys.ENTER;

public class SearchPage extends PageObject {

    @FindBy (xpath = "//span[text()='https://weather.com']")
    private WebElementFacade weatherCom;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void searchFor(String searchTerm) {
        find(name("q")).sendKeys(searchTerm, ENTER);

    }

    public void clickOnCorrectSite() {
        weatherCom.click();
    }


    public void isBrowserOpened() {
        assertEquals(getDriver().getCurrentUrl(), "https://www.google.com");
    }
}
