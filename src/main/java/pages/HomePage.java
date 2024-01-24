package pages;

import common.BaseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import resources.Locators;

import java.util.List;

public class HomePage extends BaseMethods {

    List<WebElement> elements;
    public HomePage waitForHomePageToBeLoaded(){
        waitForElementToBeVisible(Locators.HOME_PAGE);
        pause(2000);
        return this;
    }
    public HomePage checkIfThereIs8DropDowns(){
        elements = getDriver().findElements(Locators.DROP_DOWN_MENU);
        int numberOfDropDowns = elements.size();
        if(numberOfDropDowns == 8) {
            log.info("Success: Site have exact 8 dropdown filters:");
//            System.out.println("Success: Site have exact 8 dropdown filters:");
            for (int i= 0; i<numberOfDropDowns; i++) {
                log.info("item"+i+": {}",elements.get(i).getDomProperty("title"));
//                System.out.println("item"+i+": "+elements.get(i).getDomProperty("title"));
            }
            return this;
        }else if(numberOfDropDowns>8){
            log.error("Site have more then 8 filters");
        }else {
            log.error("Site have less then 8 filters");
        }
        pause(3000);
        return null;
    }
    public HomePage selectRandomCarModel(){
        By model = By.xpath(Locators.MODEL_BRAND);
        scrollToElement(model);
        List<WebElement> options = getDriver().findElements(Locators.SELECT_BRAND_OPTION);
        int numberOfCarModels = options.size();
        if (numberOfCarModels !=0) {
            int randomNumber = getRandomIndex(numberOfCarModels-1)+1; // skip first 2 options
            WebElement spanClick = getDriver().findElements(Locators.SELECT_CAR_MODEL).get(0);
            waitForElementToBeVisible(Locators.SELECT_CAR_MODEL);
            spanClick.click();
            WebElement option = options.get(randomNumber);
            model = By.xpath(Locators.BRAND_OPTION+"["+randomNumber+"]");
            waitForElementToBeClickable(model);
//            scrollToElement(model);
            pause(2000);
            option.click();

        }else{
            log.error("There is no models to select.");
            throw new Error("There is no models to select.");
        }
        pause(3000);
        return this;
    }

    public HomePage insertPrice(String price){
        type(Locators.PRICE_BOX, price);
        pause(2000);
        return this;
    }
    public CarAdsPage clickOnSearch(){
        getDriver().findElement(Locators.SEARCH_BUTTON).click();
        return new CarAdsPage();
    }


    public CarDetailPage clickOnFirstCar(){
        By model = By.xpath(Locators.FIRST_CAR);
        scrollToElement(model);
        waitForElementToBeClickable(Locators.FIRST_CAR_ADD);
        pause(2000);
        elements = getDriver().findElements(Locators.FIRST_CAR_ADD);
        elements.get(0).click();

        CarDetailPage detailPage = new CarDetailPage();
        return detailPage;
    }
}
