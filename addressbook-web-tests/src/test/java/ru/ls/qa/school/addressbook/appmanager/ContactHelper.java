package ru.ls.qa.school.addressbook.appmanager;

import ru.ls.qa.school.addressbook.model.ContactData;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;

public class ContactHelper {
    public void submitCreationNewContact() {
        $("input:nth-child(87)").click();
    }

    public void fillNewContactForm(ContactData contactData) {
        $(byName("firstname")).click();
        $(byName("firstname")).sendKeys(contactData.getFirstName());
        $(byName("middlename")).sendKeys(contactData.getMiddleName());
        $(byName("lastname")).sendKeys(contactData.getLastName());
        $(byName("nickname")).sendKeys(contactData.getNickname());
        $(byName("address")).sendKeys(contactData.getAddress());
    }
}
