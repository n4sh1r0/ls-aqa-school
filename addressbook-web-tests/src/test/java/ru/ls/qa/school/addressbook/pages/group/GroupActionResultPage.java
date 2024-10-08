package ru.ls.qa.school.addressbook.pages.group;

import ru.ls.qa.school.addressbook.pages.BasePage;

import static ru.ls.qa.school.addressbook.tests.TestBase.app;
import static ru.ls.qa.school.addressbook.tests.TestBase.pages;


public class GroupActionResultPage extends BasePage {
    public GroupListPage returnToGroupListPage() {
        app.getGroupHelper().returnToGroupListPage();
        return pages.getGroupListPage();
    }
}