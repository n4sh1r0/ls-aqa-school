package ru.ls.qa.school.addressbook.tests.group;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.tests.TestBase;

public class GroupDeleteTest extends TestBase {

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
    public void testDeleteGroup() {
        pages.getMainPage()
                .goToGroupPage()
                .selectFirstGroup()
                .initRemoveGroup()
                .returnToGroupListPage();
    }
}