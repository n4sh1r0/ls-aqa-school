package ru.ls.qa.school.addressbook.tests.group;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.model.ContactData;
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
        var page = pages.getMainPage()
                .goToGroupPage();
        if (app.getGroupHelper().listIsEmpty()) {
            page
                    .goToGroupCreationPage()
                    .fillForm(utils.generate().group())
                    .submitCreation()
                    .returnToGroupListPage();
            beforeDeletion = 1;
        }
    }

    @Test
    public void testDeleteGroup() {
        //Переходим на страницу с группами
        GroupListPage groupPage = pages.getMainPage()
                .goToGroupPage();

        //Присваиваем переменные
        int groupId = app.getGroupHelper().getFirstGroupId();
        Set<GroupData> groupsBefore = app.getGroupHelper().getListOfGroups();
        beforeDeletion = app.getGroupHelper().getGroupCount();

        //Удаляем группу
        groupPage.selectFirstGroup()
                .initRemoveGroup()
                .returnToGroupListPage();

        //Забираем сет групп после удаления
        Set<GroupData> groupsAfter = app.getGroupHelper().getListOfGroups();

        assertThat(app.getGroupHelper().getGroupCount())
                .as("Проверка общего количества групп")
                .isEqualTo(beforeDeletion - 1);

        groupsBefore.removeIf(group -> group.getId() == groupId);
        assertThat(groupsAfter)
                .as("Проверка списка групп после удаления")
                .containsExactlyInAnyOrderElementsOf(groupsBefore);
    }
}