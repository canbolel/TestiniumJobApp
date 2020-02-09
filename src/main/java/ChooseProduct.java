import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;


public class ChooseProduct {
    WebDriver driver;

    //Finding all eligible items to randomly choose from.
    @FindBy(how = How.CLASS_NAME, using = "plink")
    private List<WebElement> items;

    //Constructor
    public ChooseProduct(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Function to choose a random product from eligible items then clicking on the selected item.
    public void chooseRandomProduct() {
        Random rand = new Random();
        WebElement random = items.get(rand.nextInt(27) + 11);
        random.click();
    }

    //Function for finding and returning the value of product from the product page for comparison.
    public String productPrice() {
        String price = "";
        String[] productPrice = driver.findElement(By.className("newPrice")).getText().split(" ");
        price = productPrice[0];
        return price;
    }

}
