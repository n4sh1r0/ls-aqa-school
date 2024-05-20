package ru.ls.qa.school.addressbook.appmanager;

import ru.ls.qa.school.addressbook.model.GroupData;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;

public class GroupHelper {
    public void checkMessageAfterGroupCreation() {
        $(".msgbox").shouldHave(text("A new group has been entered into the address book.\n return to the group page"));
    }

    public void submitGroupCreation() {
        $(byName("submit")).click();
    }

    public  void fillGroupForm(GroupData groupData) {
        $(byName("group_name")).click();
        $(byName("group_name")).val(groupData.getName());
        $(byName("group_header")).click();
        $(byName("group_header")).val(groupData.getHeader());
        $(byName("group_footer")).click();
        $(byName("group_footer")).val(groupData.getFooter());
    }

    public void initGroupCreation() {
        $(byName("new")).click();
    }
}
