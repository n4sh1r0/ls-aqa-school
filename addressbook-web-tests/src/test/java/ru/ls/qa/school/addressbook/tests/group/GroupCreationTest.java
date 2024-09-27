package ru.ls.qa.school.addressbook.tests.group;


import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.pages.group.GroupListPage;
import ru.ls.qa.school.addressbook.tests.TestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupCreationTest extends TestBase {


    @Test
    public void testGroupCreation() {
        GroupListPage groupPage = pages.getMainPage()
                .goToGroupPage();
        int beforeCreation = app.getGroupHelper().getGroupCount();
        groupPage.goToGroupCreationPage()
                .fillForm(utils.generate().group())
                .submitCreation()
                .returnToGroupListPage();
        assertEquals(app.getGroupHelper().getGroupCount(), beforeCreation + 1);
    }
}