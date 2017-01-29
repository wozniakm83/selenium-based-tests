package com.epam.testAcademy.seleniumBasedTests.pagepobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.epam.testAcademy.seleniumBasedTests.utils.BasePage;
import com.epam.testAcademy.seleniumBasedTests.utils.CustomWait;

/**
 * Created by Dariusz_Kozon on 12-Jan-17.
 */
public class LoginPage extends BasePage {

    @FindBy(xpath = ".//input[@id='Email']")
    private WebElement emailField;

    private By nextButton = By.id("next");

    private CustomWait customWait;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        customWait = new CustomWait(webDriver);
    }

    public LoginPage enterMailAddress(String login) {
        emailField.sendKeys(login);
        return this;
    }

    public LoginPage clickNextButton() {
        webDriver.findElement(nextButton);
        return this;
    }

    @Override
    public boolean isLoaded() {
        return customWait.isElementPresent(emailField) && customWait.isElementPresent(webDriver.findElement(nextButton));
    }

}
