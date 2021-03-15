package signIn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;

public class Util {
    public static String getPopupWindow(WebDriver webDriver){
        Iterator<String> iterator =  webDriver.getWindowHandles().iterator();
        String subWindowHandler = null;
        while (iterator.hasNext()){
            subWindowHandler = iterator.next();
        }
        return subWindowHandler;
    }
    public static void switchToWindow(WebDriver driver , String window){
        driver.switchTo().window(window); // switch to popup window
    }
    public static void login(HomePage homePage,WebDriver webDriver,String email,String password){
        homePage.open();
        homePage.getStarted();

        //  Логинимся
        SignInForm signInForm = PageFactory.initElements(webDriver, SignInForm.class);
        signInForm.setValueToEmail(email);
        signInForm.setValueToPassword(password);
        signInForm.confirmForm();
        Util.switchToWindow(webDriver,homePage.parentWindow);
    }

    public static void openPage(WebDriver webDriver,String path){
        webDriver.get(path);
    }

}
