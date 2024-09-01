package ru.ls.qa.school.addressbook.tests;


import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.model.GroupData;

public class GroupCreationTest extends TestBase {

    @Test
    public void testGroupCreation() {
        page.getContactListPage()
                .goToGroupPage()
                .goToGroupCreationPage()
                .initGroupCreation()
                .goToGroupPage()
                .findGroup();
    }

}
