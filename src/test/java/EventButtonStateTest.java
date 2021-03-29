import forumPost.ForumPostPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import signIn.HomePage;
import signIn.Util;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class EventButtonStateTest extends BasicTestSetup {

    @Test
    public void changeIWillGoButtonStatus() {
        HomePage homePage = PageFactory.initElements(webDriver, HomePage.class);
        Util.login(homePage, webDriver, System.getenv("login"), System.getenv("password"));
        Util.openPage(webDriver, ForumPostPage.page);
        ForumPostPage forumPostPage = PageFactory.initElements(webDriver, ForumPostPage.class);
        forumPostPage.changeAllPeopleStatus();
        String newStatusOfButton = forumPostPage.getCurrentStatusOfIWillGoButton().getText();
        assertEquals(newStatusOfButton, "I’m going");
    }
}
