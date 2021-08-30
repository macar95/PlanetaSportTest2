import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import pages.ClientPage;

import java.time.Duration;

import static pages.Strings.*;

public class LoginTests extends BaseTest {

    /**
     * Test - Successful login with valid credentials
     * Steps:
     * 1. Navigate to planeta sport site
     * 2. enter valid username/e-mail
     * 3. enter valid password
     * 4. click login button
     *
     * Expected result:
     * 4.Verify that user is logged in
     */
    @Test
    public void testSuccessfulLogIn() {
        ChromeDriver driver = openChromeDriver();
        driver.get("https://planetasport.rs/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserName(Strings.USER_NAME);
        loginPage.enterPassword(Strings.VALID_PASSWORD);

        WebElement loginButton = driver.findElement(By.xpath("//button[@class=\"action login primary\"]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(loginButton).click().build().perform();

        sleep();

        String currentPageURL = driver.getCurrentUrl();
        assert currentPageURL.equals(CLIENT_URL): "Error. You are not logged in. Expected : " +
                CLIENT_URL + ". Actual : " + currentPageURL;

        driver.quit();
    }


    /**
     * Test - Successful logout
     * Steps:
     * 1. Log in
     * 2. click logout button
     *
     * Expected result:
     * 2. Verify that user is logged out
     */

    @Test
    public void testSucessfulLogOut() throws InterruptedException {
        //logIn();
        ChromeDriver driver = openChromeDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserName(Strings.USER_NAME);
        loginPage.enterPassword(Strings.VALID_PASSWORD);

        WebElement logInButton = driver.findElement(By.xpath("//button[@class=\"action login primary\"]"));
        logInButton.click();

        sleep();

        String currentPageURL = driver.getCurrentUrl();
        assert currentPageURL.equals(CLIENT_URL): "Error. You are not logged in. Expected : " +
                CLIENT_URL + ". Actual : " + currentPageURL;

        //kopirao full xpath za log out button zato sto pronalazi dva.

        WebElement logOutButton = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a"));
        logOutButton.click();

        sleep();

        Assert.assertTrue("We are logged in. Expected url : " + LOGOUT_URL +
                ". Actual: " + currentPageURL, currentPageURL.contains(Strings.LOGOUT_URL));

        driver.quit();
    }

    /**
     * Test - Unsuccessful login with invalid username and valid password
     * Steps:
     * 1. Navigate to planeta sport site
     * 2. enter invalid username/e-mail
     * 3. enter valid password
     * 4. click login button
     *
     * Expected result:
     * 4.Verify that user is not logged in, stays on login page
     * Verify that error message is shown
     */
    @Test
    public void testInvalidUsernameAndValidPass() {
        ChromeDriver driver = openChromeDriver();
        try {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.enterUserName(Strings.INVALID_USER_NAME);
            loginPage.enterPassword(Strings.VALID_PASSWORD);
            loginPage.clickSubmitButtonFailure();

            sleep();

            String currentPageURL = driver.getCurrentUrl();
            Assert.assertTrue("We are not logged in. Expected url : " + CLIENT_URL +
                    ". Actual: " + currentPageURL, currentPageURL.contains(Strings.LOGIN_URL));
            String currentErrorMessage = loginPage.getErrorMessage();
            Assert.assertTrue("Wrong error: Expected : " + Strings.LOGIN_ERROR_MESSAGE + ". Actual: "
                    + currentErrorMessage, currentErrorMessage.equals(Strings.LOGIN_ERROR_MESSAGE));
        } finally {
            driver.quit();
        }

    }

    /**
     * Test - Unsuccessful login with valid username and invalid password
     * Steps:
     * 1. Navigate to planeta sport site
     * 2. enter valid username/e-mail
     * 3. enter invalid password
     * 4. click login button
     *
     * Expected result:
     * 4.Verify that user is not logged in, stays on login page
     * Verify that error message is shown
     */

    @Test
    public void testValidUsernameAndInvalidPass() {
        ChromeDriver driver = openChromeDriver();
        try {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.enterUserName(Strings.USER_NAME);
            loginPage.enterPassword(Strings.INVALID_PASSWORD);
            loginPage.clickSubmitButtonFailure();

            // WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"loginPage\"]/div/div[1]//span[@class='infoError']"));
            // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            // wait.until(ExpectedConditions.visibilityOf(errorMessage));

            sleep();

            String currentPageURL = driver.getCurrentUrl();
            Assert.assertTrue("We are not logged in. Expected url : " + CLIENT_URL +
                    ". Actual: " + currentPageURL, currentPageURL.contains(Strings.LOGIN_URL));
            String currentErrorMessage = loginPage.getErrorMessage();
            Assert.assertTrue("Wrong error: Expected : " + Strings.LOGIN_ERROR_MESSAGE + ". Actual: "
                    + currentErrorMessage, currentErrorMessage.equals(Strings.LOGIN_ERROR_MESSAGE));
        } finally {
            driver.quit();
        }

    }

}


