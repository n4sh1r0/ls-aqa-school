package ru.ls.qa.school.addressbook.tests.group;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.model.GroupData;
import ru.ls.qa.school.addressbook.model.Groups;
import ru.ls.qa.school.addressbook.tests.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class GroupUpdateTest extends TestBase {

    @BeforeEach
    public void checkForGroup() {
        var page = openPage.mainPage()
                           .goToGroupPage();
        if (ui.group().checkListIsEmpty()) {
            page
                    .goToGroupCreationPage()
                    .fillForm(utils.generate().group())
                    .completeCreation();
        }
    }

    @Test
    public void testUpdateGroup() {
        openPage.mainPage()
                .goToGroupPage();

        int groupId = ui.group().getFirstGroupId();
        String groupNameBeforeUpdate = ui.group().get(groupId);
        Groups groupsBefore = ui.group().getList();
        GroupData expectedGroup = utils.generate().group();
        GroupData modifiedGroup = groupsBefore.iterator().next();

        openPage.getGroupListPage()
                .clickUpdateGroup(modifiedGroup)
                .refillForm(expectedGroup)
                .submitUpdate()
                .returnToGroupListPage();

        String groupNameAfterUpdate = ui.group().get(groupId);
        Groups groupsAfter = ui.group().getList();

        assertThat(groupNameAfterUpdate)
                .as("Проверка обновления группы")
                .isNotEqualTo(groupNameBeforeUpdate);

        assertThat(groupNameAfterUpdate)
                .as("Проверка ожидаемой группы")
                .isEqualTo(expectedGroup.getName());

        assertThat(groupsBefore.without(modifiedGroup).withAdded(expectedGroup))
                .as("Проверка списка групп после обновления")
                .withFailMessage(String.format("Ожидаемые группы %s, полученные группы %s", groupsBefore.without(modifiedGroup).withAdded(expectedGroup), groupsAfter))
                .usingRecursiveComparison()
                .isEqualTo(groupsAfter);
    }
}