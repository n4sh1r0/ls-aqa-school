package ru.ls.qa.school.addressbook.appmanager;

import ru.ls.qa.school.addressbook.model.GroupData;
import ru.ls.qa.school.addressbook.pages.GroupCreationPage;
import ru.ls.qa.school.addressbook.pages.GroupListPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class GroupHelper extends BaseHelper {
    public void checkMessageAfterGroupCreation() {
        checkMessage(byCssSelector("#content > div"), "A new group has been entered into the address book.\n return to the group page");
    }

    public void submitGroupCreation() {
        click(byName("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(byName("group_name"), groupData.getName());
        type(byName("group_header"), groupData.getHeader());
        type(byName("group_footer"), groupData.getFooter());
    }

    public void initGroupCreation() {
        click(byName("new"));
    }

    public void clickSelectGroup() {
        click(byCssSelector(String.format("[title='Select (%s)']", GroupCreationPage.getGroupName())));
    }

    public void clickEditGroup() {
        click(byXpath("/html/body/div/div[4]/form/input[3]"));
    }

    public void submitUpdateGroup() {
        click(byCssSelector("#content > form > input[type=submit]:nth-child(12)"));
    }

    public void checkUpdatedDataGroup() {
        checkMessage(byCssSelector("#content > form > span:nth-child(5)"), "updatedContacts");
    }
    public void clickDeleteGroup() {
        click(byCssSelector("#content > form > input[type=submit]:nth-child(2)"));
    }

    public void checkMessageAfterGroupDeletion() {
        checkMessage(byCssSelector("#content > div"), "Group has been removed.\n return to the group page");
    }

    public void findGroupInList() {
        $("body").find("*").shouldHave(text(GroupCreationPage.getGroupName()));
    }

    public void checkDeletedGroup() {
        $("body").find("*").shouldNotHave(text(GroupCreationPage.getGroupName()));
    }



}
