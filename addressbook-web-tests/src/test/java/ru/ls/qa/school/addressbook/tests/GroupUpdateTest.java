package ru.ls.qa.school.addressbook.tests;


import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.model.GroupData;

public class GroupUpdateTest extends TestBase {

    @Test
    public void testUpdateGroup() {
        pageManager.getGroupPage()
                .goToGroupPage()
                .clickGroupCreation()
                .fillGroupForm(new GroupData("contacts", "phone", "number"))
                .submitGroupCreation()
                .checkMessageAfterGroupCreation()
                .goToGroupPage()
                .clickSelectGroup()
                .clickEditGroup()
                .fillGroupForm(new GroupData("updatedContacts", "updatedPhone", "updatedNumber"))
                .submitUpdateGroup()
                .goToGroupPage()
                .checkUpdatedDataGroup() // спросить
                .returnToMainPage()
                .logout();
    }

}