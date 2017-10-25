package net.kozon.selenium.example.test.framework.internet.tests;

import net.kozon.selenium.example.test.framework.common.tests.BaseTest;
import net.kozon.selenium.example.test.framework.common.utils.PageObjectTheInternetManager;
import net.kozon.selenium.example.test.framework.common.utils.UrlProvider;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class WysiwygTest extends BaseTest {

    private String url;
    private PageObjectTheInternetManager manager;

    public WysiwygTest() {
        manager = new PageObjectTheInternetManager(webDriver);
    }

    @BeforeMethod
    private void startUp() {
        url = UrlProvider.THE_INTERNET.getUrl();
    }

    @AfterMethod
    private void tearDown() {
        webDriver.quit();
    }

    @Test
    public void shouldLoadWysiwygPage() {
        manager.getMainPage().loadPage(url);
        Assertions.assertThat(manager.getMainPage().isLoaded()).isTrue();
        JavascriptExecutor jse = (JavascriptExecutor)webDriver;
        jse.executeScript("scroll(0, 500);");
        manager.getMainPage().clickWysiwygLink();
        Assertions.assertThat(manager.getWysiwygPage().isLoaded()).isTrue();

        manager.getWysiwygPage()
               .typeText()
               .checkIfTextIsBold();
    }
}
