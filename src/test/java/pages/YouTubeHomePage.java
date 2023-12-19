package pages;

import base.AbstractBasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.fragments.HeaderFragment;


public class YouTubeHomePage extends AbstractBasePage {
    private HeaderFragment header;

    public YouTubeHomePage(WebDriver driver) {
        super(driver);
        header = new HeaderFragment(driver);
    }

    public final static String YOUTUBE_URL = "https://www.youtube.com/";


    @Step("Search with rundom info")
    public void searchVideo(String infoForSearch) {
        header.enterSearchQuery(infoForSearch);
    }

    @Step("Click button for search")
    public YouTubeSearchResultPage submitRequestForSearch() {
        header.submitSearch();
        return new YouTubeSearchResultPage(driver);
    }

    @Step("Get suggestion from drop down in search field")
    public WebElement chooseVariantOfSearchFromDropDown(int numberOfSuggestion) {
        return header.getVariantOfSuggestionElement(numberOfSuggestion);
    }

    @Step("Choose suggestion")
    public YouTubeSearchResultPage clickOnChoosenSuggestion(int numberOfSuggestion) {
        chooseVariantOfSearchFromDropDown(numberOfSuggestion).click();
        return new YouTubeSearchResultPage(driver);
    }

    @Step("Get name of suggestion")
    public String getNameOfSuggestion(int numberOfSuggestion) {
        return chooseVariantOfSearchFromDropDown(numberOfSuggestion).getText();
    }

}
