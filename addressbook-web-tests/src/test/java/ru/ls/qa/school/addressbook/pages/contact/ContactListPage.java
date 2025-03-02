package ru.ls.qa.school.addressbook.pages.contact;

import ru.ls.qa.school.addressbook.model.ContactData;
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

    //TODO удалить и переиспользовать вместо него dropContactById() или dropContactByRow()
    public ContactListPage dropContactById(int contactId) {
        app.getContactHelper()
                .clickSelectContactById(contactId);
        app.getContactHelper()
                .clickDeleteContact();
        acceptAlert();
        return this;
    }

    //TODO Реализовать
    public ContactListPage dropContact(int contactId) {
        return this;
    }

    public ContactListPage initDeletionAllContacts() {
        selectAllContacts();
        app.getContactHelper()
                .clickDeleteContact();
        acceptAlert();
        return this;
    }

//    public ContactListPage selectFirstContact() {
//        app.getContactHelper()
//                .clickSelectFirstContact();
//        return this;
//    }

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

    //TODO заменить на getContactById()
    public ContactListPage getContactID() {
        app.getContactHelper()
                .getFirstContactId();
        return this;
    }

    public ContactPage clickUpdateContactById(int contactId) {
        app.getContactHelper()
                .clickUpdateContactById(contactId);
        return pages.getContactPage();
    }

    public ContactListPage getListOfFirstContact() {
        app.getContactHelper()
                .getByRow(0);
        return this;
    }

    //public ContactListPage clickDeleteContactById(int contactId) {
       // app.getContactHelper();
   // }

    public ContactListPage clickSortByLastName() {
        app.getContactHelper()
                .clickSortByLastName();
        return this;
    }

    //TODO реализовать
    public ContactData getContact(int contactId) {
        app.getContactHelper()
                .getFirstContactId();
        return null;
    }

}