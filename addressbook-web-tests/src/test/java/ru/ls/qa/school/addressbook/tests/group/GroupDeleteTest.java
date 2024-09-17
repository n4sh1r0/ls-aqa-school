package ru.ls.qa.school.addressbook.tests.group;


import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.tests.TestBase;

public class GroupDeleteTest extends TestBase {

    @Test
    public void testDeleteGroup() {
        pages.getMainPage()
                .goToGroupPage()
                .goToGroupCreationPage()
                .fillForm(utils.generate().group())
                .submitCreation()
                .returnToGroupListPage()
                .selectFirstGroup()
                .initRemoveGroup()
                .returnToGroupListPage();
    }
}