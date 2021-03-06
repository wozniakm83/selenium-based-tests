package net.kozon.selenium.example.test.framework.google.pageObjects;

import net.kozon.selenium.example.test.framework.common.pageObjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Dariusz_Kozon on 16-Jan-17.
 */
public class MainGooglePage extends BasePage {

    @FindBy(xpath = ".//a[contains(text(), 'Sign in')]")
    private WebElement signInButton;

    public MainGooglePage(WebDriver webDriver) {
        super(webDriver);
    }

    public MainGooglePage signInButtonClick() {
        customWait.clickElement(signInButton, 10);
        return this;
    }

    @Override
    public boolean isLoaded() {
        return customWait.isElementVisible(signInButton);
    }

}
