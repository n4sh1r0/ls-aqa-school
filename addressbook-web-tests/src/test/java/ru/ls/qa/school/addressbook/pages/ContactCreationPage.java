package ru.ls.qa.school.addressbook.pages;

import ru.ls.qa.school.addressbook.model.ContactData;
import ru.ls.qa.school.addressbook.tests.ContactCreationTest;

import static ru.ls.qa.school.addressbook.tests.TestBase.app;
import static ru.ls.qa.school.addressbook.tests.TestBase.page;
import static ru.ls.qa.school.addressbook.appmanager.RandomHelper.*;

public class ContactCreationPage extends BasePage {

    public ContactCreationPage initContactCreation() {

        app.getContactHelper().fillNewContactForm(new ContactData(generateRandomString(getRandomLength()),
                generateRandomString(getRandomLength()),
                generateRandomString(getRandomLength()),
                generateRandomString(getRandomLength()),
                "Moscow",
                generateRandomEmail()));
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
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
