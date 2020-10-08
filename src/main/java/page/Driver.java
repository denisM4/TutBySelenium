package page;

import Util.LogUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

public abstract class Driver {

    private final LogUtils logger = LogUtils.getInstance();

    private WebDriver webDriver;
    private WebDriverWait wait;

    public Driver(WebDriver driver, WebDriverWait wait) {
        this.webDriver = driver;
        this.wait = wait;
    }

    protected WebElement findByCss(String locator) {
        WebElement webElement = null;

        try {
            webElement = webDriver.findElement(cssSelector(locator));
        } catch (StaleElementReferenceException ex) {
            logger.logInfo("Try to find collection element - " + locator + " again");
            findByCss(locator);
        }

        return webElement;
    }

    protected List<WebElement> findAll(String locator) {
        List<WebElement> webElementList = null;

        try {
            webElementList = webDriver.findElements(cssSelector(locator));
        } catch (StaleElementReferenceException ex) {
            findAll(locator);
        }

        return webElementList;
    }

    WebElement findInListByValue(List<WebElement> list, String text) {
        WebElement webElement = null;

        for (WebElement element : list) {
            if (element.getText().equals(text)) {
                webElement = element;
            }
        }
        if (webElement == null) {
            logger.logError("Element with text - " + text + " is not found");
            new RuntimeException("Element with text - " + text + " is not found");
        }
        return webElement;
    }

    protected void setValue(String text, WebElement field) {
        field.clear();
        field.sendKeys(text);
    }

    void scrollToElement(WebDriver webDriver, String webElement) {

        JavascriptExecutor js = (JavascriptExecutor) webDriver;

        try {
            js.executeScript("arguments[0].scrollIntoView();", findByCss(webElement));
        } catch (StaleElementReferenceException ex) {
            logger.logInfo("Try to scroll to element -" + webElement + " again");
            js.executeScript("arguments[0].scrollIntoView();", findByCss(webElement));
        }
    }

    protected void waitUntilDescriptionIsLoaded() {

        try {
            wait.until(visibilityOfAllElements(findByCss("div.txt p")));
        } catch (StaleElementReferenceException ex) {
            logger.logInfo("Try to find element (WAIT) -" + ".b-lists.list_afisha.col-5-" + " again");
            wait.until(visibilityOfAllElements(findByCss(".b-lists.list_afisha.col-5")));
        }
    }

    protected void waitUntilLabelAppears() {
        wait.until(visibilityOfAllElements(findByCss("label[for^='filter']")));
    }

}
