import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import signIn.HomePage;
import signIn.SignInTest;
import signIn.Util;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LogoutTest extends SignInTest {

    @Test
    public void succesfullLogout(){
        HomePage homePage = PageFactory.initElements(webDriver, HomePage.class);
        Util.login(homePage,webDriver,homePage.correctEmail,homePage.correctPassword);
        webDriver.findElement(By.className("min-profile")).click();
        UserProfilePage userProfilePage = PageFactory.initElements(webDriver,UserProfilePage.class);
        userProfilePage.submitLogout();
        assertNotEquals(homePage.getAuthStatus(),null);
    }
}
