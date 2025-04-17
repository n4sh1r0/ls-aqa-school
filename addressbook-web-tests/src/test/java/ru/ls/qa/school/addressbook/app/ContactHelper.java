package ru.ls.qa.school.addressbook.app;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ru.ls.qa.school.addressbook.mappers.ContactDataMapper;
import ru.ls.qa.school.addressbook.model.ContactData;
import ru.ls.qa.school.addressbook.model.Contacts;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Integer.parseInt;
import static java.lang.String.format;

public class ContactHelper extends BaseHelper {

    @Step("Подтвердить создание нового контакта")
    public void submitCreationNewContact() {
        click(byXpath("//*[@id='content']/form/input[@name='submit'][1]"));
    }

    @Step("Заполнить поля нового контакта")
    public void fillForm(ContactData contactData) {
        type(byName("firstname"), contactData.getFirstName());
        type(byName("middlename"), contactData.getMiddleName());
        type(byName("lastname"), contactData.getLastName());
        type(byName("nickname"), contactData.getNickname());
        type(byName("address"), contactData.getAddress());
        type(byName("email"), contactData.getEmail());
    }

    @Step("Кликнуть обновить контакт")
    public void clickUpdate(ContactData contact) {
        SelenideElement row = $(String.format("td.center input[type='checkbox'][id='%s']", contact.getId())).closest("tr");
        row.$("img[title='Edit']")
           .click();
    }

    public void checkUpdatedContactData(String email, String lastName, String firstName) {
        $x(format("//a[text()='%s']/../../td[2]", email)).shouldNotHave(text(lastName));
        $x(format("//a[text()='%s']/../../td[3]", email)).shouldNotHave(text(firstName));
    }

    public void submitUpdateForm() {
        click(byName("update"));
    }

    @Step("Кликнуть чекбокс контакта по id")
    public void selectInList(int contactId) {
        SelenideElement checkbox = $("td.center input[type='checkbox'][id='" + contactId + "']");
        checkbox.click();
    }

    public void selectInList(ContactData contact) {
        ElementsCollection list = $$("tr[name='entry']");
        for (SelenideElement row : list) {
            if (row.$("td:nth-child(3)")
                   .text()
                   .equals(contact.getFirstName())
                    && row.$("td:nth-child(2)")
                          .text()
                          .equals(contact.getLastName())
            ) {
                click(byCssSelector("td.center:nth-child(1) > input"));
                break;
            }
        }
    }

    @Step("Кликнуть удалить контакт")
    public ContactHelper delete() {
        click(byCssSelector("input[value=Delete]"));
        return this;
    }

    @Step("Кликнуть отсортировать по Имени")
    public void sortByLastName() {
        click(byCssSelector("a.fdTableSortTrigger"));
    }

    @Step("Принять алерт")
    public void acceptAlert() {
        Selenide.confirm();
    }

    @Step("Кликнуть выбор всех контактов")
    public void selectAllList() {
        click(byCssSelector("#MassCB"));
        $("#MassCB").click();
    }

    @Step("Получить значение счетчика количества контактов")
    public int getCountIndicator() {
        String message = $("#content > label").shouldBe(visible)
                                              .getText();
        String numberStr = message.replaceAll("\\D", "");
        return parseInt(numberStr);
    }

    @Step("Список контактов пуст")
    public boolean checkListIsEmpty() {
        return !$("tr[name='entry']").exists();
    }


    @Step("Получить количество всех контактов")
    public int getListCount() {
        ElementsCollection contacts = $$(By.name("selected[]"));
        return contacts.size();
    }

    @Step("Получить Контакт по id")
    public ContactData getFromList(int contactId) {
        SelenideElement checkbox = $("td.center input[type='checkbox'][id='" + contactId + "']").should(exist);

        SelenideElement row = checkbox.closest("tr")
                                      .should(exist);

        String lastName = row.find("td:nth-of-type(2)")
                             .getText();
        String firstName = row.$("td:nth-of-type(3)")
                              .getText();
        String address = row.$("td:nth-of-type(4)")
                            .getText();
        String email = row.$("td:nth-of-type(5) a")
                          .should(exist)
                          .getText();

        List<String> protoData = List.of("", lastName, firstName, address, "", email);

        return ContactDataMapper.map(protoData);
    }

    @Step("Получаем id первого контакта")
    public int getFirstContactId() {
        SelenideElement checkbox = $("td.center input[type='checkbox']");
        return parseInt(checkbox.getAttribute("id"));
    }

    @Step("Получить список контактов ")
    public Contacts getList() {
        Contacts contacts = new Contacts();

        for (SelenideElement row : $$("tr[name='entry']")) {
            ElementsCollection cells = row.findAll("td");

            Integer id = Integer.valueOf(Objects.requireNonNull(cells.get(0)
                                                                     .$("input")
                                                                     .getAttribute("value")));

            String lastName = cells.get(1)
                                   .getText();
            String firstName = cells.get(2)
                                    .getText();
            String address = cells.get(3)
                                  .getText();
            String email = cells.get(4)
                                .getText();

            ContactData contact = ContactData.builder()
                                             .id(id)
                                             .firstName(firstName)
                                             .lastName(lastName)
                                             .address(address)
                                             .email(email)
                                             .build();

            contacts.add(contact);
        }
        return contacts;
    }
}
