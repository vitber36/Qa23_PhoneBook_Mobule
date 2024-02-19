package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;

public class LoginSecondTests extends AppiumConfig {
    @Test
    public void loginSuccess(){
        new AuthenticationScreen(driver)
                .fillEmail("vitber06@mail.ru")
                .fillPassword("1978Vit@lik")
                .submitLogin()
                .isAccountOpened()
                .logout();
    }
    @Test
    public void loginSuccessModel(){
        new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder()
                        .email("vitber06@mail.ru")
                        .password("1978Vit@lik")
                        .build())
                .submitLogin()
                .isAccountOpened()
                .logout();
    }
}
