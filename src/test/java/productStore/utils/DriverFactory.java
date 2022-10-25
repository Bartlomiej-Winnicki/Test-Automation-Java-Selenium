package productStore.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.IOException;

public class DriverFactory {


    public static WebDriver getDriver() throws IOException {
        String name = PropertiesLoader.loadProperty("browser.name");
        String headless = PropertiesLoader.loadProperty("browser.headless");
        String maximize = PropertiesLoader.loadProperty("browser.maximize");

        if (name.equals("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            if(Boolean.valueOf(headless)){
            options.addArguments("--headless");
            }
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver(options);
        }
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(Boolean.valueOf(headless));
        options.addArguments("--window-size=1920,1080");
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(options);
    }


}
