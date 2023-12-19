package pages;

import base.AbstractBasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChanelPage extends AbstractBasePage {
    public ChanelPage(WebDriver driver) {
        super(driver);
    }

    private final String NICK_NAME_AUTHOR = "//span[contains(@class,'ytd-c4-tabbed-header-renderer')]//yt-formatted-string[@id='channel-handle']";
    private final String SUBSCRIBE_ON_CHANEL_BUTTON_LOCATOR = "//div[contains(@class,'channel-action')]//button";
    private final String SUBSCRIBE_WINDOW = "//div[@id='contentWrapper']//ytd-modal-with-title-and-button-renderer";
    private final String SIGH_IN_BUTTON_LOCATOR_IN_SUBSCRIBE_WINDOW = "//a[@aria-label='Sign in']";

    @Step("Get nick name (like webElement)")
    public WebElement getNickNameOnAuthorPageElement() {
        return waitVisibleOfElement(NICK_NAME_AUTHOR);
    }

    @Step("Get Subscribe On Chanel button (like webElement)")
    public WebElement getSubscribeOnChanelButtonElement() {
        return waitVisibleOfElement(SUBSCRIBE_ON_CHANEL_BUTTON_LOCATOR);
    }

    @Step("Get Subscribe window (like webElement)")
    public WebElement getSubscribeWindowElement() {
        return waitVisibleOfElement(SUBSCRIBE_WINDOW);
    }

    @Step("Get Sign in button in window 'Subscribe' (like webElement)")
    public WebElement getSignInButtonInSubscribeWindowElement() {
        return waitVisibleOfElement(SIGH_IN_BUTTON_LOCATOR_IN_SUBSCRIBE_WINDOW);
    }

    @Step("Get text from nick name webElement")
    public String getToKnowNickNameFromAuthorPage() {
        return getNickNameOnAuthorPageElement().getText();
    }

    @Step("Click on Subscribe button")
    public void subscribeOnChanel() {
        getSubscribeOnChanelButtonElement().click();
    }

    @Step("Get text from Sign in button")
    public String getTextFromSignInButton() {
        return getSignInButtonInSubscribeWindowElement().getText();
    }
}
