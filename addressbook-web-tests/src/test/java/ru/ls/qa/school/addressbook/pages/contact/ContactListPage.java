package ru.ls.qa.school.addressbook.pages.contact;

import ru.ls.qa.school.addressbook.pages.BasePage;

import static ru.ls.qa.school.addressbook.tests.TestBase.ui;
import static ru.ls.qa.school.addressbook.tests.TestBase.openPage;


public class ContactListPage extends BasePage {


    public ContactCreationPage goToNewContactPage() {
        ui.goTo().newContactPage();
        return openPage.contact();
    }

    public ContactListPage selectAllContacts() {
        ui.contact()
          .selectAllList();
        return this;
    }

    //TODO удалить и переиспользовать вместо него dropContactById() или dropContactByRow()
    public ContactListPage dropContactById(int contactId) {
        ui.contact()
          .selectInList(contactId);
        ui.contact()
          .delete();
        acceptAlert();
        return this;
    }

    public ContactListPage initDeletionAllContacts() {
        selectAllContacts();
        ui.contact()
          .delete();
        acceptAlert();
        return this;
    }

    private ContactListPage acceptAlert() {
        ui.contact()
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
        ui.contact()
          .getFirstContactId();
        return this;
    }

    public ContactPage updateContact(int contactId) {
        ui.contact()
          .clickUpdate(contactId);
        return openPage.getContactPage();
    }


    public ContactListPage clickSortByLastName() {
        ui.contact()
          .sortByLastName();
        return this;
    }

}