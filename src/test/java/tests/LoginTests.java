package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;
import screens.SplashScreen;

public class LoginTests extends AppiumConfig {
    @AfterMethod
    public void postConditions(){
        new ContactListScreen(driver).logout();
    }

    @Test
    public void loginSuccess(){
//        boolean result=new SplashScreen(driver)
//                .checkCurrentVersion("Version 1.0.0")
                boolean result=new AuthenticationScreen(driver)
                        .fillEmail("vitber36@gmail.com")
                .fillPassword("1978Vit@lik")
                .submitLogin()
                .isActivityTitleDisplayed("Contact list");
        Assert.assertTrue(result);
    }
    @Test
    public void loginSuccessModel(){
//        boolean result=new SplashScreen(driver)
//                .checkCurrentVersion("Version 1.0.0")
        boolean result=new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder().email("vitber36@gmail.com").password("1978Vit@lik").build())
                .submitLogin()
                .isActivityTitleDisplayed("Contact list");
        Assert.assertTrue(result);
    }
    @Test
    public void loginSuccessModel2(){
        Assert.assertTrue(new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder()
                        .email("vitber36@gmail.com")
                        .password("1978Vit@lik")
                        .build())
                .submitLogin()
                .isActivityTitleDisplayed("Contact list"));
    }
    @Test
    public void loginWrongEmail(){
        new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder()
                        .email("vitber36gmail.com")
                        .password("1978Vit@lik")
                        .build())
                .submitLoginNegative()
                .isErrorMessageHasText("Login or Password incorrect");

    }

    @Test
    public void loginWrongPassword(){
        new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder()
                        .email("vitber36@gmail.com")
                        .password("1978")
                        .build())
                .submitLoginNegative()
                .isErrorMessageHasText("Login or Password incorrect");

    }
}
