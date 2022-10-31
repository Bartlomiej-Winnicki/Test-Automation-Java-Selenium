package productStore.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumHelper {

    public static void waitForElementToExist(WebDriver driver, By locator, int duration) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void waitForElementToBeVisible(WebDriver driver, WebElement element, int duration) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForNotEmptyDisplayedList(WebDriver driver, By locator, int duration) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(el -> el.findElements(locator).stream().filter(ele -> ele.isDisplayed()).count() > 0);
    }

    public static void waitForAlertToAppear(WebDriver driver, int duration) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public static void waitForAnimationToComplete() throws InterruptedException {
        Thread.sleep(570);
    }

    public static void waitForSliderRotationToComplete() throws InterruptedException {
        Thread.sleep(5050);
    }
}
