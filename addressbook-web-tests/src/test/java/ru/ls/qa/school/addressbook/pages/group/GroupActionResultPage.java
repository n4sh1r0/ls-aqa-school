package ru.ls.qa.school.addressbook.pages.group;

import ru.ls.qa.school.addressbook.pages.BasePage;

import static ru.ls.qa.school.addressbook.tests.TestBase.ui;
import static ru.ls.qa.school.addressbook.tests.TestBase.openPage;


public class GroupActionResultPage extends BasePage {
    //TODO Убрать метод и объединить returnToGroupListPage в submitCreation
    public GroupListPage returnToGroupListPage() {
        ui.group().returnToListPage();
        return openPage.getGroupListPage();
    }
}