package ru.ls.qa.school.addressbook.pages;

import ru.ls.qa.school.addressbook.pages.contact.ContactListPage;
import ru.ls.qa.school.addressbook.pages.group.GroupListPage;

import static ru.ls.qa.school.addressbook.tests.TestBase.app;
import static ru.ls.qa.school.addressbook.tests.TestBase.pages;

public abstract class BasePage {

    public ContactListPage returnToMainPage() {
        app.getNavigationHelper()
                .returnToMainPage();
        return pages.getMainPage();
    }

    public ContactListPage goToContactListPage() {
        app.getNavigationHelper()
                .returnToMainPage();
        return pages.getContactListPage();
    }

    public GroupListPage goToGroupPage() {
        app.getNavigationHelper()
                .goToGroupPage();
        return pages.getGroupListPage();
    }
}