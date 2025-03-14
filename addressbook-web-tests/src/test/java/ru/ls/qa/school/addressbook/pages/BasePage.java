package ru.ls.qa.school.addressbook.pages;

import ru.ls.qa.school.addressbook.pages.contact.ContactListPage;
import ru.ls.qa.school.addressbook.pages.group.GroupListPage;

import static ru.ls.qa.school.addressbook.tests.TestBase.app;
import static ru.ls.qa.school.addressbook.tests.TestBase.openPage;

public abstract class BasePage {

    public ContactListPage returnToMainPage() {
        app.goTo()
                .mainPage();
        return openPage.mainPage();
    }

    public ContactListPage goToContactListPage() {
        app.goTo()
                .mainPage();
        return openPage.contacs();
    }

    public GroupListPage goToGroupPage() {
        app.goTo()
                .groupPage();
        return openPage.getGroupListPage();
    }
}