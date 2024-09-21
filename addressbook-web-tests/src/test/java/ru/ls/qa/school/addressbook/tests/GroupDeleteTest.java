package ru.ls.qa.school.addressbook.tests;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static com.codeborne.selenide.Selenide.$;

public class GroupDeleteTest extends TestBase {

    @BeforeEach
    public void checkForGroup() {
        page.getGroupListPage()
                .goToGroupPage();
        if (!$(".group").exists()) {
            page.getGroupListPage()
                    .goToGroupCreationPage()
                    .fillGroupForm()
                    .submitCreationGroup()
                    .returnToGroupListPage();
        }
    }

    @Test
    public void testDeleteGroup() {
        page.getGroupListPage()
                .selectGroup()
                .initDeleteGroup()
                .goToGroupPage();
    }
}
