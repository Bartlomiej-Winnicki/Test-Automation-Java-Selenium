package productStore.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import productStore.pages.CartPage;
import productStore.pages.HomePage;
import productStore.pages.ProductPage;

public class BuyItemTest extends BaseTest {

    @Test
    public void buyItemTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickProductImage();
        ProductPage productPage = new ProductPage(driver);
        productPage.addToCart();
        productPage.acceptAlert();
        productPage.goToCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.clickPlaceOrderButton();
        cartPage.enterName("Bartłomiej Winnicki");
        cartPage.enterCountry("Poland");
        cartPage.enterCity("Opole");
        cartPage.enterCardNumber("1111111111111");
        cartPage.enterMonth("12");
        cartPage.enterYear("1986");
        cartPage.clickPurchaseBtn();
        Assert.assertEquals(cartPage.getPurchaseSuccessMessage(), "Thank you for your purchase!");
    }
}
