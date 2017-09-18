package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailBoxPage {
    private WebDriver driver;

    private static final By COMPOSE_BUTTON = By.cssSelector("[data-name='compose']");
    private static final By LOGOUT_LINK = By.id("PH_logoutLink");

    public MailBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage logout() {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(LOGOUT_LINK));
        driver.findElement(LOGOUT_LINK).click();
        return new LoginPage(driver);
    }

    public boolean isComposeButtonDisplayed(){
        return driver.findElement(COMPOSE_BUTTON).isDisplayed();
    }
}


