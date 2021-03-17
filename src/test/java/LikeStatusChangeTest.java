import forumPost.ForumPostPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import signIn.HomePage;
import signIn.Util;

import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class LikeStatusChangeTest extends BasicTestSetup {
    @Test
    public void clickOnLikeSuccessful(){
        HomePage homePage = PageFactory.initElements(webDriver, HomePage.class);
        Util.login(homePage,webDriver,homePage.correctEmail,homePage.correctPassword);
        Util.openPage(webDriver,ForumPostPage.page);
        ForumPostPage forumPostPage = PageFactory.initElements(webDriver,ForumPostPage.class);
        String likes = forumPostPage.getCurrentStateOfLikes().getText();
        forumPostPage.changeLikeStatus();
        String changedCountOfLikes = forumPostPage.getCurrentStateOfLikes().getText();
        assertNotEquals(likes,changedCountOfLikes);
    }
}
