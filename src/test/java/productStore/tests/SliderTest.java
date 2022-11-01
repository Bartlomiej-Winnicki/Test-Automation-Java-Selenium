package productStore.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import productStore.pages.HomePage;
import productStore.utils.SeleniumHelper;

public class SliderTest extends BaseTest {

    @Test
    public void leftCaretTest() throws InterruptedException {
        WebElement visibleSlide = new HomePage(driver)
                .clickLeftSliderCaret()
                .getVisibleSlide();
        Assert.assertEquals(visibleSlide.getAttribute("alt"), "Third slide");
    }

    @Test
    public void rightCaretTest() throws InterruptedException {
        WebElement visibleSlide = new HomePage(driver)
                .clickRightSliderCaret()
                .getVisibleSlide();
        Assert.assertEquals(visibleSlide.getAttribute("alt"), "Second slide");
    }

    @Test
    public void sliderRightBtnTest() throws InterruptedException {
        WebElement visibleSlide = new HomePage(driver)
                .clickRightSliderBtn()
                .getVisibleSlide();
        Assert.assertEquals(visibleSlide.getAttribute("alt"), "Third slide");
    }

    @Test
    public void sliderCenterBtnTest() throws InterruptedException {
        WebElement visibleSlide = new HomePage(driver)
                .clickCenterSliderBtn()
                .getVisibleSlide();
        Assert.assertEquals(visibleSlide.getAttribute("alt"), "Second slide");
    }

    @Test
    public void sliderLeftBtnTest() throws InterruptedException {
        WebElement visibleSlide = new HomePage(driver)
                .clickRightSliderBtn()
                .clickLeftSliderBtn()
                .getVisibleSlide();
        Assert.assertEquals(visibleSlide.getAttribute("alt"), "First slide");
    }

    @Test
    public void sliderHoverTest() throws InterruptedException {
        WebElement visibleSlide = new HomePage(driver)
                .hoverOverCarouselForRotationTime()
                .getVisibleSlide();
        Assert.assertEquals(visibleSlide.getAttribute("alt"), "First slide");
    }

    @Test
    public void sliderRotationTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        SeleniumHelper.waitForSliderRotationToComplete();
        Assert.assertEquals(homePage.getVisibleSlide().getAttribute("alt"), "Second slide");
    }
}
