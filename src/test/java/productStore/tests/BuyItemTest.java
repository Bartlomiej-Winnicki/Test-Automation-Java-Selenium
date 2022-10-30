package productStore.tests;

import org.testng.annotations.Test;
import productStore.pages.CartPage;
import productStore.pages.HomePage;
import productStore.pages.ProductPage;

public class BuyItemTest extends BaseTest {

    @Test
    public void buyItemTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(2000);
        homePage.clickProductImage();
        ProductPage productPage = new ProductPage(driver);
        productPage.addToCart();
        Thread.sleep(2000);
        productPage.goToCart();
        Thread.sleep(3000);
        CartPage cartPage = new CartPage(driver);
        cartPage.clickPlaceOrderButton();
        Thread.sleep(2000);
        cartPage.enterName("Bartłomiej Winnicki");
        cartPage.enterCountry("Poland");
        cartPage.enterCity("Opole");
        cartPage.enterCardNumber("1111111111111");
        cartPage.enterMonth("12");
        cartPage.enterYear("1986");
        cartPage.clickPurchaceBtn();
        Thread.sleep(3000);
    }
}
