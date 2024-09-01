package ru.ls.qa.school.addressbook.pages;

import ru.ls.qa.school.addressbook.model.GroupData;

import static ru.ls.qa.school.addressbook.appmanager.RandomHelper.generateRandomString;
import static ru.ls.qa.school.addressbook.appmanager.RandomHelper.getRandomLength;
import static ru.ls.qa.school.addressbook.tests.TestBase.app;
import static ru.ls.qa.school.addressbook.tests.TestBase.page;


public class GroupCreationPage extends BasePage {

    public static String groupName = generateRandomString(getRandomLength());


    public GroupCreationPage fillGroupForm(GroupData groupData) {
        app.getGroupHelper()
           .fillGroupForm(groupData);
        return this;
    }

    public GroupListPage initGroupCreation() {
        app.getGroupHelper()
                .fillGroupForm(new GroupData(groupName, "group_header", "group_footer"));
        app.getGroupHelper()
                .submitGroupCreation();
        return page.getGroupListPage();
    }

    public GroupListPage initGroupUpdate() {
        app.getGroupHelper()
                .fillGroupForm(new GroupData(groupName, "group_header", "group_footer"));
        app.getGroupHelper()
                .submitUpdateGroup();
        return page.getGroupListPage();
    }

    public static String getGroupName() {
        return groupName;
    }


}
