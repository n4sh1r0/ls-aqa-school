package ru.ls.qa.school.addressbook.appmanager;

import ru.ls.qa.school.addressbook.model.GroupData;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byXpath;

public class GroupHelper extends BaseHelper {
    public void checkMessageAfterGroupCreation() {
        checkMessage(byXpath("//*[@id=\"content\"]/div"), "A new group has been entered into the address book.\n return to the group page");
    }



    public void fillGroupForm(GroupData groupData) {
        type(byName("group_name"), groupData.getName());
        type(byName("group_header"), groupData.getHeader());
        type(byName("group_footer"), groupData.getFooter());
        click(byName("submit"));
    }

    public void initGroupCreation() {
        click(byName("new"));
    }
}
