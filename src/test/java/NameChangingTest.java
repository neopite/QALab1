import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import signIn.HomePage;
import signIn.Util;
import userProfile.UserCredentialsPage;
import userProfile.UserProfilePage;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class NameChangingTest extends BasicTestSetup {

    @Test
    public void changeNameAndSurnameOnProfilePage() {
        HomePage homePage = PageFactory.initElements(webDriver, HomePage.class);
        Util.login(homePage, webDriver,System.getenv("login"),System.getenv("password"));
        homePage.profileIcon.click();
        UserProfilePage userProfilePage = PageFactory.initElements(webDriver, UserProfilePage.class);
        userProfilePage.submitButton();
        UserCredentialsPage userCredentialsPage = PageFactory.initElements(webDriver, UserCredentialsPage.class);
        userCredentialsPage.username.clear();
        userCredentialsPage.setNewUsername("Obruch Vladimir");
        userCredentialsPage.saveButton.click();
        String text = userProfilePage.getProfileUsername().getText();
        assertEquals(text, "Obruch Vladimir");
    }
}
