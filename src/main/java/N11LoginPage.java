import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class N11LoginPage {
    WebDriver driver;

    //Finding mail address box in Login page.
    @FindBy(how = How.ID, using = "email")
    private WebElement loginMail;

    //Finding password box in Login page.
    @FindBy(how = How.ID, using = "password")
    private WebElement loginPassword;

    //Finding Login button in Login page.
    @FindBy(how = How.ID, using = "loginButton")
    private WebElement loginButton;

    //Constructor
    public N11LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Filling mail box in Login page.
    public void setLoginMail(String strEmail) {
        loginMail.sendKeys(strEmail);
    }

    //Filling password box in Login page.
    public void setLoginPassword(String password) {
        loginPassword.sendKeys(password);
    }

    //Click function for Login button.
    public void clickOnLogin() {
        loginButton.click();
    }


}
