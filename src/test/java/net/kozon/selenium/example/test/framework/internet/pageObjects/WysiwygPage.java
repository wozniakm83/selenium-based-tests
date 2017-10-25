package net.kozon.selenium.example.test.framework.internet.pageObjects;

import net.kozon.selenium.example.test.framework.common.pageObjects.BasePage;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WysiwygPage extends BasePage {

    @FindBy(xpath = "//h3[contains(text(), 'An iFrame containing the TinyMCE WYSIWYG Editor')]")
    private WebElement wysiwygPageHeader;

    @FindBy(id = "mce_0_ifr")
    private WebElement iframe;

    @FindBy(id = "mceu_15-open")
    private WebElement fileDropdown;

    @FindBy(id = "mceu_32")
    private WebElement newDocument;

    @FindBy(id = "mceu_3") // TODO
    private WebElement boldButton;

    @FindBy(id = "tinymce")
    private WebElement textBox;


    public WysiwygPage(WebDriver webDriver) {
        super(webDriver);
    }

    public WysiwygPage switchToIFrame() {
        webDriver.switchTo().frame("mce_0_ifr");
        return this;
    }

    public WysiwygPage click(By locator) {
        webDriver.findElement(locator).click();
        return this;
    }

    public WysiwygPage clear(By locator) {
        webDriver.findElement(locator).clear();
        return this;
    }

    public WysiwygPage sendKeys(By locator, String text) {
        webDriver.findElement(locator).sendKeys(text);
        return this;
    }

    public WysiwygPage typeText () {
        customWait.clickElement(fileDropdown);
        customWait.clickElement(newDocument);
/*        if(boldButton.getAttribute("aria-pressed").equals("false")) {
            boldButton.click();
        }*/
        customWait.clickElement(boldButton);
        switchToIFrame();
        textBox.clear();
        textBox.sendKeys("text");
        return this;
    }

    public WysiwygPage checkIfTextIsBold() {
        Assertions.assertThat(textBox.findElement(By.xpath("//*[@id='_mce_caret']/strong")).isDisplayed());
        return this;
    }

    @Override
    public boolean isLoaded() {
        return customWait.isElementVisible(wysiwygPageHeader);
    }


}
