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


import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SignInTest extends BasicTestSetup {


    @Test
    public void signIn() {
        HomePage homePage = PageFactory.initElements(webDriver, HomePage.class);
        Util.login(homePage, webDriver, System.getenv("login"), System.getenv("password"));
        assertNotEquals(homePage.profileIcon, null);
    }
}
