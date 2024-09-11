package ru.ls.qa.school.addressbook.pages;

import ru.ls.qa.school.addressbook.model.ContactData;
import ru.ls.qa.school.addressbook.model.GroupData;

import static ru.ls.qa.school.addressbook.appmanager.RandomHelper.generateRandomString;
import static ru.ls.qa.school.addressbook.appmanager.RandomHelper.getRandomLength;
import static ru.ls.qa.school.addressbook.tests.TestBase.*;


public class GroupCreationPage extends BasePage {

    public static String groupName = generateRandomString(getRandomLength());


    public GroupCreationPage fillGroupForm() {
        return fillGroupForm(utils.generate().group());
    }

    public GroupCreationPage fillGroupForm(GroupData group) {
        app.getGroupHelper().fillGroupForm(group);
        return this;
    }


    public GroupListPage initGroupCreation() {
        app.getGroupHelper()
                .fillGroupForm(new GroupData(groupName, "group_header", "group_footer"));
        app.getGroupHelper()
                .submitGroupCreation();
        return page.getGroupListPage();
    }

    public GroupListPage returnToGroupListPage() {
        app.getGroupHelper().
                returnToGroupListPage();
        return page.getGroupListPage();
    }

    public GroupCreationPage submitCreationGroup() {
        app.getGroupHelper().
                submitGroupCreation();
        return this;
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
