import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserProfilePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public UserProfilePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(xpath = "//a[text()=\"Logout\"]")
    WebElement logoutButton;

    public void submitLogout(){
        logoutButton.click();
    }
}
