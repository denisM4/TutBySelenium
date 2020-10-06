package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OnlineCinemaPage extends Driver {

    private WebDriver webDriver;
    private WebDriverWait wait;

    public OnlineCinemaPage(WebDriver webDriver, WebDriverWait wait) {
        super(webDriver, wait);
        this.webDriver = webDriver;
        this.wait = wait;
    }

    private String filmDescription = "div.txt p";
    private final String filmsWidgetTab = "a[data-show = 'movie']";
    private final String seriesWidgetTab = "a[data-show = 'serial']";
    private final String cartoonsWidgetTab = "a[data-show = 'animation']";
    private final String genresDropDownButton = "div.active button";
    private final String nextPageButton = ".p-next a";

    public OnlineCinemaPage clickFilmsTab() {
        findByCss(filmsWidgetTab).click();
        return this;
    }

    public OnlineCinemaPage clickSeriesTab() {
        findByCss(seriesWidgetTab).click();
        return this;
    }

    public OnlineCinemaPage clickCartoonTab() {
        findByCss(cartoonsWidgetTab).click();
        return this;
    }

    public OnlineCinemaPage selectGenre(String name) {
        scrollToElement(webDriver, genresDropDownButton);
        findByCss(genresDropDownButton).click();
        findInListByValue(findAll("div.active a span"), name).click();
        waitUntilDescriptionIsLoaded();
        return this;
    }

    public String getStringFilmDescription() {
        return filmDescription;
    }

    public String getNextPageButton() {
        return nextPageButton;
    }
}