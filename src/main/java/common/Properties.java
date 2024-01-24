package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Properties {
    private static WebDriver driver;
    private static final String CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String CHROME_DRIVER_PATH = "src\\main\\resources\\chromedriver.exe";
    public static WebDriver getDriver(){

        return driver;
    }
    public static void setDriver(WebDriver driver){

        Properties.driver = driver;
    }
    public static void createDriver() {
        if(driver==null){
            System.setProperty(CHROME_DRIVER, CHROME_DRIVER_PATH);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-infobars");
            options.addArguments("start-maximized");
            options.addArguments("--disable-notification");
            options.addArguments("--disable-gpu");

            driver = new ChromeDriver(options);

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Time.IMPLICIT_WAIT));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Time.PAGE_LOAD_TIMEOUT));
            setDriver(driver);
        }
    }
    public static void quitDriver(){
        getDriver().quit();
        driver=null;
    }


}
