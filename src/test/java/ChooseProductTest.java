import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Strings;

import java.time.Duration;
import java.util.List;

import static pages.Strings.CHECKOUT_URL;
import static pages.Strings.CLIENT_URL;

public class ChooseProductTest extends BaseTest {

    /**
     * Test - Successful enter text in search field and finding product by its name
     * Steps:
     * 1. Navigate to planeta sport site
     * 2. enter name of product in the search box
     * 3. click search button
     * 4. find specified product
     * 5. click on the product
     * Expected result:
     * 4. Verify that user is on specified product page
     */

    @Test
    public void SearchFieldTest() {
        ChromeDriver driver = openChromeDriver();
        driver.get("https://planetasport.rs/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        WebElement searchField = driver.findElement(By.id("search"));
        searchField.sendKeys("nike legend");
        searchField.sendKeys(Keys.ENTER);

        WebElement productsList = driver.findElement(By.id("amasty-shopby-product-list"));
        List<WebElement> itemsInList = driver.findElements(By.xpath("//li[@class = 'item product product-item']"));
        for (WebElement element : itemsInList) {
            if (element.getText().contains("PATIKE NIKE LEGEND")) {
                WebElement nikeLegend = element.findElement(By.xpath("//img[@alt = 'PATIKE NIKE LEGEND ESSENTIAL M - CD0443-006']"));
                nikeLegend.click();

                String currentPageURL = driver.getCurrentUrl();
                Assert.assertTrue("We are on Nike legend product page. Expected url : " + Strings.NIKE_LEGEND_URL +
                        ". Actual: " + currentPageURL, currentPageURL.contains(Strings.HOMEPAGE_URL));

                break;
            }

        }

        driver.quit();

    }

}
