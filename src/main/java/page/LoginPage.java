package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    private static final By LOGIN_FIELD = By.id("mailbox__login");
    private static final By PASSWORD_FIELD = By.id("mailbox__password");
    private static final By LOGIN_BUTTON = By.id("mailbox__auth__button");

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    public MailBoxPage login(String email, String password) {
        getLoginField().click();
        getLoginField().sendKeys(email);
        getPasswordField().click();
        getPasswordField().sendKeys(password);
        getLoginButton().click();
        return new MailBoxPage(driver);
    }

    private WebElement getLoginField() {
        return driver.findElement(LOGIN_FIELD);
    }

    private WebElement getPasswordField() {
        return driver.findElement(PASSWORD_FIELD);
    }

    private WebElement getLoginButton() {
        return driver.findElement(LOGIN_BUTTON);
    }

    public boolean isLoginButtonDisplayed() {
        return driver.findElement(LOGIN_BUTTON).isDisplayed();
    }
}
