import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import signIn.HomePage;
import signIn.Util;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SignInTest extends BasicTestSetup{


    @Test
    public void signIn(){
        HomePage homePage = PageFactory.initElements(webDriver, HomePage.class);
        Util.login(homePage,webDriver,homePage.correctEmail,homePage.correctPassword);
        assertNotEquals(homePage.profileIcon,null);
    }
    @Test
    public void signInFailed(){
        HomePage homePage = PageFactory.initElements(webDriver, HomePage.class);
        Util.login(homePage,webDriver,"gregerger@gmail.com","gf34g34g34");
        assertNotEquals(homePage.getErrorField(),null);
    }

}
