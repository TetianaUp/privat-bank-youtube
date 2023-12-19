package tests;

import org.testng.annotations.Test;
import pages.ChanelPage;
import pages.VideoPage;
import pages.YouTubeHomePage;
import pages.YouTubeSearchResultPage;

import static org.testng.Assert.assertEquals;
import static pages.YouTubeHomePage.YOUTUBE_URL;
import static utils.DataGenerator.getRandomFras;

public class YoutubeVideoAuthorTest extends AbstractBaseTest {

    YouTubeHomePage youTubeHomePage;
    YouTubeSearchResultPage youTubeSearchResultPage;
    VideoPage videoPage;
    ChanelPage chanelPage;

    @Test(description = "клик на аватар отправителя видео")
    public void verifyClickOnAuthorAvatar() {

        youTubeHomePage = new YouTubeHomePage(driver);
        youTubeSearchResultPage = new YouTubeSearchResultPage(driver);
        videoPage = new VideoPage(driver);
        chanelPage = new ChanelPage(driver);

        String rundomWordForSearch = getRandomFras();

        openUrl(YOUTUBE_URL);
        youTubeHomePage.searchVideo(rundomWordForSearch);
        youTubeHomePage.submitRequestForSearch();

        youTubeSearchResultPage.clickOnVideo(2);

        String authorNickName = videoPage.getNickNameOfAuthor();

        videoPage.goToTheAuthorPage();

        String actualNickName = chanelPage.getToKnowNickNameFromAuthorPage();

        assertEquals(actualNickName, authorNickName, "Нік нейми не збігаються");
    }
}
