package common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseMethods extends Properties {

    public static final Logger log = LogManager.getLogger();

    protected void clickOnElement(By locator) {
        getDriver().findElement(locator).click();
    }

    protected void type(By locator, String text) {
        getDriver().findElement(locator).sendKeys(text);
    }

    protected boolean waitForElementToBeVisible(By locator) {
        boolean isVisible = true;
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            isVisible = false;
        }
        return isVisible;
    }

    protected boolean waitForElementToBeClickable(By locator) {
        boolean isVisible = true;
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
            wait.until(ExpectedConditions.elementToBeClickable(locator));

        } catch (Exception e) {
            isVisible = false;
        }
        return isVisible;
    }

    protected void pause(Integer milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getElementText(By locator) {
        String text = "";
        try {
            waitForElementToBeVisible(locator);
            text = getDriver().findElement(locator).getText();
        } catch (Exception e) {
            throw new RuntimeException("Unable to get text");
        }
        return text;
    }

    protected void scrollToElement(By locator) {
        WebElement element = getDriver().findElement(locator);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView()", element);
    }

    public int getRandomIndex(int MaxValue) {
        Random random = new Random();
        return MaxValue == 1 ? 1 : random.nextInt(MaxValue - 1) + 1;

    }

    protected void openNewTab() {
        getDriver().switchTo().newWindow(WindowType.TAB);
    }
}
