package productStore.tests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import productStore.utils.DriverFactory;
import productStore.utils.PropertiesLoader;

import java.io.IOException;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() throws IOException {
        driver = DriverFactory.getDriver();
        if(Boolean.valueOf(PropertiesLoader.loadProperty("browser.maximize"))){
        driver.manage().window().maximize();
        } else {
            String widthProperty = PropertiesLoader.loadProperty("browser.width");
            String heightProperty = PropertiesLoader.loadProperty("browser.height");
            Dimension d = new Dimension(Integer.parseInt(widthProperty),Integer.parseInt(heightProperty));
            driver.manage().window().setSize(d);
        }
        driver.get("https://www.demoblaze.com/index.html");
    }

    @AfterMethod
    public void teardown(ITestResult result) {
        String name = result.getMethod().getMethodName();
        System.out.println(result.getStatus());
        System.out.println(name);
        driver.quit();
    }

}
