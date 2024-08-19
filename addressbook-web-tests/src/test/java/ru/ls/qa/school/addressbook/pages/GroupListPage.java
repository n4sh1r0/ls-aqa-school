package ru.ls.qa.school.addressbook.pages;

import static ru.ls.qa.school.addressbook.tests.TestBase.app;
import static ru.ls.qa.school.addressbook.tests.TestBase.page;

public class GroupListPage extends BasePage {

    public GroupCreationPage initGroupCreation() {
        app.getGroupHelper()
           .initGroupCreation();
        return page.getGroupCreationPage();
    }

}