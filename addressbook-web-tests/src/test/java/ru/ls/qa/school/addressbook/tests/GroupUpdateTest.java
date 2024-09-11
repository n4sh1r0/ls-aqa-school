package ru.ls.qa.school.addressbook.tests;


import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.model.GroupData;

import java.util.Random;

public class GroupUpdateTest extends TestBase {

    @Test
    public void testUpdateGroup() {
        page.getGroupListPage()
                .goToGroupPage()
                .goToGroupCreationPage()
                .fillGroupForm()
                .submitCreationGroup()
                .returnToGroupListPage()
                .selectGroup()
                .clickUpdateGroup()
                .initGroupUpdate()
                .goToGroupPage();
    }

}