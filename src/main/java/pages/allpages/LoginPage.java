package pages.allpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.BasePage;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //*********Web Elements*********
    By usernameBy = By.id("email");
    By passwordBy = By.id("password");
    By loginButtonBy = By.id("loginButton");
    By errorMessageUsernameBy = By.xpath("//*[@id=\"loginForm\"]/div[1]/div/div");
    By errorMessagePasswordBy = By.xpath("//*[@id=\"loginForm\"]/div[2]/div/div ");

    //*********Page Methods*********

    public LoginPage loginToN11 (String username, String password){
        //Enter Username(Email)
        writeText(usernameBy,username);
        //Enter Password
        writeText(passwordBy, password);
        //Click Login Button
        click(loginButtonBy);
        return this;
    }

    //Verify Username Condition
    public LoginPage verifyLoginUserName (String expectedText) {
        Assert.assertEquals(errorMessageUsernameBy, expectedText);
        return this;
    }

    //Verify Password Condition
    public LoginPage verifyLoginPassword (String expectedText) {
       Assert.assertEquals(errorMessagePasswordBy, expectedText);
        return this;
    }
}
