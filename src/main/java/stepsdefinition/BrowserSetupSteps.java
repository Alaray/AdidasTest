package stepsdefinition;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.thucydides.core.annotations.NotImplementedException;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.TestingRunner;

import static org.testng.Assert.assertEquals;

public class BrowserSetupSteps extends TestingRunner {


    @Step
    public void getDriver(String browser) {
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                break;
            default:
                throw new NotImplementedException("No driver for " + browser + "browser found");


        }
    }

    @Step
    public void startBrowser(String browser) {
        switch (browser){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                throw new NotImplementedException("No browser with name" + browser + " found");
        }
    }

    @Step
    public void checkBrowserIsOpened() {
        driver.get("www.google.com");
        assertEquals(driver.getCurrentUrl(), "www.google.com");
    }
}
