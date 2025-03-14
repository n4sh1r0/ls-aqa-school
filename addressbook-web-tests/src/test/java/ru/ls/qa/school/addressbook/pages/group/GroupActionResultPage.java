package ru.ls.qa.school.addressbook.pages.group;

import ru.ls.qa.school.addressbook.pages.BasePage;

import static ru.ls.qa.school.addressbook.tests.TestBase.app;
import static ru.ls.qa.school.addressbook.tests.TestBase.openPage;


public class GroupActionResultPage extends BasePage {
    //TODO Убрать метод и объединить returnToGroupListPage в submitCreation
    public GroupListPage returnToGroupListPage() {
        app.group().returnToGroupListPage();
        return openPage.getGroupListPage();
    }
}