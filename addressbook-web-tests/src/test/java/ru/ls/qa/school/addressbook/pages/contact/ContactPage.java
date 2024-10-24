package ru.ls.qa.school.addressbook.pages.contact;

import ru.ls.qa.school.addressbook.model.ContactData;
import ru.ls.qa.school.addressbook.pages.BasePage;

import static ru.ls.qa.school.addressbook.tests.TestBase.app;
import static ru.ls.qa.school.addressbook.tests.TestBase.pages;

public class ContactPage extends BasePage {

    public ContactPage fillForm(ContactData contact) {
        app.getContactHelper().fillNewContactForm(contact);
        return this;
    }

    public ContactListPage submitUpdate() {
        app.getContactHelper().submitUpdateContact();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return pages.getContactListPage();
    }
}