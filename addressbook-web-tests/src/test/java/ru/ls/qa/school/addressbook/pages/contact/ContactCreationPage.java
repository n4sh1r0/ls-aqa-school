package ru.ls.qa.school.addressbook.pages.contact;

import ru.ls.qa.school.addressbook.model.ContactData;
import ru.ls.qa.school.addressbook.pages.BasePage;

import static ru.ls.qa.school.addressbook.utils.primitive.RandomUtils.*;
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
        return pages.getContactListPage();
    }

    public ContactListPage submitCreation() {
        app.getContactHelper().submitCreationNewContact();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return pages.getContactListPage();
    }
}