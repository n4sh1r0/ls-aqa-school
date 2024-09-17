package ru.ls.qa.school.addressbook.pages.group;

import ru.ls.qa.school.addressbook.pages.BasePage;

import static ru.ls.qa.school.addressbook.tests.TestBase.app;
import static ru.ls.qa.school.addressbook.tests.TestBase.pages;


public class GroupListPage extends BasePage {


    public GroupCreationPage goToGroupCreationPage() {
        app.getGroupHelper()
                .initGroupCreation();
        return pages.getGroupCreationPage();
    }

    public GroupListPage selectFirstGroup() {
        app.getGroupHelper()
                .clickFirstSelectGroup();
        return this;
    }

    public GroupPage clickUpdateGroup() {
        app.getGroupHelper()
                .clickEditGroup();
        return pages.getGroupPage();
    }

    public GroupActionResultPage initRemoveGroup() {
        app.getGroupHelper()
                .clickRemoveGroup();
        return pages.getGroupActionResultPage();
    }
}