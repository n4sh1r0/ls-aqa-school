package ru.ls.qa.school.addressbook.pages.contact;

import ru.ls.qa.school.addressbook.pages.BasePage;

import static ru.ls.qa.school.addressbook.tests.TestBase.app;
import static ru.ls.qa.school.addressbook.tests.TestBase.pages;


public class ContactListPage extends BasePage {


    public ContactCreationPage goToNewContactPage() {
        app.goTo().newContactPage();
        return pages.getContactCreationPage();
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
        return pages.getContactPage();
    }

    public ContactListPage getListOfFirstContact() {
        app.getContactHelper()
                .getByRow(0);
        return this;
    }

    public ContactListPage clickSortByLastName() {
        app.getContactHelper()
                .clickSortByLastName();
        return this;
    }

}