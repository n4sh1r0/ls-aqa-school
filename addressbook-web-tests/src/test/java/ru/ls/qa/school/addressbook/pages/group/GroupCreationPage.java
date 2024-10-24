package ru.ls.qa.school.addressbook.pages.group;

import ru.ls.qa.school.addressbook.model.GroupData;
import ru.ls.qa.school.addressbook.pages.BasePage;
import ru.ls.qa.school.addressbook.utils.GenerateUtils;

import static ru.ls.qa.school.addressbook.tests.TestBase.app;
import static ru.ls.qa.school.addressbook.tests.TestBase.pages;


public class GroupCreationPage extends BasePage {

    public GroupCreationPage fillForm(GroupData group) {
        app.getGroupHelper().fillGroupForm(new GenerateUtils().group());
        return this;
    }

    public GroupActionResultPage submitCreation() {
        app.getGroupHelper().
                submitGroupCreation();
        return pages.getGroupActionResultPage();
    }
}