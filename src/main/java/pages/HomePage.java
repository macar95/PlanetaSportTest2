package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(className = "pNewAdd" )
    WebElement newAddOption;

    @FindBy(className = "pAddList")
    WebElement listOfMyAdsOption;

    @FindBy (className = "pU_Data")
    WebElement myDataOption;

    @FindBy (className = "pMsg")
    WebElement messagesOption;

    @FindBy (className = "pFav")
    WebElement myFavoriteOption;

    @FindBy (className = "pWeSrch")
    WebElement myChoiceEmailOption;

   @FindBy (className = "headerActions")
   WebElement searchEmailButton;

   @FindBy (className = "headerActions favourites")
   WebElement favouritesDropDownField;

   @FindBy (id = "ajax_login")
   WebElement LogInButton;

    public HomePage(ChromeDriver driver) {
        super(driver);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("We are not on Home page", currentUrl.contains("mojauto"));
    }
}
