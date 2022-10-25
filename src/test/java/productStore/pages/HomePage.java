package productStore.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

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

    private static final Logger logger = LogManager.getLogger();

    public void clickLeftSliderCaret() {
        sliderLeftCaret.click();
    }

    public void clickRightSliderCaret() {
        sliderRightCaret.click();
    }

    public void clickLeftSliderBtn() {
        sliderLeftBtn.click();
    }

    public void clickCenterSliderBtn() {
        sliderCenterBtn.click();
    }

    public void clickRightSliderBtn() {
        sliderRightBtn.click();
    }

    public WebElement getVisibleSlide() {
        return sliderImages.stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .get();
    }
}
