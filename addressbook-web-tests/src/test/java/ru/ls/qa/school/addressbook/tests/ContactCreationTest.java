package ru.ls.qa.school.addressbook.tests;

import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.model.ContactData;

import static ru.ls.qa.school.addressbook.appmanager.RandomHelper.*;


public class ContactCreationTest extends TestBase {


    String randomFirstName = generateRandomString(getRandomLength());
    String randomMiddleName = generateRandomString(getRandomLength());
    String randomNickName = generateRandomString(getRandomLength());
    String randomLastName = generateRandomString(getRandomLength());
    String randomEmail = generateRandomEmail();


    @Test
    public void testNewContact() {
        page.getContactListPage()
                .goToNewContactPage()
                .createNewContact(new ContactData(randomFirstName,
                        randomMiddleName,
                        randomLastName,
                        randomNickName,
                        "Moscow",
                        randomEmail))
                .initContactCreation();
    }
}

