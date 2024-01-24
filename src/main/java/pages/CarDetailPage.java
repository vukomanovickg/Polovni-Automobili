package pages;

import common.BaseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import resources.Locators;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CarDetailPage extends BaseMethods {
    public CarDetailPage waitForCarDetailPageToBeLoaded(boolean inNewTab) {
        if(inNewTab) {
            ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
            getDriver().switchTo().window(tabs.get(1));
        }
        waitForElementToBeVisible(Locators.CAR_DETAIL_PAGE);
        pause(3000);
        return this;
    }
    public CarDetailPage carDetails() {
        By carName = By.xpath("//h1");
        By carPrice = By.xpath( "//span[contains(@class,'priceClassified')]");

        log.info("Car name: {}", getElementText(carName));
        log.info("Car price: {}", getElementText(carPrice));
//        System.out.println("Car name: " + getElementText(carName));
//        System.out.println("Car price: " + getElementText(carPrice));

        return this;
    }
}
