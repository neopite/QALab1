import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import signIn.HomePage;
import signIn.Util;
import userProfile.UserCredentialsPage;
import userProfile.UserProfilePage;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class NameChangingTest extends SignInTest {

    @Test
    public void changeNameAndSurnameOnProfilePage(){
            HomePage homePage = PageFactory.initElements(webDriver, HomePage.class);
            Util.login(homePage,webDriver,homePage.correctEmail,homePage.correctPassword);
            webDriver.findElement(By.className("min-profile")).click();
            UserProfilePage userProfilePage = PageFactory.initElements(webDriver,UserProfilePage.class);
            userProfilePage.submitButton();
            UserCredentialsPage userCredentialsPage = PageFactory.initElements(webDriver,UserCredentialsPage.class);
            userCredentialsPage.username.clear();
            userCredentialsPage.username.sendKeys("Obruch Vladimir");
            userCredentialsPage.saveButton.click();
            String text=userProfilePage.profileHeader.findElement(By.cssSelector("h1")).getText();
            assertEquals(text,"Obruch Vladimir");
    }
}
