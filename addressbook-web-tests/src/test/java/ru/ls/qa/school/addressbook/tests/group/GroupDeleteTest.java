package ru.ls.qa.school.addressbook.tests.group;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.pages.group.GroupListPage;
import ru.ls.qa.school.addressbook.tests.TestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupDeleteTest extends TestBase {
    private int beforeDeletion;

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
            beforeDeletion = 1;
        }
    }

    @Test
    public void testDeleteGroup() {
        GroupListPage groupPage = pages.getMainPage()
                .goToGroupPage();
        beforeDeletion = app.getGroupHelper().getGroupCount();
        groupPage.selectFirstGroup()
                .initRemoveGroup()
                .returnToGroupListPage();
        assertEquals(app.getGroupHelper().getGroupCount(), beforeDeletion - 1);
    }
}