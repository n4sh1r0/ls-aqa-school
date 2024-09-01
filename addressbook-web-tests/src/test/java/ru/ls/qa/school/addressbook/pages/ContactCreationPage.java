package ru.ls.qa.school.addressbook.pages;

import ru.ls.qa.school.addressbook.model.ContactData;
import ru.ls.qa.school.addressbook.tests.ContactCreationTest;

import static ru.ls.qa.school.addressbook.tests.TestBase.app;
import static ru.ls.qa.school.addressbook.tests.TestBase.page;
import static ru.ls.qa.school.addressbook.appmanager.RandomHelper.*;

public class ContactCreationPage extends BasePage {

    public ContactListPage initContactCreation () {
return initContactCreation(new ContactData(generateRandomString(getRandomLength()),
        generateRandomString(getRandomLength()),
        generateRandomString(getRandomLength()),
        generateRandomString(getRandomLength()),
        "Moscow",
        generateRandomEmail()));
    }

    public ContactListPage initContactCreation(ContactData contact) {

        app.getContactHelper().fillNewContactForm(contact);
        return submitCreationNewContact();
    }

    public ContactListPage initContactUpdate() {
        app.getContactHelper().fillNewContactForm(new ContactData(generateRandomString(getRandomLength()),
                generateRandomString(getRandomLength()),
                generateRandomString(getRandomLength()),
                generateRandomString(getRandomLength()),
                "Moscow",
                generateRandomEmail()));
        app.getContactHelper().submitUpdateContact();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return page.getContactListPage();
    }

    public ContactListPage submitCreationNewContact() {
        app.getContactHelper().submitCreationNewContact();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return page.getContactListPage();
    }
}
