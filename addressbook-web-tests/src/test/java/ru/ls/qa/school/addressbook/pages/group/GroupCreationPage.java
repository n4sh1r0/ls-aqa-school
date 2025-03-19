package ru.ls.qa.school.addressbook.pages.group;

import ru.ls.qa.school.addressbook.model.GroupData;
import ru.ls.qa.school.addressbook.pages.BasePage;

import static ru.ls.qa.school.addressbook.tests.TestBase.ui;
import static ru.ls.qa.school.addressbook.tests.TestBase.openPage;


public class GroupCreationPage extends BasePage {

    public GroupCreationPage fillForm(GroupData group) {
        ui.group().fillForm(group);
        return this;
    }

    public GroupListPage completeCreation() {
        ui.group().
          submitCreation();
        ui.group().returnToListPage();
        return openPage.getGroupListPage();
    }
}