package ru.ls.qa.school.addressbook;


import org.junit.jupiter.api.Test;

public class NewGroupTest extends TestBase {

    @Test
    public void testNewGroup() {
        goToGroup();
        initGroupCreation();
        fillGroupForm(new GroupData("contacts", "phone", "number"));
        submitGroupCreation();
        checkMessageAfterGroupCreation();
        returnToMainPage();
        logout();
    }

}
