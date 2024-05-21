package ru.ls.qa.school.addressbook.appmanager;

import ru.ls.qa.school.addressbook.model.ContactData;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

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
    }
}
