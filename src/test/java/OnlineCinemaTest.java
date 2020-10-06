import configuration.ConfigurationTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import steps.OnlineCinemaSteps;


public class OnlineCinemaTest extends ConfigurationTest {

    @DataProvider(name = "Genre")
    public Object[][] getData() {
        Object[][] data = {{"Ужасы"}, {"Боевик"}, {"Детектив"}, {"Фэнтези"}, {"Фантастика"}, {"Комедия"}};
        return data;
    }

    @Test(dataProvider = "Genre", priority = 1, description = "Check films descriptions")
    public void checkEqualFilmsGenres(String genre) {

        var onlineCinemaSteps = new OnlineCinemaSteps(driver, wait);

        onlineCinemaSteps
                .getOnlineFilmsDescription(genre)
                .assertOnlineCinemaDescription();
    }

    @Test(dataProvider = "Genre", priority = 2, description = "Check series descriptions")
    public void checkEqualSeriesGenres(String genre) {

        var onlineCinemaSteps = new OnlineCinemaSteps(driver, wait);

        onlineCinemaSteps
                .getOnlineSeriesDescription(genre)
                .assertOnlineCinemaDescription();
    }

    @Test(dataProvider = "Genre", priority = 3, description = "Check cartoon descriptions")
    public void checkEqualCartoonGenres(String genre) {

        var onlineCinemaSteps = new OnlineCinemaSteps(driver, wait);

        onlineCinemaSteps
                .getOnlineCartoonDescription(genre)
                .assertOnlineCinemaDescription();
    }
}

