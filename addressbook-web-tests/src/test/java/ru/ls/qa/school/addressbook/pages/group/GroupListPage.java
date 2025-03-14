package ru.ls.qa.school.addressbook.pages.group;

import ru.ls.qa.school.addressbook.pages.BasePage;

import static ru.ls.qa.school.addressbook.tests.TestBase.app;
import static ru.ls.qa.school.addressbook.tests.TestBase.openPage;


public class GroupListPage extends BasePage {


    public GroupCreationPage goToGroupCreationPage() {
        app.group()
                .initGroupCreation();
        return openPage.getGroupCreationPage();
    }

    public GroupListPage selectFirstGroup() {
        app.group()
                .clickFirstSelectGroup();
        return this;
    }

    public GroupPage clickUpdateGroup() {
        app.group()
                .clickEditGroup();
        return openPage.getGroupPage();
    }

    public GroupActionResultPage initRemoveGroup() {
        app.group()
                .clickRemoveGroup();
        return openPage.getGroupActionResultPage();
    }

    public GroupListPage getGroupCount() {
        app.group()
                .getListCount();
        return this;
    }
}