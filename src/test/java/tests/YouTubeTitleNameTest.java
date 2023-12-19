package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.YouTubeHomePage;

import static org.testng.Assert.assertEquals;
import static pages.YouTubeHomePage.YOUTUBE_URL;

public class YouTubeTitleNameTest extends AbstractBaseTest{

    @Test
    public void verifyBrowserTabTitle(){
        openUrl(YOUTUBE_URL);
        String expectedTitle = "YouTube";
        String actualTitle = driver.getTitle();

        assertEquals(actualTitle, expectedTitle, "Назва вкладки браузера не відповідає очікуваній.");
    }
}
