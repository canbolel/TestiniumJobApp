import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class IncreaseProductQuantity {
    WebDriver driver;

    //Finding increase quantity button.
    @FindBy(xpath = "//div[@id='newCheckout']/div/div/div[2]/div/section/table[2]/tbody/tr/td[3]/div/div/span")
    public WebElement increaseQuantityButton;

    //Constructor
    public IncreaseProductQuantity(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Click function for increase quantity button.
    public void clickIncreaseQuantityButton() {
        increaseQuantityButton.click();
    }

    //Function to get current quantity of the product from cart page then returning it to control.
    public int getCurrentQuantity() {
        WebElement checkQuantity = driver.findElement(By.name("cartItemQuantity"));
        int quantity = Integer.parseInt(checkQuantity.getAttribute("value"));
        return quantity;
    }


}
