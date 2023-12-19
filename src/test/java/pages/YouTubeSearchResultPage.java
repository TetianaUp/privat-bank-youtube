package pages;

import base.AbstractBasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static utils.Utils.normalizeString;
import static utils.Utils.scrollToElement;

public class YouTubeSearchResultPage extends AbstractBasePage {
    public YouTubeSearchResultPage(WebDriver driver) {
        super(driver);
    }

    public final static String RESULT_SEARCH_QUERY_URL = "results?search_query=%s";
    private final String SECOND_SEARCH_RESULT = "//ytd-video-renderer[contains(@class,'ytd-item-section-renderer')][%s]";

    @Step("Get search result element")
    public WebElement getSearchResultElement(int indexOfVideo) {
        return waitClickableElementByXpath(String.format(SECOND_SEARCH_RESULT, indexOfVideo));
    }

    @Step("Click on second video")
    public VideoPage clickOnVideo(int indexOfVideo) {
        scrollToElement(getSearchResultElement(indexOfVideo), driver);
        getSearchResultElement(indexOfVideo).click();
        return new VideoPage(driver);
    }

    @Step("Get name from second video on page with all results")
    public String getNameOfVideo(int indexOfVideo) {
        return normalizeString(getSearchResultElement(indexOfVideo).findElement(By.xpath(".//a[@id='video-title']"))
                .getAttribute("title"));
    }
}
