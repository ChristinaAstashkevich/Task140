package core;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import page.LoginPage;
import page.MailBoxPage;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class TestBase {

    WebDriver driver;
    protected LoginPage loginPage;
    protected MailBoxPage mailBoxPage;
    private String baseUrl = "https://mail.ru/";


    @Parameters("browser")
    @BeforeMethod
    public void setStrategy(String browser) throws MalformedURLException{

        driver = GridDriver.getDriver(browser);
        driver.navigate().to(baseUrl);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
