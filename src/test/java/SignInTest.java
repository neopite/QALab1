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

public class SignInTest {

    private static String SITE_URL = "https://dou.ua/";
    public WebDriver webDriver;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void signIn(){
        HomePage homePage = PageFactory.initElements(webDriver, HomePage.class);
        Util.login(homePage,webDriver,homePage.correctEmail,homePage.correctPassword);
        WebElement webElement1 =webDriver.findElement(By.className("min-profile"));
        assertNotEquals(webElement1,null);
    }
    @Test
    public void signInFailed(){
        HomePage homePage = PageFactory.initElements(webDriver, HomePage.class);
        Util.login(homePage,webDriver,"gregerger@gmail.com","gf34g34g34");
        WebElement errorField = webDriver.findElement(By.id("error-for-username"));
        assertNotEquals(errorField,null);
    }

}
