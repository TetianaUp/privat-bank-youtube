package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.fail;

abstract public class AbstractBasePage extends Base {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected final Logger logger;
    private final int BASE_WAIT = 20;

    public AbstractBasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(BASE_WAIT));
        this.logger = LogManager.getLogger(this.getClass());
    }

    protected WebElement waitVisibleOfElement(String locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        } catch (WebDriverException e) {
            logger.error("No visibility element: " + locator);
            fail("No visibility element: " + locator);
            return null;
        }
    }

    protected WebElement waitClickableElementByXpath(String locator) {
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
        } catch (WebDriverException e) {
            logger.error("No clickable element: " + locator);
            fail("No clickable element: " + locator);
            return null;
        }
    }

    protected WebElement waitPresenceOfElementLocated(String locator) {
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
        } catch (WebDriverException e) {
            logger.error("No presence element: " + locator);
            fail("No presence element: " + locator);
            return null;
        }
    }

    protected List<WebElement> waitPresenceOfElementsLocated(String locator) {
        try {
            return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator)));
        } catch (WebDriverException e) {
            logger.error("No presence elements: " + locator);
            fail("No presence elements: " + locator);
            return null;
        }
    }

    protected boolean waitInvisibilityOfElementLocated(String locator) {
        try {
            return wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
        } catch (WebDriverException e) {
            logger.error("Element is visibility: " + locator);
            fail("Element is visibility: " + locator);
            return false;
        }
    }
}
