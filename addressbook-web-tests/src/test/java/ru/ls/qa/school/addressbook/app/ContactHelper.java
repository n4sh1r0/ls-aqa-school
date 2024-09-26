package ru.ls.qa.school.addressbook.app;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.ls.qa.school.addressbook.model.ContactData;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class ContactHelper extends BaseHelper {

    public void submitCreationNewContact() {
        click(byXpath("//*[@id=\"content\"]/form/input[@name=\"submit\"][1]"));
    }

    public void fillNewContactForm(ContactData contactData) {
        type(byName("firstname"), contactData.getFirstName());
        type(byName("middlename"), contactData.getMiddleName());
        type(byName("lastname"), contactData.getLastName());
        type(byName("nickname"), contactData.getNickname());
        type(byName("address"), contactData.getAddress());
        type(byName("email"), contactData.getEmail());
    }

    public void clickUpdateContact() {
        click(byCssSelector("img[title=\"Edit\"]"));
    }

    public void checkUpdatedContactData(String email, String lastName, String firstName) {
        $x(format("//a[text()='%s']/../../td[2]", email)).shouldNotHave(text(lastName));
        $x(format("//a[text()='%s']/../../td[3]", email)).shouldNotHave(text(firstName));
    }

    public void submitUpdateContact() {
        click(byName("update"));
    }

    public void clickSelectFirstContact() {
        click(byCssSelector("tr[name=\"entry\"] > td.center:nth-child(1) > input"));
    }

    public void selectContact(ContactData contact) {
        ElementsCollection list = $$("tr[name=\"entry\"]");
        for (SelenideElement row : list) {
            if (row.$("td:nth-child(3)").text().equals(contact.getFirstName())
                    && row.$("td:nth-child(2)").text().equals(contact.getLastName())
            ) {
                click(byCssSelector("td.center:nth-child(1) > input"));
                break;
            }
        }
    }

    public ContactHelper clickDeleteContact() {
        click(byName("update"));
        return this;
    }

    public void clickSortByLastName() {
        click(byCssSelector("a.fdTableSortTrigger"));
    }

    public void acceptAlert() {
        Selenide.confirm();
    }

    public void clickSelectAllContacts() {
        click(byCssSelector("#MassCB"));
        $("#MassCB").click();
    }

    //TODO пусть метод возвращает количество строк контактов. например можно преобразовать смеседж в струк и удалить в ней "Number of results: " а потом преобразовать в Int
    public int getNumberOfContacts() {
        String message = $("#content > label").shouldBe(visible).getText();
        String NumberStr = message.replaceAll("\\D", "");
        return Integer.parseInt(NumberStr);
    }

    public boolean listIsEmpty() {
        return !$("tr[name=\"entry\"]").exists();
    }

    public int getContactCount() {
        ElementsCollection contacts = $$(By.name("selected[]"));
        return contacts.size();
    }

    public List<String> getRow(int rowNumber) {
            ElementsCollection rows = $$("table tbody tr[name='entry']");
        return rows.get(rowNumber)
                .$$("td")
                .texts();
    }
}
