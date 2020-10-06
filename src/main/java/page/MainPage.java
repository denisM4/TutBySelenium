package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends Driver {

    private WebDriver webDriver;
    private WebDriverWait wait;

    public MainPage(WebDriver webDriver, WebDriverWait wait) {
        super(webDriver, wait);
        this.webDriver = webDriver;
        this.wait = wait;
    }

    String eventsButton = ".b-topbar-i a[title='Афиша']";

    public EventPage eventsButtonClick() {
        findByCss(eventsButton).click();
        return new EventPage(webDriver, wait);
    }
}
