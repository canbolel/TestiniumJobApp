import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClearCart {
    WebDriver driver;

    //Finding clear cart button.
    @FindBy(xpath = "//div[@id='newCheckout']/div/div/div[2]/div/section/table[2]/tbody/tr/td/div[3]/div[2]/span")
    public WebElement clearCartButton;

    //Constructor
    public ClearCart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Click function for the clear cart button.
    public void clickClearCartButton() {
        clearCartButton.click();
    }


}
