package ru.ls.qa.school.addressbook.tests.group;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.model.GroupData;
import ru.ls.qa.school.addressbook.model.Groups;
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
        if (ui.group().checkListIsEmpty()) {
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

        Groups groupsBefore = ui.group().getList();
        GroupData deletedGroup = groupsBefore.iterator().next();
        beforeDeletion = ui.group().getListCount();

        groupPage.deleteGroup(deletedGroup)
                .returnToGroupListPage();

        Groups groupsAfter = ui.group().getList();

        assertThat(ui.group().getListCount())
                .as("Проверка общего количества групп")
                .isEqualTo(beforeDeletion - 1);

        groupsBefore.remove(deletedGroup);
        assertThat(groupsAfter)
                .as("Проверка списка групп после удаления")
                .containsExactlyInAnyOrderElementsOf(groupsBefore);
    }
}