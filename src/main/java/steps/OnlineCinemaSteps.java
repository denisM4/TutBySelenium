package steps;

import Util.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import page.MainPage;
import page.OnlineCinemaPage;

public class OnlineCinemaSteps {

    private WebDriver webDriver;
    private WebDriverWait wait;

    private String genre;

    public OnlineCinemaSteps(WebDriver webDriver, WebDriverWait wait) {
        this.webDriver = webDriver;
        this.wait = wait;
    }

    public OnlineCinemaSteps getOnlineFilmsDescription(String genre) {

        new MainPage(webDriver, wait)
                .eventsButtonClick()
                .clickOnlineCinemaButton()
                .clickFilmsTab()
                .selectGenre(genre);

        this.genre = genre;
        return this;
    }

    public OnlineCinemaSteps getOnlineSeriesDescription(String genre) {

        new MainPage(webDriver, wait)
                .eventsButtonClick()
                .clickOnlineCinemaButton()
                .clickSeriesTab()
                .selectGenre(genre);

        this.genre = genre;
        return this;
    }

    public OnlineCinemaSteps getOnlineCartoonDescription(String genre) {

        new MainPage(webDriver, wait)
                .eventsButtonClick()
                .clickOnlineCinemaButton()
                .clickCartoonTab()
                .selectGenre(genre);

        this.genre = genre;
        return this;
    }

    public void assertOnlineCinemaDescription() {

        var onlineCinemaPage = new OnlineCinemaPage(webDriver, wait);
        var util = new Util(webDriver, wait);
        boolean checkResult;

        checkResult = util
                .checkTextOnAllPages(onlineCinemaPage.getStringFilmDescription(), genre, onlineCinemaPage.getNextPageButton());
        Assert.assertTrue(checkResult, "Genre is not have description with name - '- " + genre + " -'");

    }
}
