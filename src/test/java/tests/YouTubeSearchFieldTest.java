package tests;

import org.testng.annotations.Test;
import pages.ChanelPage;
import pages.VideoPage;
import pages.YouTubeHomePage;
import pages.YouTubeSearchResultPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static pages.YouTubeHomePage.YOUTUBE_URL;
import static pages.YouTubeSearchResultPage.RESULT_SEARCH_QUERY_URL;
import static utils.DataGenerator.getRandomNumber;
import static utils.Utils.replaceSpacesAndNewlinesWithPluses;

public class YouTubeSearchFieldTest extends AbstractBaseTest {

    YouTubeHomePage youTubeHomePage;
    YouTubeSearchResultPage youTubeSearchResultPage;
    VideoPage videoPage;
    ChanelPage chanelPage;
    String rundomNumberForSearch = Integer.toString(getRandomNumber());

    @Test(description = "ввод в строку поиска запрос(запрос должен состоять из 2-4 цифр, случайных при каждом запуске теста)")
    public void verifyEnteringRandomNumberInSearch() {
        youTubeHomePage = new YouTubeHomePage(driver);

        openUrl(YOUTUBE_URL);
        youTubeHomePage.searchVideo(rundomNumberForSearch);
        youTubeHomePage.submitRequestForSearch();

        String actualResult = driver.getCurrentUrl();
        String expectedTitle = (String.format(YOUTUBE_URL + RESULT_SEARCH_QUERY_URL, rundomNumberForSearch));

        assertEquals(actualResult, expectedTitle, "Результат пошуку не співпадає");
    }

    @Test(description = "в списке результатов поиска выбираем вторую позицию сверху")
    public void verifyChooseSecondSuggestionInSearchDropDown() {
        youTubeHomePage = new YouTubeHomePage(driver);

        openUrl(YOUTUBE_URL);
        youTubeHomePage.searchVideo(rundomNumberForSearch);
        youTubeHomePage.chooseVariantOfSearchFromDropDown(2);

        String suggestionName = replaceSpacesAndNewlinesWithPluses(youTubeHomePage.getNameOfSuggestion(2));

        youTubeHomePage.clickOnChoosenSuggestion(2);

        String actualResult = driver.getCurrentUrl();
        String expectedTitle = (String.format(YOUTUBE_URL + RESULT_SEARCH_QUERY_URL, suggestionName));

        assertEquals(actualResult, expectedTitle, "Результат пошуку не співпадає");
    }

    @Test(description = "запуск четвертого сверху видео в списке результатов поиска")
    public void verifyClickOnVideoAfterSearch() {

        youTubeHomePage = new YouTubeHomePage(driver);
        youTubeSearchResultPage = new YouTubeSearchResultPage(driver);
        videoPage = new VideoPage(driver);
        chanelPage = new ChanelPage(driver);

        String rundomNumberForSearch = Integer.toString(getRandomNumber());

        openUrl(YOUTUBE_URL);
        youTubeHomePage.searchVideo(rundomNumberForSearch);
        youTubeHomePage.submitRequestForSearch();

        String nameOfChooseVideoInAllResults = youTubeSearchResultPage.getNameOfVideo(4);
        System.out.println(nameOfChooseVideoInAllResults);
        System.out.println(rundomNumberForSearch);
        assertTrue(nameOfChooseVideoInAllResults.contains(rundomNumberForSearch),
                "Очікувалось, що назва відео '" + nameOfChooseVideoInAllResults +
                        "' містить пошуковий запит '" + rundomNumberForSearch + "', але це не так.");

        youTubeSearchResultPage.clickOnVideo(4);

        String nameOpenVideo = videoPage.getNameOfVideo();

        assertEquals(nameOpenVideo, nameOfChooseVideoInAllResults, "Відкрилось неправильне відео");
    }
}
