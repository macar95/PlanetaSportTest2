package pages;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ClientPage extends BasePage{

    @FindBy(className = "nav items" )
    WebElement mojNalogOpcije;

    @FindBy(xpath = "//a[@href = \"https://planetasport.rs/sales/order/history/\"]")
    WebElement mojePorudzbineOpcija;

    @FindBy (xpath = "//a[@href = \"https://planetasport.rs/wishlist/\"]")
    WebElement mojaListaZeljaOpcija;

    @FindBy (xpath = "/html/body/div[2]/main/div[2]/div[2]/div/div[2]/ul/li[5]/a")
    WebElement adreseOpcija;

    @FindBy (xpath = "/html/body/div[2]/main/div[2]/div[2]/div/div[2]/ul/li[6]/a")
    WebElement informacijeonaloguOpcija;

    @FindBy (xpath = "//a[@href=\"https://planetasport.rs/vault/cards/listaction/\"]")
    WebElement spremljeniNaciniPlacanjaOpcija;

    @FindBy (xpath = "//a[@href=\"https://planetasport.rs/vault/cards/listaction/\"]")
    WebElement myProductReviewsOpcija;

    @FindBy (id = "/html/body/div[2]/main/div[2]/div[2]/div/div[2]/ul/li[10]/a")
    WebElement newsletterPrijavaOpcija;

    @FindBy (className = "facebook")
    WebElement facebookOption;

    @FindBy (className = "instagram")
    WebElement instagramOption;

    @FindBy (className = "youtube")
    WebElement youtubeOption;

    @FindBy (className = "pinterest")
    WebElement pinterestOption;

    @FindBy (className = "tiktok")
    WebElement tiktokOption;







    public ClientPage(ChromeDriver driver) {
        super(driver);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("We are not on Client page", currentUrl.contains("account"));
    }
}


