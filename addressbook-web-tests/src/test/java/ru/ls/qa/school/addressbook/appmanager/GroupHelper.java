package ru.ls.qa.school.addressbook.appmanager;

import ru.ls.qa.school.addressbook.model.GroupData;

import static com.codeborne.selenide.Selectors.*;

public class GroupHelper extends BaseHelper {
    public void checkMessageAfterGroupCreation() {
        checkMessage(byXpath("//*[@id=\"content\"]/div"), "A new group has been entered into the address book.\n return to the group page");
    }

    public void submitGroupCreation() {
        click(byName("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(byName("group_name"), groupData.getName());
        type(byName("group_header"), groupData.getHeader());
        type(byName("group_footer"), groupData.getFooter());
    }

    public void clickGroupCreation() {
        click(byName("new"));
    }

    public void clickSelectGroup() {
        click(byXpath("/html/body/div/div[4]/form/span[1]/input"));
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



}
