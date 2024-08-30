package ru.ls.qa.school.addressbook.pages;

import static ru.ls.qa.school.addressbook.tests.TestBase.*;


public class ContactListPage extends BasePage {


    public ContactCreationPage goToNewContactPage() {
        app.getNavigationHelper().goToNewContactPage();
        return page.getContactCreationPage();
    }

    public ContactListPage selectAllContacst() {
        app.getContactHelper()
                .clickSelectAllContacts();
        return this;
    }

    public ContactListPage initDeletionContact() {
        app.getContactHelper()
                .clickDeleteContact()
                .acceptAlert();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public ContactListPage checkNumberOfContacts() {
        app.getContactHelper()
                .checkNumberOfContacts();
        return this;
    }

    public ContactListPage selectFirstContact() {
        app.getContactHelper()
                .clickSelectFirstContact();
        return this;
    }
}