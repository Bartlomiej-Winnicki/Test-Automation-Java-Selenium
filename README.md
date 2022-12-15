# Product Store Test Automation Project
Welcome to my java/selenium automation project 👋  
It's a small set of tests demonstrating my freshly gained skills in java/selenium test automation. We will be testing demoblaze.com/index.html - demo store site, among others for automation learning purposes.  
 
## Languages and Frameworks
This project uses:
* __Java 18__ as a language
* __Selenium WebDriver__ as the browser automation framework
* __TestNG__ as the testing framework
* __Log4j__ as a log library
* __Intellij__ as the IDE

## Architecture and functionalieties  
👉 __Screenshots__ - At teardown of every test method, screenshot will be taken, and saved in resources/screenshots directory. Screenshots names are same as the test method name, if test suceeded. Otherwise method name will be preceded with "failed" string.

   <details>
 <summary>Click for details</summary>  
   I didn't want screenshots to litter folder they are in, so they are removed before starting tests, for better readability. Responsible for this function is
    @BeforeTest method, testSetup:
   
   ```java
       @BeforeTest
   public void testSetup() throws IOException {
       FileUtils.cleanDirectory(new File("src/test/resources/screenshots"));
   }
   ```
   
   Then, @AfterMethod method, teardown should take and save new screenshots:
   
   ```java
   @AfterMethod
   public void teardown(ITestResult result) throws IOException {
       String status = "";
       if (result.getStatus() == ITestResult.FAILURE) status = "failed";
       String name = (status + result.getMethod().getMethodName());
       TakesScreenshot screenshot = (TakesScreenshot) driver;
       File scrFile = screenshot.getScreenshotAs(OutputType.FILE);
       FileUtils.copyFile(scrFile, new File("src/test/resources/screenshots/" + name + ".png"));
       driver.quit();
   }
   ```
   Screenshots for failed tests are saved with names starting with "failed", what makes them easier to spot(intellij shows them alphabetically):  
   
   ![screenshotsss](https://user-images.githubusercontent.com/109470151/201717672-368265db-2790-4adf-ab91-df69e2eae5f8.png)

</details>

👉 __Fluent approach__ - As "master" branch in project uses traditional Page Object Pattern, "fluent" branch utilizes fluent approach.  
     <details>
 <summary>Click for details</summary>
   
   While managing two separate branches may be considered a nightmare, or at least an unnecessary effort, I've decided to create second one in later stage of the     project, just to demonstrate a fluent approach to Page Object Model. After some initial effort to make required changes to methods in page objects, fluent allows us to  chain methods in tests, which speeds up work, and makes our code more readable.
   
   Example of fluent test method:
    
 ```java
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
 ```  
  </details>

👉  __Logging__ - Project uses Log4j library. Logs configuration is contained in Log4j2.xml file.
   
  <details>
   <summary>Click for details</summary>
   Lines responsible for printing logs are written in almost every method in "Page" classes, for example:  
   
   ```java
   public void clickProductImage() throws InterruptedException {
       logger.info("Clicking product image");
       SeleniumHelper.waitForNonEmptyDisplayedList(driver, By.xpath("//img[@class='card-img-top img-fluid']"), 2);
       productsImages.stream().findFirst().ifPresent(WebElement::click);
       logger.info("Product image clicked");
   }
   ```
   Logs alongside with screenshots can help user to identify cause of possible test fail. Example of logs in console:
    ![idea64_RAGbddnFTh](https://user-images.githubusercontent.com/109470151/201386415-52d86d24-3058-416f-8542-79bb681e6b03.gif)
</details>

👉 __Browser configuration__ - Browser configuration avaible to set is: browser type(Chrome or Mozilla), browser headless mode, window size and window maximization. This settings are easily accesible at config.properties file.
  
   <details>
    <summary>Click for details</summary>  
   Content of config.properties file:  
    
   ```properties
   browser.name=chrome
   browser.maximize=true
   browser.width=1200
   browser.height=1000
   browser.headless=true
   ```
   This settings are processed by loadProperties method:
   
   ```java
   public static String loadProperty(String propertyName) throws IOException {

    InputStream inputStream = new FileInputStream("src/test/resources/config.properties");
       Properties properties = new Properties();
       properties.load(inputStream);
       return properties.getProperty(propertyName);
   }
   ```
   And used in DriverFactory.java and BaseTest.java classes.

   </details>  
     
  

