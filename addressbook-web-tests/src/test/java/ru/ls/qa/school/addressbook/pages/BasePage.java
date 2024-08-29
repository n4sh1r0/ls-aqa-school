package ru.ls.qa.school.addressbook.pages;

import static ru.ls.qa.school.addressbook.tests.TestBase.app;
import static ru.ls.qa.school.addressbook.tests.TestBase.page;

public class BasePage {

    public ContactListPage returnToMainPage() {
        app.getNavigationHelper()
                .returnToMainPage();
        return page.getContactListPage();
    }
    public GroupListPage goToGroupPage() {
        app.getNavigationHelper()
                .goToGroupPage();
        return page.getGroupListPage();
    }



}