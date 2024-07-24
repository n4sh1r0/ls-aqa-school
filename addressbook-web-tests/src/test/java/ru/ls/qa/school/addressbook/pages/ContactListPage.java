package ru.ls.qa.school.addressbook.pages;

import ru.ls.qa.school.addressbook.appmanager.ApplicationManager;


public class ContactListPage extends BasePage {


    public ContactListPage(ApplicationManager app) {
        super(app);
    }

    public ContactListPage goToNewContactPage() {
        app.getNavigationHelper().goToNewContactPage();
        return this;
    }

    public ContactListPage returnToMainPage() {
        app.getNavigationHelper().returnToMainPage();
        return this;
    }
}