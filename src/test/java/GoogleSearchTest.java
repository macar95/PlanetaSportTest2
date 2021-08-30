import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GoogleSearchTest {

    @Test
    public void googleSearchTest () {
        ChromeDriver driver = new ChromeDriver();
        try {
            driver.get("https://www.google.com");
            WebElement searchField = driver.findElement(By.name("q"));
            searchField.click();
            searchField.sendKeys("planeta sport");
            WebElement googleSearchButton = driver.findElement(By.name("btnK"));
            WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(2));
            wait.until(ExpectedConditions.visibilityOf(googleSearchButton));

            googleSearchButton.click();

            WebElement searchList = driver.findElement(By.id("search"));
            wait.until(ExpectedConditions.visibilityOf(searchList));
            List<WebElement> searchResults = driver.findElements(By.xpath(".//div[@class = 'g']"));
            for(WebElement result : searchResults ) {
                WebElement e = result.findElement(By.xpath(".//h3"));
                String text = e.getText();
                System.out.println(text);
                if(text.contains("Planeta Sport: Patike, Sportska oprema, obuća, odeća ...")) {
                    e.click();
                    break;
                }
            }
            Assert.assertTrue("Wrong web site", driver.getCurrentUrl().equals("https://planetasport.rs/"));



        } finally {
            driver.quit();
        }

    }

}
