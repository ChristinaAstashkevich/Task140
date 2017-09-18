import core.TestBase;
import helper.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class GridTest extends TestBase {

    private  static final String EMAIL = "seleniumtests10@mail.ru";
    private  static final String PASSWORD = "060788avavav";

    @Test
    public void loginTest() {
        mailBoxPage = loginPage.login(EMAIL, PASSWORD);
        Assert.assertTrue(mailBoxPage.isComposeButtonDisplayed(), "Compose button is not displayed");
    }

    @Test
    public void logoutTest() {
        mailBoxPage = loginPage.login(EMAIL, PASSWORD);
        mailBoxPage.logout();
        Assert.assertTrue(loginPage.isLoginButtonDisplayed(),"Login link is not displayed");
    }
}

