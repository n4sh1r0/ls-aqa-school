package ru.ls.qa.school.addressbook.pages.group;

import ru.ls.qa.school.addressbook.model.GroupData;
import ru.ls.qa.school.addressbook.pages.BasePage;

import static ru.ls.qa.school.addressbook.tests.TestBase.app;
import static ru.ls.qa.school.addressbook.tests.TestBase.openPage;


public class GroupPage extends BasePage {

    public GroupPage refillForm(GroupData group) {
        app.group().fillNewForm(group);
        return this;
    }

    public GroupActionResultPage submitUpdate() {
        app.group().submitUpdateGroup();
        return openPage.getGroupActionResultPage();
    }
}