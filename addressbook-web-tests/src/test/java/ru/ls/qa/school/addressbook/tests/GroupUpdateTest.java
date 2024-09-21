package ru.ls.qa.school.addressbook.tests;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.model.GroupData;

import java.util.Random;

import static com.codeborne.selenide.Selenide.$;

public class GroupUpdateTest extends TestBase {

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
    public void testUpdateGroup() {
        page.getGroupListPage()
                .selectGroup()
                .clickUpdateGroup()
                .initGroupUpdate()
                .goToGroupPage();
    }

}