package productStore.tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import productStore.utils.DriverFactory;
import productStore.utils.PropertiesLoader;

import java.io.File;
import java.io.IOException;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void testSetup() throws IOException {
        FileUtils.cleanDirectory(new File("src/test/resources/screenshots"));
    }

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
    public void teardown(ITestResult result) throws IOException {
        String status = "";
        if(result.getStatus() == ITestResult.FAILURE) status = "failed";
        String name = (status + result.getMethod().getMethodName());
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File scrFile = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("src/test/resources/screenshots/" + name + ".png"));
        System.out.println(result.getStatus());
        System.out.println(name);
        driver.quit();
    }

}
