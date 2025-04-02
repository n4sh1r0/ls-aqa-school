package ru.ls.qa.school.addressbook.pages.group;

import ru.ls.qa.school.addressbook.pages.BasePage;

import static ru.ls.qa.school.addressbook.tests.TestBase.ui;
import static ru.ls.qa.school.addressbook.tests.TestBase.openPage;


public class GroupListPage extends BasePage {


    public GroupCreationPage goToGroupCreationPage() {
        ui.group()
          .initCreation();
        return openPage.getGroupCreationPage();
    }

    public GroupListPage selectFirstGroup() {
        ui.group()
          .selectFirstInList();
        return this;
    }

    public GroupPage clickUpdateGroup() {
        ui.group()
          .edit();
        return openPage.getGroupPage();
    }

    public GroupActionResultPage initRemoveGroup() {
        ui.group()
          .remove();
        return openPage.getGroupActionResultPage();
    }

    public GroupListPage getGroupCount() {
        ui.group()
          .getListCount();
        return this;
    }
}