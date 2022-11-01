package productStore.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import productStore.utils.SeleniumHelper;


public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//button[@data-target='#orderModal']")
    private WebElement placeOrderBtn;

    @FindBy(css = "#orderModalLabel")
    private WebElement formHeading;

    @FindBy(css = "#name")
    private WebElement nameInput;

    @FindBy(css = "#country")
    private WebElement countryInput;

    @FindBy(css = "#city")
    private WebElement cityInput;

    @FindBy(css = "#card")
    private WebElement cardInput;

    @FindBy(css = "#month")
    private WebElement monthInput;

    @FindBy(css = "#year")
    private WebElement yearInput;

    @FindBy(xpath = "//button[@onclick='purchaseOrder()']")
    private WebElement purchaseBtn;

    @FindBy(xpath = "//h2[text()='Thank you for your purchase!']")
    private WebElement purchaseSuccessMessage;

    private static final Logger logger = LogManager.getLogger();

    public CartPage clickPlaceOrderButton() {
        logger.info("Clicking 'Place Order' button");
        placeOrderBtn.click();
        SeleniumHelper.waitForElementToBeVisible(driver, formHeading, 2);
        return new CartPage(driver);
    }

    public CartPage enterName(String name) {
        logger.info("Entering name");
        nameInput.sendKeys(name);
        return new CartPage(driver);
    }

    public CartPage enterCountry(String country) {
        logger.info("Entering country");
        countryInput.sendKeys(country);
        return new CartPage(driver);
    }

    public CartPage enterCity(String city) {
        logger.info("Entering city");
        cityInput.sendKeys(city);
        return new CartPage(driver);
    }

    public CartPage enterCardNumber(String cardNumber) {
        logger.info("Entering card number");
        cardInput.sendKeys(cardNumber);
        return new CartPage(driver);
    }

    public CartPage enterMonth(String month) {
        logger.info("Entering month number");
        monthInput.sendKeys(month);
        return new CartPage(driver);
    }

    public CartPage enterYear(String year) {
        logger.info("Entering year");
        yearInput.sendKeys(year);
        return new CartPage(driver);
    }

    public CartPage clickPurchaseBtn() {
        logger.info("Clicking purchase button");
        purchaseBtn.click();
        return new CartPage(driver);
    }

    public String getPurchaseSuccessMessage() {
        return purchaseSuccessMessage.getText();
    }


}
