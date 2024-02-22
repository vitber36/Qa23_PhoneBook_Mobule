package tests;

import config.AppiumConfig;
import models.Auth;
import models.Contact;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;

import java.util.Random;

public class AddNewContactsTests extends AppiumConfig {
    @BeforeClass
    public void preCondition(){
       new AuthenticationScreen(driver)
               .fillLoginRegistrationForm(Auth.builder()
                       .email("vitber06@mail.ru")
                       .password("1978Vit@lik")
                       .build())
               .submitLogin()
               .isActivityTitleDisplayed("Contact list");
    }

    @Test
    public void createNewContactSuccess(){
        int i=new Random().nextInt(1000)+1000;
        Contact contact= Contact.builder()
                .name("Simon")
                .lastName("Wow"+i)
                .email("wow"+i+"@gmail.com")
                .phone("12345678"+i)
                .address("wow")
                .description("friend")
                .build();
        new ContactListScreen(driver)
                .openContactForm()
                .fillContactForm(contact)
                .submitContactForm()
                .isContactAddedByName(contact.getName(),contact.getLastName());

    }
    public void createNewContactSuccessReq(){
        int i=new Random().nextInt(1000)+1000;
        Contact contact= Contact.builder()
                .name("Simon")
                .lastName("Wow"+i)
                .email("wow"+i+"@gmail.com")
                .phone("12345678"+i)
                .address("wow")
                .build();
        new ContactListScreen(driver)
                .openContactForm()
                .fillContactForm(contact)
                .submitContactForm()
                .isContactAddedByName(contact.getName(),contact.getLastName());
    }

    @Test
    public void createContactWithEmptyName(){
        Contact contact= Contact.builder()
                .lastName("Wow")
                .email("wow@gmail.com")
                .phone("1234567890")
                .address("wow")
                .description("Empty name")
                .build();
        new ContactListScreen(driver)
                .openContactForm()
                .fillContactForm(contact)
                .submitContactFormNegative()
                .isErrorContainsText("{name=must not be blank}");
    }

    @Test
    public void createContactWithEmptyLastName(){
        Contact contact= Contact.builder()
                .name("wow")
                .email("wow@gmail.com")
                .phone("1234567890")
                .address("wow")
                .description("Empty name")
                .build();
        new ContactListScreen(driver)
                .openContactForm()
                .fillContactForm(contact)
                .submitContactFormNegative()
                .isErrorContainsText("{Last name=must not be blank}");
    }
    @AfterClass
    public void postCondition(){
        new ContactListScreen(driver).logout();
    }
}
