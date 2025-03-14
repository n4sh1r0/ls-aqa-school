package ru.ls.qa.school.addressbook.tests.group;


import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.tests.TestBase;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class GroupCreationTest extends TestBase {


    @Test
    public void testGroupCreation() {
        var page = openPage.mainPage()
                           .goToGroupPage();
        int beforeCount = app.group().getListCount();
        page.goToGroupCreationPage()
                .fillForm(utils.generate().group())
                .completeCreation();

        int afterCount = app.group().getListCount();

        assertThat(afterCount)
                .isEqualTo(beforeCount + 1);
    }
}