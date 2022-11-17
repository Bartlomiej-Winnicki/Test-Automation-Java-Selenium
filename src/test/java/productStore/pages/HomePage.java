package productStore.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import productStore.utils.SeleniumHelper;

import java.util.List;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = ".carousel-inner")
    private WebElement carousel;

    @FindBy(css = "img[alt='First slide']")
    private WebElement firstSlide;

    @FindBy(css = "img[alt='Second slide']")
    private WebElement secondSlide;

    @FindBy(css = "img[alt='Third slide']")
    private WebElement thirdSlide;

    @FindBy(css = "span[class='carousel-control-prev-icon']")
    private WebElement sliderLeftCaret;

    @FindBy(css = "span[class='carousel-control-next-icon']")
    private WebElement sliderRightCaret;

    @FindBy(css = "li[data-slide-to='0']")
    private WebElement sliderLeftBtn;

    @FindBy(css = "li[data-slide-to='1']")
    private WebElement sliderCenterBtn;

    @FindBy(css = "li[data-slide-to='2']")
    private WebElement sliderRightBtn;

    @FindBy(css = "img[class='d-block img-fluid']") // "img[class='d-block img-fluid']"
    private List<WebElement> sliderImages;

    @FindBy(xpath = "//img[@class='card-img-top img-fluid']")
    private List<WebElement> productsImages;

    @FindBy(xpath = "//img[@class='d-block img-fluid']")
    private WebElement slide;

    private static final Logger logger = LogManager.getLogger();

    public void clickLeftSliderCaret() throws InterruptedException {
        logger.info("Clicking sliders left caret");
        sliderLeftCaret.click();
        SeleniumHelper.waitForAnimationToComplete();
        logger.info("Sliders left caret clicked");
    }

    public void clickRightSliderCaret() throws InterruptedException {
        logger.info("Clicking sliders right caret");
        sliderRightCaret.click();
        SeleniumHelper.waitForAnimationToComplete();
        logger.info("Sliders right caret clicked");
    }

    public void clickLeftSliderBtn() {
        logger.info("Clicking sliders left button");
        sliderLeftBtn.click();
        SeleniumHelper.waitForElementToBeVisible(driver, firstSlide, 2);
        logger.info("Sliders left button clicked");
    }

    public void clickCenterSliderBtn() {
        logger.info("Clicking sliders center button");
        sliderCenterBtn.click();
        SeleniumHelper.waitForElementToBeVisible(driver, secondSlide, 2);
        logger.info("Sliders center button clicked");
    }

    public void clickRightSliderBtn() {
        logger.info("Clicking sliders right button");
        sliderRightBtn.click();
        SeleniumHelper.waitForElementToBeVisible(driver, thirdSlide, 2);
        logger.info("Sliders right button clicked");
    }

    public WebElement getVisibleSlide() throws InterruptedException {
        logger.info("Getting currently visible slide");
        SeleniumHelper.waitForAnimationToComplete();
        return sliderImages.stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .get();
    }

    public void clickProductImage() throws InterruptedException {
        logger.info("Clicking product image");
        SeleniumHelper.waitForNonEmptyDisplayedList(driver, By.xpath("//img[@class='card-img-top img-fluid']"), 2);
        productsImages.stream().findFirst().ifPresent(WebElement::click);
        logger.info("Product image clicked");
    }

    public void hoverOverCarousel() throws InterruptedException {
        logger.info("Hovering cursor over the slider");
        Actions actions = new Actions(driver);
        actions.moveToElement(carousel).perform();
        SeleniumHelper.waitForSliderRotationToComplete();
        logger.info("Wait for rotation completed");
    }
}
