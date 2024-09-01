package ru.ls.qa.school.addressbook.pages;

import static ru.ls.qa.school.addressbook.tests.TestBase.app;
import static ru.ls.qa.school.addressbook.tests.TestBase.page;


public class GroupListPage extends BasePage {


    public GroupCreationPage goToGroupCreationPage() {
        app.getGroupHelper()
                .initGroupCreation();
        return page.getGroupCreationPage();
    }

    public GroupListPage findGroup() {
        app.getGroupHelper()
                .findGroupInList();
        return this;
    }

    public GroupListPage selectGroup() {
        app.getGroupHelper()
                .clickSelectGroup();
        return this;
    }

    public GroupCreationPage clickUpdateGroup() {
        app.getGroupHelper()
                .clickEditGroup();
        return page.getGroupCreationPage();
    }

    public GroupListPage initDeleteGroup() {
        app.getGroupHelper()
                .clickDeleteGroup();
        app.getNavigationHelper()
                .goToGroupPage();
        return this;
    }

    public GroupListPage checkDeletedGroup() {
        app.getGroupHelper()
                .checkDeletedGroup();
        return this;
    }

}