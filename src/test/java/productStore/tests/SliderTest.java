package productStore.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import productStore.pages.HomePage;

public class SliderTest extends BaseTest {

    @Test
    public void leftCaretTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickLeftSliderCaret();
        Thread.sleep(1000);
        Assert.assertEquals(homePage.getVisibleSlide().getAttribute("alt"),"Third slide");
    }
    @Test
    public void rightCaretTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickRightSliderCaret();
        Thread.sleep(1000);
        Assert.assertEquals(homePage.getVisibleSlide().getAttribute("alt"),"Second slide");
    }

    @Test
    public void sliderRightBtnTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickRightSliderBtn();
        Thread.sleep(1000);
        Assert.assertEquals(homePage.getVisibleSlide().getAttribute("alt"),"Third slide");
    }

    @Test
    public void sliderCenterBtnTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickCenterSliderBtn();
        Thread.sleep(1000);
        Assert.assertEquals(homePage.getVisibleSlide().getAttribute("alt"),"Second slide");
    }

    @Test
    public  void sliderLeftBtnTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickRightSliderBtn();
        homePage.clickLeftSliderBtn();
        Thread.sleep(1000);
        Assert.assertEquals(homePage.getVisibleSlide().getAttribute("alt"),"First slide");
    }
}