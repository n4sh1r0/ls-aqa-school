package ru.ls.qa.school.addressbook.tests.group;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.model.ContactData;
import ru.ls.qa.school.addressbook.model.GroupData;
import ru.ls.qa.school.addressbook.tests.TestBase;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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

        int groupId = app.getGroupHelper().getFirstGroupId();
        String groupNameBeforeUpdate = app.getGroupHelper().getGroupById(groupId);
        GroupData expectedGroup = utils.generate().group();

        pages.getGroupListPage()
                .selectFirstGroup()
                .clickUpdateGroup()
                .refillForm(expectedGroup)
                .submitUpdate()
                .returnToGroupListPage();

        String groupNameAfterUpdate = app.getGroupHelper().getGroupById(groupId);

        assertThat(groupNameAfterUpdate)
                .as("Проверка обновления группы")
                .isNotEqualTo(groupNameBeforeUpdate);

        assertThat(groupNameAfterUpdate)
                .as("Проверка ожидаемой группы")
                .isEqualTo(expectedGroup.getName());
    }
}