package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class ContactListScreen extends BaseScreen{
    public ContactListScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/action_bar']/android.widget.TextView")
    AndroidElement activityTextView;

    public boolean isActivityTitleDisplayed(String text){
    //return activityTextView.getText().contains("Contact list");
    return isShouldHave(activityTextView,text,8);
    }
    @FindBy(xpath = "//*[@content-desc='More options']")
    AndroidElement menuOptions;

    @FindBy(xpath = "//*[@text = 'Logout']")
    AndroidElement logoutBtn;

    @FindBy(xpath = "//*[@content-desc='add']")
    AndroidElement plusBnt;

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/rowName']")
    List<AndroidElement>contactNameList;

    public AuthenticationScreen logout(){
        menuOptions.click();
        logoutBtn.click();
        return new AuthenticationScreen(driver);
    }
    public ContactListScreen isAccountOpened(){
        Assert.assertTrue(isActivityTitleDisplayed("Contact list"));
        return this;
    }
public AddNewContactScreen openContactForm(){
        should(activityTextView,5);
        plusBnt.click();
        return new AddNewContactScreen(driver);
}

    public ContactListScreen isContactAddedByName(String name, String lastName) {
        //List<AndroidElement>list=driver.findElements(By.xpath(""));
        boolean isPresent=false;

        isShouldHave(activityTextView,"Contact list",5);
        for(AndroidElement el:contactNameList){
            if(el.getText().equals(name+" "+lastName)){
                isPresent=true;
            }
        }
        Assert.assertTrue(isPresent);
        return this;
    }
}
