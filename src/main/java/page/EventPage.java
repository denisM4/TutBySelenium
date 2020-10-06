package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EventPage extends Driver {

    private WebDriver webDriver;
    private WebDriverWait wait;

    public EventPage(WebDriver webDriver, WebDriverWait wait) {
        super(webDriver, wait);
        this.webDriver = webDriver;
        this.wait = wait;
    }

    private final String onlineCinemaButton = "a[href*='online-cinema']";

    public OnlineCinemaPage clickOnlineCinemaButton() {
        findByCss(onlineCinemaButton).click();
        return new OnlineCinemaPage(webDriver, wait);
    }
}
