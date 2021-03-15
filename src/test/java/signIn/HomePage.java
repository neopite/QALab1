package signIn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }
    public String correctEmail = "v@gmail.com";
    public String correctPassword = "v";
    
    @FindBy(id = "login-link")
    private WebElement signInLink;

    @FindBy(id = "btnLinkedIn")
    private WebElement linkedInButton;

    public String siteLink = "https://dou.ua/";

    public String parentWindow;
    public String signInWindow;

    public void open(){
        driver.get(siteLink);
    }

    public void getStarted(){
        open();
        signInLink.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        linkedInButton.click();
        parentWindow = driver.getWindowHandle();
        signInWindow = Util.getPopupWindow(driver);
        Util.switchToWindow(driver,signInWindow);

    }
    public void getVisibleOf(WebElement webElement){
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }
    public WebElement getAuthStatus(){
        return driver.findElement(By.id("login-link"));
    }
}
