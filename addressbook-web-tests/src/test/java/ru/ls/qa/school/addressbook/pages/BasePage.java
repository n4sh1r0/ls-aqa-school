package ru.ls.qa.school.addressbook.pages;

import ru.ls.qa.school.addressbook.pages.contact.ContactListPage;
import ru.ls.qa.school.addressbook.pages.group.GroupListPage;

import static ru.ls.qa.school.addressbook.tests.TestBase.app;
import static ru.ls.qa.school.addressbook.tests.TestBase.pages;

public abstract class BasePage {

    public ContactListPage returnToMainPage() {
        app.goTo()
                .returnToMainPage();
        return pages.getMainPage();
    }

    public ContactListPage goToContactListPage() {
        app.goTo()
                .returnToMainPage();
        return pages.getContactListPage();
    }

    public GroupListPage goToGroupPage() {
        app.goTo()
                .goToGroupPage();
        return pages.getGroupListPage();
    }
}