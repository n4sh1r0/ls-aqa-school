package ru.ls.qa.school.addressbook.pages;

import static ru.ls.qa.school.addressbook.tests.TestBase.*;


public class ContactListPage extends BasePage {


    public ContactCreationPage goToNewContactPage() {
        app.getNavigationHelper().goToNewContactPage();
        return page.getContactCreationPage();
    }

    public ContactListPage selectAllContacts() {
        app.getContactHelper()
                .clickSelectAllContacts();
        return this;
    }

    public ContactListPage initDeletionFirstContact() {
        app.getContactHelper()
                .clickSelectFirstContact();
        app.getContactHelper()
                .clickDeleteContact();
        acceptAlert();
        return checkNumberOfContacts();
    }

    public ContactListPage initDeletionAllContacts() {
        selectAllContacts();
        app.getContactHelper()
                .clickDeleteContact();
        acceptAlert();
        return checkNumberOfContacts();
    }
    public ContactCreationPage clickUpdateFirstContact() {
        app.getContactHelper()
                .clickUpdateFirstContact();
        return page.getContactCreationPage();
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

    private ContactListPage acceptAlert() {
        app.getContactHelper()
                .acceptAlert();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

}