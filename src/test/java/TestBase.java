import org.apache.log4j.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestBase {

    WebDriver driver;

    @Before
    public void setup() {
        //Chrome Driver location on local computer. Please change it to your local chromedriver location.
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\xstsn\\Desktop\\chromedriver_win32\\chromedriver.exe");
        //Creating a new driver with ChromeDrive
        driver = new ChromeDriver();
    }

    @Test
    public void testOneHomepage() throws InterruptedException {

        //Creating Logger
        final Logger logger = Logger.getLogger(this.getClass());
        PropertyConfigurator.configure("src/log4j.properties");

        //Test Case for N11 home page
        N11HomePage homePage; //Creating a HomePage element.
        homePage = new N11HomePage(driver);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.n11.com/"); //Checking if the HomePage is open.
        logger.debug("Homepage opened successfully.");
        homePage.clickOnLoginButton(); //Directing Page to Login Page for next case.
        Thread.sleep(3000); //Waiting for driver to load the page.

        //Test Case for N11 login page.
        N11LoginPage loginPage; //Creating a LoginPage element.
        loginPage = new N11LoginPage(driver);
        loginPage.setLoginMail("jobtestqp@yandex.com"); //Sending Login information to necessary areas.
        loginPage.setLoginPassword("111111a"); //Sending Login information to necessary areas.
        loginPage.clickOnLogin();
        Thread.sleep(3000); //Waiting for driver to load the page.
        Assert.assertFalse((driver.findElements(By.className("btnSignIn")).size() > 0)); //Checking if the Login successful.
        logger.debug("Log in successful.");

        //Test Case for Search Page Change.
        SearchPageChange searchPageChange; //Creating a searchPageChange element.
        searchPageChange = new SearchPageChange(driver);
        searchPageChange.clickSearchBox();
        searchPageChange.setSearchBox("bilgisayar"); //Sending keyword to Search box.
        searchPageChange.clickSearchButton();
        Thread.sleep(2000); //Waiting for driver to load the page.
        searchPageChange.clickNextPage();
        Thread.sleep(3000); //Waiting for driver to load the page.
        Assert.assertEquals("https://www.n11.com/arama?q=bilgisayar&pg=2", driver.getCurrentUrl()); //Checking if the second page of the committed search is opened.
        logger.debug("Search page 2 opened successfully.");

        //Test Case for choosing random product and getting product's price from product page for comparison
        ChooseProduct chooseProduct; //Creating a ChooseProduct element.
        chooseProduct = new ChooseProduct(driver);
        chooseProduct.chooseRandomProduct(); // Choosing a product randomly then clicking on the product.
        Thread.sleep(3000); //Waiting for driver to load the page.
        Assert.assertFalse((driver.findElements(By.className("wrapper product")).size() > 0)); //Checking if the Product Page is opened.
        logger.debug("Product page opened successfully.");
        String pagePrice = chooseProduct.productPrice(); //Getting  value of the product from product page.
        System.out.println(pagePrice);

        //Test Case for adding a product to cart and also checking if price is right on both ends.
        AddToCart addToCart; //Creating a AddToCart element.
        addToCart = new AddToCart(driver);
        addToCart.clickAddToCartButton(); //Adding product to the cart.
        Thread.sleep(3000); //Waiting for driver to load the page.
        addToCart.clickCartHolder(); //Opening cart page.
        String cartPrice = addToCart.cartPrice(); //Getting  value of the product from cart page.
        Assert.assertEquals(pagePrice, cartPrice); //Checking if the prices are equal on both product and cart page.
        logger.debug("Product price matches with the cart price.");

        //Test Case for increasing the quantity of product in cart to 2
        IncreaseProductQuantity increaseProductQuantity; //Creating a IncreaseProductQuantity element.
        increaseProductQuantity = new IncreaseProductQuantity(driver);
        increaseProductQuantity.clickIncreaseQuantityButton(); //Increasing the quantity of the product.
        Thread.sleep(3000); //Waiting for driver to load the page.
        int quantity = increaseProductQuantity.getCurrentQuantity(); // Getting the current quantity of the item.
        Assert.assertEquals(quantity, 2); //Checking if the quantity of the product is equal to "2".
        logger.debug("Product quantity increased successfully.");

        //Test Case for clearing the cart
        ClearCart clearCart; //Creating a ClearCart element.
        clearCart = new ClearCart(driver);
        clearCart.clickClearCartButton();
        Assert.assertFalse(driver.findElements(By.className("cartEmptyText")).size() > 0); //Checking if the cart is empty.
        logger.debug("Product has been removed from the cart successfully.");


    }


    @After
    public void close() {
        driver.close();
    }


}
