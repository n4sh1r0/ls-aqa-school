package ru.ls.qa.school.addressbook.pages.contact;

import ru.ls.qa.school.addressbook.pages.BasePage;

import static ru.ls.qa.school.addressbook.tests.TestBase.app;
import static ru.ls.qa.school.addressbook.tests.TestBase.openPage;


public class ContactListPage extends BasePage {


    public ContactCreationPage goToNewContactPage() {
        app.goTo().newContactPage();
        return openPage.contact();
    }

    public ContactListPage selectAllContacts() {
        app.contact()
                .clickSelectAllContacts();
        return this;
    }

    //TODO удалить и переиспользовать вместо него dropContactById() или dropContactByRow()
    public ContactListPage dropContactById(int contactId) {
        app.contact()
                .clickSelectContactById(contactId);
        app.contact()
                .clickDeleteContact();
        acceptAlert();
        return this;
    }

    public ContactListPage initDeletionAllContacts() {
        selectAllContacts();
        app.contact()
                .clickDeleteContact();
        acceptAlert();
        return this;
    }

    private ContactListPage acceptAlert() {
        app.contact()
                .acceptAlert();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    //TODO заменить на getContactById()
    public ContactListPage getContactID() {
        app.contact()
                .getFirstContactId();
        return this;
    }

    public ContactPage clickUpdateContactById(int contactId) {
        app.contact()
                .clickUpdateById(contactId);
        return openPage.getContactPage();
    }


    public ContactListPage clickSortByLastName() {
        app.contact()
                .clickSortByLastName();
        return this;
    }

}