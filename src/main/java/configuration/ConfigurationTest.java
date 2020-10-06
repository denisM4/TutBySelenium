package configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.MainPage;

import java.util.concurrent.TimeUnit;

public class ConfigurationTest {

    protected static WebDriver driver;
    protected static WebDriverWait wait;

    private static MainPage mainPage;

    private void init() {

        driver = new ChromeDriver();
        driver.get("https://www.tut.by/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(12, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);

        mainPage = new MainPage(driver, wait);

    }

    @BeforeMethod
    public void setUp() {
        init();
    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
