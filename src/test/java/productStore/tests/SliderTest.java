package productStore.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import productStore.pages.HomePage;
import productStore.utils.SeleniumHelper;

public class SliderTest extends BaseTest {

    @Test
    public void leftCaretTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickLeftSliderCaret();
        Assert.assertEquals(homePage.getVisibleSlide().getAttribute("alt"), "Third slide");
    }

    @Test
    public void rightCaretTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickRightSliderCaret();
        Assert.assertEquals(homePage.getVisibleSlide().getAttribute("alt"), "Second slide");
    }

    @Test
    public void sliderRightBtnTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickRightSliderBtn();
        Assert.assertEquals(homePage.getVisibleSlide().getAttribute("alt"), "Third slide");
    }

    @Test
    public void sliderCenterBtnTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickCenterSliderBtn();
        Assert.assertEquals(homePage.getVisibleSlide().getAttribute("alt"), "Second slide");
    }

    @Test
    public void sliderLeftBtnTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickRightSliderBtn();
        homePage.clickLeftSliderBtn();
        Assert.assertEquals(homePage.getVisibleSlide().getAttribute("alt"), "First slide");
    }

    @Test
    public void sliderHoverTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.hoverOverCarousel();
        SeleniumHelper.waitForSliderRotationToComplete();
        Assert.assertEquals(homePage.getVisibleSlide().getAttribute("alt"), "First slide");
    }

    @Test
    public void sliderRotationTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        SeleniumHelper.waitForSliderRotationToComplete();
        Assert.assertEquals(homePage.getVisibleSlide().getAttribute("alt"), "Second slide");
    }
}
