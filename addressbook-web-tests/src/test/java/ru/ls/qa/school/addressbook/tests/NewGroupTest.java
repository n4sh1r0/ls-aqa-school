package ru.ls.qa.school.addressbook.tests;


import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.model.GroupData;

public class NewGroupTest extends TestBase {

    @Test
    public void testNewGroup() {
        page.getGroupPage()
                .goToGroupPage()
                .initGroupCreation()
                .fillGroupForm(new GroupData("contacts", "phone", "number"))
                .submitGroupCreation()
                .checkMessageAfterGroupCreation()
                .returnToMainPage()
                .logout();
    }

}
