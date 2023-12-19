package pages.fragments;

import base.AbstractBasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderFragment extends AbstractBasePage {
    public HeaderFragment(WebDriver driver) {
        super(driver);
    }

    private final String SEARCH_FIELD = "//input[@id='search']";
    private final String SEARCH_BUTTON = "//button[@id='search-icon-legacy']";
    private final String VARIANT_OF_SUGGESTION_FROM_DROP_DOWN = "//li[@class='sbsb_c gsfs'][%s]";
            //div[@class='sbqs_c']";

    public WebElement getSearchFieldElement() {
        return waitClickableElementByXpath(SEARCH_FIELD);
    }

    public WebElement getSearchButtonElement(){
        return waitClickableElementByXpath(SEARCH_BUTTON);
    }

    public WebElement getVariantOfSuggestionElement(int numberOfVariant){
        return waitClickableElementByXpath(String.format(VARIANT_OF_SUGGESTION_FROM_DROP_DOWN, numberOfVariant));
    }

    @Step("Enter info for search")
    public void enterSearchQuery(String query) {
        getSearchFieldElement().click();
        getSearchFieldElement().sendKeys(query);
    }

    @Step("Click Search button")
    public void submitSearch() {
        getSearchButtonElement().click();
    }

    public String getNameOfSuggestion(int numberOfVariant){
        return getVariantOfSuggestionElement(numberOfVariant).getText();
    }
}
