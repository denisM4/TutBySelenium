package Util;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.Driver;

import java.util.List;

public class Util extends Driver {

    private WebDriverWait wait;
    private final LogUtils logger = LogUtils.getInstance();
    int pageNumber = 0;


    public Util(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.wait = wait;
    }

    /**
     * This method allows to check the presence of text(name) in description film
     *
     * @param elementsLocator - Locator Collection of description films
     * @param name            - Text for comparing
     */
    private boolean compareDescriptionWithName(String elementsLocator, String name) {

        boolean isContains = false;

        waitUntilDescriptionIsLoaded();
        List<WebElement> elements = findAll(elementsLocator);

        for (WebElement element : elements) {
            isContains = element.getText().contains(name);

            if (isContains == false) {
                return false;
            }
            logger.logInfo("Description element - " + element.getText());
        }

        logger.logInfo("--------------------------- Page number - " + pageNumber + " ---------------------------");
        return isContains;
    }

    /**
     * This method allows to get elements collection and implements iteration all pages
     *
     * @param filmDescription       - Locator of description films
     * @param genre                 - Text for comparing
     * @param nextPageButtonLocator - Locator Go to next page
     */
    public boolean checkTextOnAllPages(String filmDescription, String genre, String nextPageButtonLocator) {

        pageNumber = 0;
        boolean assertResult;

        while (true) {

            assertResult = compareDescriptionWithName(filmDescription, genre);

            try {
                findByCss(nextPageButtonLocator).click();
            } catch (StaleElementReferenceException | NoSuchElementException ex) {
                break;
            }
            pageNumber += 1;

        }
        return assertResult;
    }
}
