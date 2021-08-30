package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy (name = "login[username]")
    WebElement loginEmailField;

    @FindBy (name = "login[password]")
    WebElement loginPasswordField;

    @FindBy (xpath = "//button[@class = 'action login primary']")
    WebElement loginButton;

    @FindBy (xpath = "//div[@data-bind = 'html: $parent.prepareMessageForHtml(message.text)']")
    WebElement errorMessageContainer;


    ChromeDriver driver = null;
    public LoginPage (ChromeDriver driver) {
        driver.get("https://planetasport.rs/customer/account/login/");
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public LoginPage enterUserName(String userName) {
        loginEmailField.sendKeys(userName);
        return this;
    }

    public LoginPage enterPassword(String password) {
        loginPasswordField.sendKeys(password);
        return this;
    }
    public ClientPage clickSubmitButtonSuccess() {
        loginButton.click();
        return new ClientPage(driver);
    }

    public LoginPage clickSubmitButtonFailure() {
        loginButton.click();
        return this;
    }

    public String getErrorMessage() {
        String errorMessage = errorMessageContainer.getText();
        return errorMessage;
    }
}
