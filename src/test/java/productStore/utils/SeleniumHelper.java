package productStore.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumHelper {

public static void waitForElementToExist(WebDriver driver,By locator, int duration) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
    wait.until(ExpectedConditions.presenceOfElementLocated(locator));
}

public static void waitForElementToBeVisible(WebDriver driver, WebElement element, int duration) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
    wait.until(ExpectedConditions.visibilityOf(element));
}
}
