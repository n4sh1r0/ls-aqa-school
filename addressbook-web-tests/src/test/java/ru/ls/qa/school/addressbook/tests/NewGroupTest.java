package ru.ls.qa.school.addressbook.tests;


import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.model.GroupData;

public class NewGroupTest extends TestBase {

    @Test
    public void testNewGroup() {
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("contacts", "phone", "number"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().checkMessageAfterGroupCreation();
        app.getNavigationHelper().returnToMainPage();
        app.logout();
    }

}
