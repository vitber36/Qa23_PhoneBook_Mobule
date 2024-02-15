package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

public class SplashScreen extends BaseScreen{

    public SplashScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/version_text']")
    AndroidElement versionTextView;

    @FindBy(id = "com.sheygam.contactapp:id/title_text")
    AndroidElement titleTextNew;

    public String getCurrentVersion(){
        return versionTextView.getText();
    }
public AuthenticationScreen checkCurrentVersion(String version){
        isShouldHave(versionTextView,version,10);
        return  new AuthenticationScreen(driver);
}
}
