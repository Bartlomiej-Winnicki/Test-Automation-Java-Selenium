package productStore.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    WebDriver driver;

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }

    @FindBy(css = "[class='btn btn-success btn-lg']")
    private WebElement addToCartBtn;

    @FindBy(css = "#cartur")
    private WebElement cartLink;

    private static final Logger logger = LogManager.getLogger();

    public void addToCart() throws InterruptedException {
        logger.info("Adding product to cart");
        Thread.sleep(2000);
        addToCartBtn.click();
        logger.info("Product added to cart");
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
    }

    public void goToCart() {
        logger.info("Going to cart");
        cartLink.click();
    }

}
