import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ClientPage;
import pages.LoginPage;
import pages.Strings;

import static pages.Strings.*;

public class PovezimoSeTest extends BaseTest {

    private WebDriver driver;

    /**
     * Test - Successful loading facebook page of planeta sport site
     * Steps:
     * 1. Navigate to planeta sport site
     * 2. click facebook button
     *
     * Expected result:
     * 4. open facebook page of planeta sport site
     */

    @Test
    public void povezimoSeFacebook () {
        ChromeDriver driver = openChromeDriver();
        driver.get("https://planetasport.rs/");
        WebElement facebookOption = driver.findElement(By.className("facebook"));
        facebookOption.click();
        String currentPageURL = driver.getCurrentUrl();
        assert currentPageURL.equals(FACEBOOK_PAGE_URL): "Error. You are not on facebook page url. Expected : " +
                FACEBOOK_PAGE_URL + ". Actual : " + currentPageURL;
        driver.quit();
    }

    /**
     * Test - Successful loading instagram page of planeta sport site
     * Steps:
     * 1. Navigate to planeta sport site
     * 2. click instagram button
     *
     * Expected result:
     * 4. open instagram page of planeta sport site
     */

    @Test
    public void povezimoSeInstagram () {
        ChromeDriver driver = openChromeDriver();
        driver.get("https://planetasport.rs/");
        WebElement instagramOption = driver.findElement(By.className("instagram"));
        instagramOption.click();
        String currentPageURL = driver.getCurrentUrl();
        assert currentPageURL.equals(INSTAGRAM_PAGE_URL): "Error. You are not on instagram page url. Expected : " +
                INSTAGRAM_PAGE_URL + ". Actual : " + currentPageURL;
        driver.quit();
    }

    /**
     * Test - Successful loading youtube page of planeta sport site
     * Steps:
     * 1. Navigate to planeta sport site
     * 2. click youtube button
     *
     * Expected result:
     * 4. open youtube page of planeta sport site
     */

    @Test
    public void povezimoSeYoutube () {
        ChromeDriver driver = openChromeDriver();
        driver.get("https://planetasport.rs/");
        WebElement youtubeOption = driver.findElement(By.className("youtube"));
        youtubeOption.click();
        String currentPageURL = driver.getCurrentUrl();
        assert currentPageURL.equals(YOUTUBE_PAGE_URL): "Error. You are not on youtube page url. Expected : " +
                YOUTUBE_PAGE_URL + ". Actual : " + currentPageURL;
        driver.quit();
    }

    /**
     * Test - Successful loading pinterest page of planeta sport site
     * Steps:
     * 1. Navigate to planeta sport site
     * 2. click pinterest button
     *
     * Expected result:
     * 4. open pinterest page of planeta sport site
     */

    @Test
    public void povezimoSePinterest () {
        ChromeDriver driver = openChromeDriver();
        driver.get("https://planetasport.rs/");
        WebElement pinterestOption = driver.findElement(By.className("pinterest"));
        pinterestOption.click();
        String currentPageURL = driver.getCurrentUrl();
        assert currentPageURL.equals(PINTEREST_PAGE_URL): "Error. You are not on pinterest page url. Expected : " +
                PINTEREST_PAGE_URL + ". Actual : " + currentPageURL;
        driver.quit();
    }

    /**
     * Test - Successful loading tiktok page of planeta sport site
     * Steps:
     * 1. Navigate to planeta sport site
     * 2. click tiktok button
     *
     * Expected result:
     * 4. open tiktok page of planeta sport site
     */

    @Test
    public void povezimoSeTiktok () {
        ChromeDriver driver = openChromeDriver();
        driver.get("https://planetasport.rs/");
        WebElement tiktokOption = driver.findElement(By.className("tiktok"));
        tiktokOption.click();
        String currentPageURL = driver.getCurrentUrl();
        assert currentPageURL.equals(TIKTOK_PAGE_URL): "Error. You are not on tiktok page url. Expected : " +
                TIKTOK_PAGE_URL + ". Actual : " + currentPageURL;
        driver.quit();
    }
}
