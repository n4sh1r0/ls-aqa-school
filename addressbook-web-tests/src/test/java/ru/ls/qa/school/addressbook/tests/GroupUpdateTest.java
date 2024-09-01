package ru.ls.qa.school.addressbook.tests;


import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.model.GroupData;

public class GroupUpdateTest extends TestBase {

    @Test
    public void testUpdateGroup() {
        page.getGroupListPage()
                .goToGroupPage()
                .goToGroupCreationPage()
                .initGroupCreation()
                .goToGroupPage()
                .selectGroup()
                .clickUpdateGroup()
                .initGroupUpdate()
                .goToGroupPage()
                .findGroup();
    }

}