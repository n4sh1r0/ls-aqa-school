package ru.ls.qa.school.addressbook.pages;

import ru.ls.qa.school.addressbook.appmanager.ApplicationManager;
import ru.ls.qa.school.addressbook.tests.TestBase;

import static ru.ls.qa.school.addressbook.tests.TestBase.*;


public class ContactListPage extends BasePage {


    public ContactCreationPage goToNewContactPage() {
        app.getNavigationHelper().goToNewContactPage();
        return page.getContactCreationPage();
    }
}