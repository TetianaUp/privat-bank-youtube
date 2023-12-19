package pages;

import base.AbstractBasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static utils.Utils.extractSubstringStartingAt;
import static utils.Utils.normalizeString;

public class VideoPage extends AbstractBasePage {
    public VideoPage(WebDriver driver) {
        super(driver);
    }

    private final String VIDEO_NAME = "//h1[@class='style-scope ytd-watch-metadata']";
    private final String AVATAR_VIDEO_PUBLISHER = "//a[contains(@class,'ytd-video-owner-renderer')]";

    @Step("Get Video name (like webElement)")
    public WebElement getVideoNameElement() {
        return waitVisibleOfElement(VIDEO_NAME);
    }

    @Step("Get name from open video")
    public String getNameOfVideo() {
        return normalizeString(getVideoNameElement().getText());
    }

    @Step("Get avatar of video publisher")
    public WebElement getAvatarOfVideoPublisher() {
        return waitClickableElementByXpath(AVATAR_VIDEO_PUBLISHER);
    }

    @Step("Click on avatar")
    public ChanelPage goToTheAuthorPage() {
        getAvatarOfVideoPublisher().click();
        return new ChanelPage(driver);
    }

    @Step("Get name avatar of author")
    public String getNickNameOfAuthor() {
        return extractSubstringStartingAt(getAvatarOfVideoPublisher().getAttribute("href"));
    }
}
