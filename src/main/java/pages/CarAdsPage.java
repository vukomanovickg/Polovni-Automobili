package pages;

import common.BaseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import resources.Locators;

import java.util.List;

public class CarAdsPage extends BaseMethods {

    List<WebElement> elements;

    public CarAdsPage waitForCarAdsPageToBeLoaded() {
        waitForElementToBeVisible(Locators.CAR_ADS_PAGE);
        pause(3000);
        return this;
    }

    public CarDetailPage selectRandomCar() {
        elements = getDriver().findElements(Locators.ALL_CAR_ADDS);
        int numberOfCarAds = elements.size();
        By model = null;
        CarDetailPage detailPage = null;
        if (numberOfCarAds != 0) {
            int randomNumber = getRandomIndex(numberOfCarAds);
            log.info("Random car number: {}", randomNumber);
//            System.out.println("Random car number:" + randomNumber);
            model = By.xpath(Locators.ARTICLE + "[" + randomNumber + "]//img");
            waitForElementToBeVisible(model);
            scrollToElement(model);
            pause(2000);
            clickOnElement(model);
            detailPage = new CarDetailPage();
        } else {
            log.error("There is no models with selected filters. Please change filters.");
            throw new Error("There is no models with selected filters. Please change filters.");
        }
        pause(3000);
        return detailPage;
    }

}
