package ru.ls.qa.school.addressbook.tests;


import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.model.GroupData;

public class NewGroupTest extends TestBase {

    @Test
    public void testNewGroup() {
        app.goToGroup();
        app.initGroupCreation();
        app.fillGroupForm(new GroupData("contacts", "phone", "number"));
        app.submitGroupCreation();
        app.checkMessageAfterGroupCreation();
        app.returnToMainPage();
        app.logout();
    }

}
