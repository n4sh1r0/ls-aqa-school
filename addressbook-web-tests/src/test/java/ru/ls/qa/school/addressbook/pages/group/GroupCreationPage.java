package ru.ls.qa.school.addressbook.pages.group;

import ru.ls.qa.school.addressbook.model.GroupData;
import ru.ls.qa.school.addressbook.pages.BasePage;

import static ru.ls.qa.school.addressbook.tests.TestBase.app;
import static ru.ls.qa.school.addressbook.tests.TestBase.openPage;


public class GroupCreationPage extends BasePage {

    public GroupCreationPage fillForm(GroupData group) {
        app.group().fillNewForm(group);
        return this;
    }

    public GroupListPage completeCreation() {
        app.group().
                submitGroupCreation();
        app.group().returnToGroupListPage();
        return openPage.getGroupListPage();
    }
}