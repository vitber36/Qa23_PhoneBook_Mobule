package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import models.Auth;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AuthenticationScreen extends BaseScreen{
    public AuthenticationScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(id = "com.sheygam.contactapp:id/inputEmail" )
    AndroidElement emailEditText;
    @FindBy(id = "com.sheygam.contactapp:id/inputPassword")
    AndroidElement passwordEditText;
    @FindBy(id = "com.sheygam.contactapp:id/loginBtn")
    AndroidElement loginButton;

    public AuthenticationScreen fillEmail(String email){
        //pause(4000)
        should(emailEditText,10);
        type(emailEditText,email);
        return this;
    }

    public AuthenticationScreen fillPassword(String password){
        type(passwordEditText,password);
        return this;
    }

    public ContactListScreen submitLogin(){
        loginButton.click();
        return new ContactListScreen(driver);
    }

    public AuthenticationScreen fillLoginRegistrationForm(Auth auth) {
        should(emailEditText,10);
        type(emailEditText,auth.getEmail());
        type(passwordEditText,auth.getPassword());
        return this;
    }

    public AuthenticationScreen submitLoginNegative() {
        loginButton.click();
    return this;
    }

    public AuthenticationScreen isErrorMessageHasText(String text) {
        Alert alert=new WebDriverWait(driver,10)
                .until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(text));
        alert.accept();
        return this;
    }
}
