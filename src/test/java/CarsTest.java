import common.BaseMethods;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import resources.Constants;

public class CarsTest extends BaseMethods {

    @BeforeTest
    public void setUp(){
        createDriver();
        getDriver().get(Constants.CARS_URL);
    }
    @Test
    public void testDropDownMenu(){
        HomePage homePage = new HomePage();
        homePage.waitForHomePageToBeLoaded()
                .checkIfThereIs8DropDowns();
    }

    @Test
    public void testBrandAndPriceFilter(){
        HomePage homePage = new HomePage();
        homePage.waitForHomePageToBeLoaded()
                .selectRandomCarModel()
                .insertPrice("15000")
                .clickOnSearch()
                .waitForCarAdsPageToBeLoaded()
                .selectRandomCar()
                .waitForCarDetailPageToBeLoaded(false)
                .carDetails();
    }

    @Test
    public void testFirstCarDetails(){
        HomePage homePage = new HomePage();
        homePage.waitForHomePageToBeLoaded()
                .clickOnFirstCar()
                .waitForCarDetailPageToBeLoaded(true)
                .carDetails();
    }
    @AfterTest
    public void close(){
        quitDriver();
    }
}
