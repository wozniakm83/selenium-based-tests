package net.kozon.selenium.example.test.framework.common.utils;

import net.kozon.selenium.example.test.framework.internet.pageObjects.DragAndDropPage;
import net.kozon.selenium.example.test.framework.internet.pageObjects.FileUploadPage;
import net.kozon.selenium.example.test.framework.internet.pageObjects.MainPage;
import net.kozon.selenium.example.test.framework.internet.pageObjects.WysiwygPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Dariusz_Kozon on 17-May-17.
 */
public class PageObjectTheInternetManager {

    private final WebDriver webDriver;
    private MainPage mainPage;
    private FileUploadPage fileUploadPage;
    private DragAndDropPage dragAndDropPage;
    private WysiwygPage wysiwygPage;

    public PageObjectTheInternetManager(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public MainPage getMainPage() {
        if (mainPage == null) {
            mainPage = PageFactory.initElements(webDriver, MainPage.class);
        }
        return mainPage;
    }

    public FileUploadPage getFileUploadPage() {
        if (fileUploadPage == null) {
            fileUploadPage = PageFactory.initElements(webDriver, FileUploadPage.class);
        }
        return fileUploadPage;
    }

    public DragAndDropPage getDragAndDropPage() {
        if (dragAndDropPage == null) {
            dragAndDropPage = PageFactory.initElements(webDriver, DragAndDropPage.class);
        }
        return dragAndDropPage;
    }

    public WysiwygPage getWysiwygPage() {
        if (wysiwygPage == null) {
            wysiwygPage = PageFactory.initElements(webDriver, WysiwygPage.class);
        }
        return wysiwygPage;
    }
}
