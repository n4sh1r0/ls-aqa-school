package ru.ls.qa.school.addressbook.tests;

import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.model.ContactData;
import static ru.ls.qa.school.addressbook.appmanager.RandomHelper.*;

import java.util.Random;

public class ContactUpdateTest extends TestBase {


    String randomFirstName = generateRandomString(getRandomLength());
    String randomMiddleName = generateRandomString(getRandomLength());
    String randomNickName = generateRandomString(getRandomLength());
    String randomLastName = generateRandomString(getRandomLength());
    String randomEmail = generateRandomEmail();

    @Test
    public void testContactUpdate() {
        pageManager.getContactPage()
                .goToNewContactPage()
                .fillContactForm(new ContactData(randomFirstName,
                        randomMiddleName,
                        randomLastName,
                        randomNickName,
                        "Moscow",
                        randomEmail))
                .submitCreationNewContact()
                .returnToMainPage()
                .clickUpdateContact()
                .fillContactForm(new ContactData(generateRandomString(getRandomLength()),
                        generateRandomString(getRandomLength()),
                        generateRandomString(getRandomLength()),
                        generateRandomString(getRandomLength()),
                        generateRandomString(getRandomLength()),
                        randomEmail))
                .submitUpdateContact()
                .returnToMainPage()
                .checkUpdatedContactData(randomEmail, randomLastName, randomFirstName)
                .logout();
    }
}
