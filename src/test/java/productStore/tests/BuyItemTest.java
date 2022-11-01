package productStore.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import productStore.pages.CartPage;
import productStore.pages.HomePage;
import productStore.pages.ProductPage;

public class BuyItemTest extends BaseTest {

    @Test
    public void buyItemTest() throws InterruptedException {
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
