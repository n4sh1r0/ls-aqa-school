package ru.ls.qa.school.addressbook.pages;

import ru.ls.qa.school.addressbook.pages.contact.ContactListPage;
import ru.ls.qa.school.addressbook.pages.group.GroupListPage;

import static ru.ls.qa.school.addressbook.tests.TestBase.ui;
import static ru.ls.qa.school.addressbook.tests.TestBase.openPage;

public abstract class BasePage {

    public ContactListPage returnToMainPage() {
        ui.goTo()
          .mainPage();
        return openPage.mainPage();
    }

    public ContactListPage goToContactListPage() {
        ui.goTo()
          .mainPage();
        return openPage.contacs();
    }

    public GroupListPage goToGroupPage() {
        ui.goTo()
          .groupPage();
        return openPage.getGroupListPage();
    }
}