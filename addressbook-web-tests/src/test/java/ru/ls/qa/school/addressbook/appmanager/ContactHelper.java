package ru.ls.qa.school.addressbook.appmanager;

import ru.ls.qa.school.addressbook.model.ContactData;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byXpath;

public class ContactHelper extends BaseHelper {
    public void submitCreationNewContact() {
        click(byXpath("//*[@id=\"content\"]/form/input[@name=\"submit\"][1]"));
    }

    public void fillContactForm(ContactData contactData) {
        type(byName("firstname"), contactData.getFirstName());
        type(byName("middlename"), contactData.getMiddleName());
        type(byName("lastname"), contactData.getLastName());
        type(byName("nickname"), contactData.getNickname());
        type(byName("address"), contactData.getAddress());
    }

    public void clickUpdateContact() {
        click(byXpath("//*[@id=\"maintable\"]/tbody/tr[2]/td[8]/a/img"));
    }

    public void checkUpdatedContactData() {
        checkMessage(byXpath("//*[@id=\"maintable\"]/tbody/tr[2]/td[2]"), "updatedlastname");
        checkMessage(byXpath("//*[@id=\"maintable\"]/tbody/tr[2]/td[3]"), "updatedfirstname");
        checkMessage(byXpath("//*[@id=\"maintable\"]/tbody/tr[2]/td[4]"), "updatedaddress");
    }

    public void submitUpdateContact() {
        click(byXpath("//*[@id=\"content\"]/form[1]/input[1]"));
    }
}
