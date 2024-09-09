package ru.ls.qa.school.addressbook.pages;

import ru.ls.qa.school.addressbook.model.ContactData;

import static ru.ls.qa.school.addressbook.appmanager.RandomHelper.*;
import static ru.ls.qa.school.addressbook.tests.TestBase.*;

public class ContactCreationPage extends BasePage {

    public ContactCreationPage fillContactForm() {
        return fillContactForm(utils.generate().contact());
    }

    public ContactCreationPage fillContactForm(ContactData contact) {
        app.getContactHelper().fillNewContactForm(contact);
        return this;
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

    public ContactListPage submitCreation() {
        app.getContactHelper().submitCreationNewContact();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return page.getContactListPage();
    }
}
