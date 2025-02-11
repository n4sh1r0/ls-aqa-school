package ru.ls.qa.school.addressbook.tests.group;


import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.tests.TestBase;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class GroupCreationTest extends TestBase {


    @Test
    public void testGroupCreation() {
        var page = pages.getMainPage()
                .goToGroupPage();
        int beforeCount = app.getGroupHelper().getGroupCount();
        page.goToGroupCreationPage()
                .fillForm(utils.generate().group())
                .submitCreation()
                .returnToGroupListPage();

        int afterCount = app.getGroupHelper().getGroupCount();

        assertThat(afterCount)
                .isEqualTo(beforeCount + 1);
    }
}