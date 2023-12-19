package tests;

import base.Base;
import listeners.TestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public class AbstractBaseTest extends Base {
    protected WebDriver driver;

    private final Logger logger = LogManager.getLogger(AbstractBaseTest.class);

    @BeforeMethod
    public void setup() {
        logger.info("Start set up driver");
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        logger.info("Finish set up driver");
    }

    @AfterMethod(alwaysRun = true)
    public void quiteDriver() {
        logger.info("Quite driver");
        driver.quit();
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public WebDriver getDriver() {
        return driver;
    }
}
