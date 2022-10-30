package productStore.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }

    @FindBy(xpath = "//button[@data-target='#orderModal']")
    private WebElement placeOrderBtn;

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

    private static final Logger logger = LogManager.getLogger();

    public void clickPlaceOrderButton() {
        logger.info("Clicking 'Place Order' button");
        placeOrderBtn.click();
    }

    public void enterName(String name) {
        logger.info("Entering name");
        nameInput.sendKeys(name);
    }

    public void enterCountry(String country) {
        logger.info("Entering country");
        countryInput.sendKeys(country);
    }

    public void enterCity(String city) {
        logger.info("Entering city");
        cityInput.sendKeys(city);
    }

    public void enterCardNumber(String cardNumber) {
        logger.info("Entering card number");
        cardInput.sendKeys(cardNumber);
    }

    public void enterMonth(String month) {
        logger.info("Entering month number");
        monthInput.sendKeys(month);
    }

    public void enterYear(String year) {
        logger.info("Entering year");
        yearInput.sendKeys(year);
    }

    public void clickPurchaceBtn() {
        logger.info("Clicking purchase button");
        purchaseBtn.click();
    }




}
