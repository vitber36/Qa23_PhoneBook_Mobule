package tests;

import org.testng.Assert;
import screens.SplashScreen;
import config.AppiumConfig;
import org.testng.annotations.Test;

public class LaunchTest extends AppiumConfig {

    @Test
    public void launch() {
        String version = new SplashScreen(driver).getCurrentVersion();//Version 1.0.0
        Assert.assertTrue(version.contains("1.0.0"));
    }

}
