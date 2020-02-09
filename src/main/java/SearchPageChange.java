import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class SearchPageChange {

    WebDriver driver;

    //Finding search area in the main page after Login.
    @FindBy(how = How.ID, using = "searchData")
    private WebElement searchBox;

    //Finding search button in the main page after Login.
    @FindBy(how = How.CLASS_NAME, using = "searchBtn")
    private WebElement searchButton;

    //Finding second page button in the main page after Login.
    @FindBy(how = How.LINK_TEXT, using = "2")
    private WebElement nextPage;

    //Constructor
    public SearchPageChange(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    //Click function for Search box for choosing the are to write "bilgisayar".
    public void clickSearchBox() {
        searchBox.click();
    }

    //Send key function for Search box.
    public void setSearchBox(String keys){
        searchBox.sendKeys(keys);
    }

    //Click function for search button.
    public void clickSearchButton() {
        searchButton.click();
    }

    //Click function to go to second page.
    public void clickNextPage() {
        nextPage.click();
    }

}
