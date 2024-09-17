package ru.ls.qa.school.addressbook.tests.group;


import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.model.GroupData;
import ru.ls.qa.school.addressbook.tests.TestBase;

public class GroupCreationTest extends TestBase {


    @Test
    public void testGroupCreation() {
        GroupData group = utils.generate().group();
        pages.getMainPage()
                .goToGroupPage()
                .goToGroupCreationPage()
                .fillForm(utils.generate().group())
                .submitCreation()
                .returnToGroupListPage();
    }
}