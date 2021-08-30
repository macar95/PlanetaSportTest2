import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Strings;

import java.time.Duration;
import java.util.List;

import static pages.Strings.CHECKOUT_URL;

public class BuyingProductTest extends BaseTest{

    /**
     * Test - Successful going on checkout page
     * Steps:
     * 1. Navigate to planeta sport site
     * 2. enter name of product in the search box
     * 3. click search button
     * 4. find specified product
     * 5. click on the product
     * 6. click on the size of the product
     * 7. click on add to cart button
     * 8. click on pay button
     * Expected result:
     * 4. Verify that user is on checkout page
     */

    @Test
    public void BuyingProductTest() {
        ChromeDriver driver = openChromeDriver();
        driver.get("https://planetasport.rs/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        WebElement searchField = driver.findElement(By.id("search"));
        searchField.sendKeys("adidas");
        searchField.sendKeys(Keys.ENTER);

        WebElement productsList = driver.findElement(By.id("amasty-shopby-product-list"));
        List<WebElement> itemsInList = driver.findElements(By.xpath("//li[@class = 'item product product-item']"));
        for (WebElement element : itemsInList) {
            if (element.getText().contains("PATIKE D ROSE")) {
                WebElement adidasRose = element.findElement(By.xpath("//img[@alt = 'PATIKE D ROSE 773 2020 J BG - FW8788']"));
                adidasRose.click();

                String currentPageURL = driver.getCurrentUrl();
                Assert.assertTrue("We are on Nike legend product page. Expected url : " + Strings.ADIDAS_ROSE_URL +
                        ". Actual: " + currentPageURL, currentPageURL.contains(Strings.HOMEPAGE_URL));

                break;
            }

        }
        sleep();
        WebElement brojObuce = driver.findElement(By.xpath("//div[@id=\"option-label-size-158-item-30\"]"));
        brojObuce.click();

        WebElement dodajUKorpuDugme = driver.findElement(By.xpath("//button[@title=\"Dodaj u korpu\"]"));
        dodajUKorpuDugme.click();

        sleep();

        WebElement idiNaPlacanje = driver.findElement(By.xpath("//button[@id=\"top-cart-btn-checkout\"]"));
        idiNaPlacanje.click();
        sleep();

        String currentPageURL = driver.getCurrentUrl();
        assert currentPageURL.equals(CHECKOUT_URL): "Error. You are not on checkout page. Expected : " +
                CHECKOUT_URL + ". Actual : " + currentPageURL;

        driver.quit();

    }
}
