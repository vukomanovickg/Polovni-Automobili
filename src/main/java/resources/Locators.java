package resources;

import org.openqa.selenium.By;

public class Locators {
    public static  final String MODEL_BRAND = "//select[@id='brand']";
    public static  final String ARTICLE = "//article";
    public static final String FIRST_CAR = "//div[@id='top-pagination']";
    public static final String BRAND_OPTION = "//div[contains(@class,'sumo_brand')]//div[@class='optWrapper']//li[contains(@class,'opt')]";
    public static final By DROP_DOWN_MENU = setLocator("//div[contains(@class,'SumoSelect')]//p[contains(@class,'CaptionCont')]");
    public static final By SELECT_CAR_MODEL = setLocator("//span[contains(@class,'placeholder')]");
    public static final By SELECT_BRAND_OPTION = setLocator(BRAND_OPTION);
    public static final By PRICE_BOX = setLocator("//input[@id='price_to']");
    public static final By SEARCH_BUTTON = setLocator("//button[@name='submit_1']");
    public static final By ALL_CAR_ADDS = setLocator(ARTICLE);
    public static final By FIRST_CAR_ADD = setLocator("//a[contains(@class,'home-featured-ad')]");

    static public By setLocator(String s){
        return By.xpath(s);
    }
    public static final By HOME_PAGE = setLocator("//h1[contains(@class,'home-title')]");

    public static final By CAR_ADS_PAGE = setLocator("//h1[contains(@class,'searchTitle')]");
    public static final By CAR_DETAIL_PAGE = setLocator("//h2[contains(@class,'classified-title')]");
}
