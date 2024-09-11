package ru.ls.qa.school.addressbook.tests;


import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.model.GroupData;

import java.util.Random;

public class GroupCreationTest extends TestBase {


    @Test
    public void testGroupCreation() {
        page.getContactListPage()
                .goToGroupPage()
                .goToGroupCreationPage()
                .fillGroupForm()
                .submitCreationGroup()
                .returnToGroupListPage();
    }

}
