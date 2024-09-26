package ru.ls.qa.school.addressbook.tests.group;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.tests.TestBase;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class GroupUpdateTest extends TestBase {
    List<String> groups = new ArrayList<>();

    @BeforeEach
    public void checkForGroup() {
        var page = pages.getMainPage()
                .goToGroupPage();
        if (app.getGroupHelper().listIsEmpty()) {
            page
                    .goToGroupCreationPage()
                    .fillForm(utils.generate().group())
                    .submitCreation()
                    .returnToGroupListPage();
        }
    }

    @Test
    public void testUpdateGroup() {
        pages.getMainPage()
                .goToGroupPage();
        groups = app.getGroupHelper().getRow();
                pages.getGroupListPage()
                        .selectFirstGroup()
                        .clickUpdateGroup()
                .refillForm(utils.generate().group())
                .submitUpdate()
                .returnToGroupListPage();
                assertNotEquals(groups, app.getGroupHelper().getRow());
    }
}