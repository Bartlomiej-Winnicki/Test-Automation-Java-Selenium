package productStore.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import productStore.utils.SeleniumHelper;

public class ProductPage {

    WebDriver driver;

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = "[class='btn btn-success btn-lg']")
    private WebElement addToCartBtn;

    @FindBy(css = "#cartur")
    private WebElement cartLink;

    private static final Logger logger = LogManager.getLogger();

    public ProductPage addToCart() throws InterruptedException {
        logger.info("Adding product to cart");
        SeleniumHelper.waitForElementToBeVisible(driver, addToCartBtn, 2);
        addToCartBtn.click();
        logger.info("Product added to cart");
        return new ProductPage(driver);
    }

    public ProductPage acceptAlert() throws InterruptedException {
        SeleniumHelper.waitForAlertToAppear(driver, 2);
        logger.info("Accepting alert");
        driver.switchTo().alert().accept();
        logger.info("Alert accepted");
        return new ProductPage(driver);
    }

    public CartPage goToCart() {
        logger.info("Clicking 'Cart' link");
        cartLink.click();
        logger.info("'Cart' link clicked");
        return new CartPage(driver);
    }

}
