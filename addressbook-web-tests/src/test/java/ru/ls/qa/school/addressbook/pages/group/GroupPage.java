package ru.ls.qa.school.addressbook.pages.group;

import ru.ls.qa.school.addressbook.model.GroupData;
import ru.ls.qa.school.addressbook.pages.BasePage;
import ru.ls.qa.school.addressbook.utils.FactoryUtils;

import static ru.ls.qa.school.addressbook.tests.TestBase.app;
import static ru.ls.qa.school.addressbook.tests.TestBase.pages;


public class GroupPage extends BasePage {

    public GroupPage refillForm(GroupData group) {
        app.getGroupHelper().fillNewForm(new FactoryUtils().group());
        return this;
    }

    public GroupActionResultPage submitUpdate() {
        app.getGroupHelper().submitUpdateGroup();
        return pages.getGroupActionResultPage();
    }
}