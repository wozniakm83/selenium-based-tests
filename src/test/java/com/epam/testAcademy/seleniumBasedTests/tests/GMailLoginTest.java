package com.epam.testAcademy.seleniumBasedTests.tests;

import com.epam.testAcademy.seleniumBasedTests.utils.PageObjectManager;
import com.epam.testAcademy.seleniumBasedTests.utils.UrlProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Dariusz_Kozon on 12-Jan-17.
 */
public class GMailLoginTest {

    private WebDriver webDriver;
    private PageObjectManager manager;
    private String url;

    @BeforeMethod
    private void setUp() {
        //System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
        manager = new PageObjectManager(webDriver);
        url = UrlProvider.GOOGLE_MAIN.getUrl();
    }

    @AfterMethod
    private void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    @Test(dataProvider = "loginGMailData")
    public void shouldNotLoggedInTest(String login, String password) {
        manager.mainPage()
                .loadPage(url);
        assertThat(manager.mainPage().isLoaded()).isTrue();
        manager.mainPage()
                .signInButtonClick();
        assertThat(manager.loginPage().isLoaded()).isTrue();
        manager.loginPage()
                .enterMailAddress(login)
                .clickNextButton();
        assertThat(manager.passwordPage().isLoaded()).isTrue();
        assertThat(manager.passwordPage().getEmailDisplayed()).contains(login + "@gmail.com");
        assertThat(manager.passwordPage().isStaySignedInCheckboxSelected()).isTrue();
        manager.passwordPage()
                .enterPassword(password)
                .signInButtonClick();
    }

    @DataProvider(name = "loginGMailData")
    public Object[][] testData() {
        return new Object[][]{
                {"epam321", "testtest1"}
        };
    }
}
