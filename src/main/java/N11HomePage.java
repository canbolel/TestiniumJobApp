import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class N11HomePage {
    WebDriver driver;

    //Giving a static link to main page to start the processes.
    private static String MainPageUrl = "https://www.n11.com";

    //Finding Login button on main page.
    @FindBy(how = How.LINK_TEXT, using = "Giriş Yap")
    private WebElement loginButton;

    //Constructor
    public N11HomePage(WebDriver driver) {
        this.driver = driver;
        driver.get(MainPageUrl);
        PageFactory.initElements(driver, this);
    }

    //Click function for Login button to prepare for next test case.
    public void clickOnLoginButton() {
        loginButton.click();
    }


}
