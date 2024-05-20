package ru.ls.qa.school.addressbook;


import org.junit.jupiter.api.Test;

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
