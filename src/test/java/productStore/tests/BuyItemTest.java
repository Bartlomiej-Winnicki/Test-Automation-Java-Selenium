package productStore.tests;

import org.testng.annotations.Test;
import productStore.pages.HomePage;
import productStore.pages.ProductPage;

public class BuyItemTest extends BaseTest {

    @Test
    public void buyItem() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(2000);
        homePage.clickProductImage();
        ProductPage productPage = new ProductPage(driver);
        productPage.addToCart();
        Thread.sleep(2000);
        productPage.goToCart();
        Thread.sleep(3000);
    }
}
