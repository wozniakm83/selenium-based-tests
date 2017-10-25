package net.kozon.selenium.example.test.framework.internet.pageObjects;

import net.kozon.selenium.example.test.framework.common.pageObjects.BasePage;
import net.kozon.selenium.example.test.framework.common.utils.CustomWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Dariusz_Kozon on 18-Apr-17.
 */
public class MainPage extends BasePage {

    private CustomWait customWait;

    @FindBy(xpath = "//h1[contains(text(), 'Welcome to the-internet')]")
    private WebElement theInternetHeader;

    @FindBy(xpath = "//a[contains(text(), 'File Upload')]")
    private WebElement fileUploadLink;

    @FindBy(xpath = "//a[contains(text(), 'Drag and Drop')]")
    private WebElement dragAndDropLink;

    @FindBy(xpath = "//a[contains(text(), 'WYSIWYG')]")
    private WebElement wysiwygLink;

    public MainPage(WebDriver webDriver) {
        super(webDriver);
        customWait = new CustomWait(webDriver);
    }

    public MainPage clickUploadLink() {
        fileUploadLink.click();
        return this;
    }

    public MainPage clickDragAndDropLink() {
        dragAndDropLink.click();
        return this;
    }

    public MainPage clickWysiwygLink() {
        wysiwygLink.click();
        return this;
    }

    @Override
    public boolean isLoaded() {
        return customWait.isElementVisible(theInternetHeader);
    }
}
