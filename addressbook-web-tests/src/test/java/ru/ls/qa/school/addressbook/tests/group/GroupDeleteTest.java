package ru.ls.qa.school.addressbook.tests.group;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.model.GroupData;
import ru.ls.qa.school.addressbook.pages.group.GroupListPage;
import ru.ls.qa.school.addressbook.tests.TestBase;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupDeleteTest extends TestBase {
    private int beforeDeletion;

    @BeforeEach
    public void checkForGroup() {
        var page = openPage.mainPage()
                           .goToGroupPage();
        if (app.group().listIsEmpty()) {
            page
                    .goToGroupCreationPage()
                    .fillForm(utils.generate().group())
                    .completeCreation();
            beforeDeletion = 1;
        }
    }

    @Test
    public void testDeleteGroup() {
        GroupListPage groupPage = openPage.mainPage()
                                          .goToGroupPage();

        int groupId = app.group().getFirstGroupId();
        Set<GroupData> groupsBefore = app.group().getListOfGroups();
        beforeDeletion = app.group().getListCount();

        groupPage.selectFirstGroup()
                .initRemoveGroup()
                .returnToGroupListPage();

        Set<GroupData> groupsAfter = app.group().getListOfGroups();

        assertThat(app.group().getListCount())
                .as("Проверка общего количества групп")
                .isEqualTo(beforeDeletion - 1);

        groupsBefore.removeIf(group -> group.getId() == groupId);
        assertThat(groupsAfter)
                .as("Проверка списка групп после удаления")
                .containsExactlyInAnyOrderElementsOf(groupsBefore);
    }
}