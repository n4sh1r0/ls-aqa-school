package ru.ls.qa.school.addressbook.tests;

import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.model.ContactData;
import java.util.Random;
import static ru.ls.qa.school.addressbook.appmanager.RandomHelper.*;

public class ContactDeleteTest extends TestBase {


    String randomFirstName = generateRandomString(getRandomLength());
    String randomMiddleName = generateRandomString(getRandomLength());
    String randomNickName = generateRandomString(getRandomLength());
    String randomLastName = generateRandomString(getRandomLength());
    String randomEmail = generateRandomEmail();

    @Test
    public void testContactDelete() {
        page.getContactPage()
                .clickSelectAllContacts()
                .clickDeleteContact()
                .returnToMainPage()
                .checkNumberOfContacts()
                .goToNewContactPage()
                .fillContactForm(new ContactData(randomFirstName,
                        randomMiddleName,
                        randomLastName,
                        randomNickName,
                        "Moscow",
                        randomEmail))
                .submitCreationNewContact()
                .returnToMainPage()
                .clickSelectContact()
                .clickDeleteContact()
                .acceptAllert()
                .returnToMainPage()
                .checkNumberOfContacts()
                .logout();

    }
}
