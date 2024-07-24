package ru.ls.qa.school.addressbook.tests;


import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.model.GroupData;

public class NewGroupTest extends TestBase {

    @Test
    public void testNewGroup() {
        page.getGroupListPage()
                .goToGroupPage()
                .initGroupCreation();
        page.getGroupCreationPage()
                .fillGroupForm(new GroupData("contacts", "phone", "number"))
                .checkMessageAfterGroupCreation()
                .returnToMainPage();
    }

}
