package ru.ls.qa.school.addressbook.appmanager;

import com.codeborne.selenide.Selenide;
import ru.ls.qa.school.addressbook.model.ContactData;

import static com.codeborne.selenide.Selectors.*;
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

    public void clickUpdateFirstContact() {
        click(byXpath("//*[@id=\"maintable\"]/tbody/tr[2]/td[8]/a/img"));
    }

    public void submitUpdateContact() {
        click(byXpath("//*[@id=\"content\"]/form[1]/input[1]"));
    }

    public void clickSelectFirstContact() {
        click(byCssSelector("html > body > div > div:nth-of-type(4) > form:nth-of-type(2) > table > tbody > tr:nth-of-type(2) > td:nth-of-type(1)"));
    }

    public void clickDeleteContact() {
        click(byXpath("/html/body/div/div[4]/form[2]/div[2]/input"));
    }

    public void acceptAlert() {
        Selenide.confirm();
    }

    public void clickSelectAllContacts() {
        click(byCssSelector("#MassCB"));
    }

    //TODO пусть метод возвращает количество строк контактов. например можно преобразовать смеседж в струк и удалить в ней "Number of results: " а потом преобразовать в Int
    public int getNumberOfContacts() {
        checkMessage(byCssSelector("#content > label"), "Number of results: 0");
    }

}
