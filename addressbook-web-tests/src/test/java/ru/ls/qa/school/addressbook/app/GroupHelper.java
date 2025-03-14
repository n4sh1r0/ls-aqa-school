package ru.ls.qa.school.addressbook.app;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ru.ls.qa.school.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.Set;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GroupHelper extends BaseHelper {
    public void checkMessageAfterGroupCreation() {
        checkMessage(byCssSelector("#content > div"), "A new group has been entered into the address book.\n return to the group page");
    }

    @Step("Подтвердить создание группы")
    public void submitGroupCreation() {
        click(byName("submit"));
    }

    @Step("Заполнить форму группы")
    public void fillNewForm(GroupData groupData) {
        type(byName("group_name"), groupData.getName());
        type(byName("group_header"), groupData.getHeader());
        type(byName("group_footer"), groupData.getFooter());
    }

    @Step("Кликнуть создать группу")
    public void initGroupCreation() {
        click(byName("new"));
    }

    @Step("Выбрать первую группу из списка")
    public void clickFirstSelectGroup() {
        click(byCssSelector("span.group > input[type='checkbox']"));
    }

    @Step("Кликнуть изменить группу")
    public void clickEditGroup() {
        click(byName("edit"));
    }

    @Step("Подтвердить обновление группы")
    public void submitUpdateGroup() {
        click(byName("update"));
    }

    @Step("Кликнуть удалить группу")
    public void clickRemoveGroup() {
        click(byName("delete"));
    }

    @Step("Проверить сообщение после удаления группы")
    public void checkMessageAfterGroupDeletion() {
        checkMessage(byCssSelector("#content > div"), "Group has been removed.\n return to the group page");
    }

    @Step("Вернуться на страницу со списком групп")
    public void returnToGroupListPage() {
        click(byLinkText("group page"));
    }

    @Step("Список групп пуст")
    public boolean listIsEmpty() {
        return !$(".group").exists();
    }

    @Step("Получение id первой группы")
    public int getFirstGroupId() {
        SelenideElement firstGroupCheckbox = $(".group input[type='checkbox']");
        return Integer.parseInt(firstGroupCheckbox.getAttribute("value"));
    }

    @Step("Получить название группы по id")
    public String getGroupById(int groupId) {
        SelenideElement checkbox = $("input[type='checkbox'][name='selected[]'][value='" + groupId + "']")
                .shouldBe(exist);

        return checkbox.parent().text();
    }

    @Step("Получить список всех групп")
    public Set<GroupData> getListOfGroups() {
        Set<GroupData> groups = new HashSet<>();
        ElementsCollection groupSpans = $$("span.group");

        for (SelenideElement groupElement : groupSpans) {
            int id = Integer.parseInt(groupElement.find("input").getAttribute("value"));
            String name = groupElement.getText().trim();

            GroupData groupData = GroupData.builder()
                                           .id(id)
                                           .name(name)
                                           .build();

            groups.add(groupData);
        }

        return groups;
    }

    @Step("Получить количество контактов")
    public int getListCount() {
        ElementsCollection groups = $$(By.name("selected[]"));
        return groups.size();
    }
}