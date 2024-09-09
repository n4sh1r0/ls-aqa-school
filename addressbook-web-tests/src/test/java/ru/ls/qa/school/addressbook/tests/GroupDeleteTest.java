package ru.ls.qa.school.addressbook.tests;


import org.junit.jupiter.api.Test;

import java.util.Random;

public class GroupDeleteTest extends TestBase {

    @Test
    public void testDeleteGroup() {
        page.getGroupListPage()
                .goToGroupPage()
                .goToGroupCreationPage()
                .initGroupCreation()
                .goToGroupPage()
                .selectGroup()
                .initDeleteGroup()
                .goToGroupPage()
                .checkDeletedGroup();
    }
}
