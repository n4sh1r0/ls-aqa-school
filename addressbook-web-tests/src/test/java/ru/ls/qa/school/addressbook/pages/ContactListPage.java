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

    public ContactListPage deleteFirstContact() {
        app.getContactHelper()
                .clickSelectFirstContact();
        app.getContactHelper()
                .clickDeleteContact();
        acceptAlert();
        return this;
    }

    public ContactListPage initDeletionAllContacts() {
        selectAllContacts();
        app.getContactHelper()
                .clickDeleteContact();
        acceptAlert();
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

    public ContactPage clickUpdateFirstContact() {
        app.getContactHelper()
                .clickUpdateContact();
        return page.contactPage;
    }

    //TODO реализовать clickUpdateFirstContact()

}