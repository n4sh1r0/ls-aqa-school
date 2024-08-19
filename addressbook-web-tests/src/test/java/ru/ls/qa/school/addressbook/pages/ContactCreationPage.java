package ru.ls.qa.school.addressbook.pages;

import ru.ls.qa.school.addressbook.model.ContactData;

import static ru.ls.qa.school.addressbook.tests.TestBase.app;
import static ru.ls.qa.school.addressbook.tests.TestBase.page;

public class ContactCreationPage extends BasePage {

    public ContactCreationPage createNewContact(ContactData contactData)  {
        app.getContactHelper().fillNewContactForm(contactData);
        return this;
    }


    public ContactListPage initContactCreation() {
        app.getContactHelper().submitCreation();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return page.getContactListPage();
    }
}
