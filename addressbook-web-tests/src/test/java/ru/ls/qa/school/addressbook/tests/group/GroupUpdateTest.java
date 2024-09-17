package ru.ls.qa.school.addressbook.tests.group;


import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.tests.TestBase;

public class GroupUpdateTest extends TestBase {

    @Test
    public void testUpdateGroup() {
        pages.getMainPage()
                .goToGroupPage()
                .goToGroupCreationPage()
                .fillForm(utils.generate().group())
                .submitCreation()
                .returnToGroupListPage()
                .selectFirstGroup()
                .clickUpdateGroup()
                .refillForm(utils.generate().group())
                .submitUpdate()
                .returnToGroupListPage();
    }
}