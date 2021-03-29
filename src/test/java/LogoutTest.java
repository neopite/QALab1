import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import signIn.HomePage;
import signIn.Util;
import userProfile.UserProfilePage;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LogoutTest extends BasicTestSetup {

    @Test
    public void successfulLogout(){
        HomePage homePage = PageFactory.initElements(webDriver, HomePage.class);
        Util.login(homePage,webDriver,System.getenv("login"),System.getenv("password"));
        homePage.profileIcon.click();
        UserProfilePage userProfilePage = PageFactory.initElements(webDriver,UserProfilePage.class);
        userProfilePage.submitLogout();
        assertNotEquals(homePage.getAuthStatus(),null);
    }
}
