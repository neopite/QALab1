package userProfile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserCredentialsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public UserCredentialsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(id = "txtdisplay_name")
    public WebElement username;

    @FindBy(id = "topError")
    public WebElement incorrectUsername;

    @FindBy(id = "btnSubmit")
    public WebElement saveButton;

    public void setNewUsername(String username){
        this.username.sendKeys(username);
    }
}
