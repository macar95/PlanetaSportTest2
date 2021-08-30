import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import pages.ClientPage;
import pages.LoginPage;
import pages.Strings;

import java.util.concurrent.TimeUnit;

import static pages.Strings.CLIENT_URL;

public class BaseTest {


    public ChromeDriver openChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"--start-maximized"});
        options.addArguments(new String[]{"--ignore-certificate-errors"});
        options.addArguments(new String[]{"--disable-popup-blocking"});
        options.addArguments(new String[]{"--incognito"});
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        ChromeDriver driver = new ChromeDriver(options);
        return driver;
    }

    public void logIn () {
        ChromeDriver driver = openChromeDriver();
        driver.get("https://planetasport.rs/");

        //WebElement logInOption = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[1]/a"));
        //logInOption.click();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserName(Strings.USER_NAME);
        loginPage.enterPassword(Strings.VALID_PASSWORD);

        WebElement element = driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div/div[2]/div[1]/div[2]/form/fieldset/div[4]/div[1]/button/span"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();

        sleep();

        String currentPageURL = driver.getCurrentUrl();
        assert currentPageURL.equals(CLIENT_URL): "Error. You are not logged in. Expected : " +
                CLIENT_URL + ". Actual : " + currentPageURL;

        //Assert.assertTrue("We are logged in. Expected url : " + Strings.CLIENT_URL +
        //        ". Actual: " + currentPageURL, currentPageURL.contains(Strings.LOGIN_URL));

        //driver.quit();

    }


    public ClientPage loginToClientPage() {
        ChromeDriver driver =  openChromeDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserName(Strings.USER_NAME);
        loginPage.enterPassword(Strings.VALID_PASSWORD);
        ClientPage ClientPage = loginPage.clickSubmitButtonSuccess();
        return ClientPage;
    }

    public void sleep(){
        try{
            Thread.sleep(2000);

        } catch (Exception e) {}
    }

}
