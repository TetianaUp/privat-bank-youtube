package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ChanelPage;

public class YoutubeChanelTest extends AbstractBaseTest {

    ChanelPage chanelPage;
    String chanelURL = "https://www.youtube.com/@HYBELABELS";

    @Test(description = "клик на кнопку с текстом 'ПОДПИСАТЬСЯ', проверка, что текст 'ВОЙТИ'(точное совпадение) отображается в появившемся контейнере")
    public void checkSubscribeButton() {

        chanelPage = new ChanelPage(driver);

        openUrl(chanelURL);
        chanelPage.subscribeOnChanel();

        Assert.assertTrue(chanelPage.getSubscribeWindowElement().isDisplayed());
        Assert.assertEquals(chanelPage.getTextFromSignInButton(), "Sign in", "Текст на кнопці 'ВОЙТИ' не відповідає очікуваному.");
    }
}
