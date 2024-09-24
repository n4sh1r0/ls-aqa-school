package ru.ls.qa.school.addressbook.tests.group;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.tests.TestBase;

public class GroupUpdateTest extends TestBase {

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
                .goToGroupPage()
                .clickUpdateGroup()
                .refillForm(utils.generate().group())
                .submitUpdate()
                .returnToGroupListPage();
    }
}