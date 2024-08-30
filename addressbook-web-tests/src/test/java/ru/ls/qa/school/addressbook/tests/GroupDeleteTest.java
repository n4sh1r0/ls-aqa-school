package ru.ls.qa.school.addressbook.tests;


import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.model.GroupData;

public class GroupDeleteTest extends TestBase {

    @Test
    public void testDeleteGroup() {
        page.getGroupPage()
                .goToGroupPage()
                .clickGroupCreation()
                .fillGroupForm(new GroupData("contacts", "phone", "number"))
                .submitGroupCreation()
                .checkMessageAfterGroupCreation()
                .goToGroupPage()
                .clickSelectGroup()
                .clickDeleteGroup()
                .checkMessageAfterGroupDeletion();

    }
}