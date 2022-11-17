package productStore.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import productStore.pages.HomePage;

public class PurchaseTest extends BaseTest {

    @Test
    public void buyItemTest() {
        String purchaseSuccessMessage = new HomePage(driver)
                .clickProductImage()
                .addToCart()
                .acceptAlert()
                .goToCart()
                .clickPlaceOrderButton()
                .enterName("Bartłomiej Winnicki")
                .enterCountry("Poland")
                .enterCity("Opole")
                .enterCardNumber("1111111111111")
                .enterMonth("12")
                .enterYear("1986")
                .clickPurchaseBtn()
                .getPurchaseSuccessMessage();
        Assert.assertEquals(purchaseSuccessMessage, "Thank you for your purchase!");
    }
}
