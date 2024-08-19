package ru.ls.qa.school.addressbook.pages;

import ru.ls.qa.school.addressbook.model.GroupData;

import static ru.ls.qa.school.addressbook.tests.TestBase.app;
import static ru.ls.qa.school.addressbook.tests.TestBase.page;


public class GroupCreationPage extends BasePage {


    public GroupCreationPage fillGroupForm(GroupData groupData) {
        app.getGroupHelper()
           .fillGroupForm(groupData);
        return this;
    }

    public GroupListPage initGroupCreation() {
        //TODO метод на запуск создания
        app.getGroupHelper()
           .checkMessageAfterGroupCreation();
        app.getGroupHelper()
           .returnToMainPage();
        return page.getGroupListPage();
    }

}
