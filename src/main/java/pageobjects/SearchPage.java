package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.By.name;
import static org.openqa.selenium.Keys.ENTER;
import static org.openqa.selenium.support.PageFactory.initElements;

public class SearchPage {

    @FindBy (xpath = "//*[text()='The Weather Channel']")
    private WebElement weatherCom;

    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        initElements(driver, this);
    }

    public void navigateToSearch(){
        driver.get("https://www.google.com");
    }

    public void searchFor(String searchTerm) {
        driver.findElement(name("q")).sendKeys(searchTerm, ENTER);

    }

    public void clickOnCorrectSite() {
        weatherCom.click();
    }


    public void isBrowserOpened() {
        assertEquals(driver.getCurrentUrl(), "https://www.google.com");
    }
}
