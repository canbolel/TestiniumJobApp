import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;




public class AddToCart {

    WebDriver driver;
    //Finding add to cart button.
    @FindBy(how = How.LINK_TEXT, using = "Sepete Ekle")
    private WebElement addToCartButton;
    //Finding open cart button.
    @FindBy(how = How.CLASS_NAME, using = "myBasketHolder")
    private WebElement cartHolder;

    //Constructor
    public  AddToCart(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    //Clicking function for add to cart button.
    public void clickAddToCartButton(){
        addToCartButton.click();
    }
    //Clicking function for cart button.
    public void clickCartHolder( ) {
        cartHolder.click();
    }
    //Function for finding and returning the value of product from the cart page for comparison.
    public String cartPrice(){
        String[] cart_price = driver.findElement(By.className("price")).getText().split(" ");
        String cartPrice = cart_price[0];
        return cartPrice;
    }
}
