package ru.ls.qa.school.addressbook.appmanager;

import com.codeborne.selenide.ElementsCollection;
import ru.ls.qa.school.addressbook.model.GroupData;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupHelper extends BaseHelper {
    public int countOfGroups;
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
        checkMessage(byCssSelector("/html/body/div/div[4]/form/span[1]/text()"), "updatedContacts");
    }

    public void clickDeleteGroup() {
        click(byCssSelector("#content > form > input[type=submit]:nth-child(2)"));
    }

    public void checkMessageAfterGroupDeletion() {
        checkMessage(byCssSelector("#content > div"), "Group has been removed.\n return to the group page");
    }

    public void checkCountOfGroups() {
        ElementsCollection groups = $$(".group");
        int countOfGroups = groups.size();
    }

    public void checkCountOfGroupsAfterDeletion() {
        ElementsCollection groupsAfterDeletion = $$(".group");
        int countOfGroupsAfterDeletion = groupsAfterDeletion.size();
        if (countOfGroups == 0) {
            countOfGroups = 1;
        }
        assertEquals(countOfGroups - 1, countOfGroupsAfterDeletion);
    }


}
