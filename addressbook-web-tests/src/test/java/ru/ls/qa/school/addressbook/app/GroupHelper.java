package ru.ls.qa.school.addressbook.app;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ru.ls.qa.school.addressbook.model.GroupData;

import java.util.List;

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
        click(byCssSelector("span.group > input[type=\"checkbox\"]"));
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

    @Step("Получить количество контактов")
    public int getGroupCount() {
        ElementsCollection groups = $$(By.name("selected[]"));
        return groups.size();
    }

    @Step("Получить строку")
    public List<String> getRow() {
        ElementsCollection groups = $$("span.group");
        return groups.texts();
    }
}