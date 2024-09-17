package ru.ls.qa.school.addressbook.pages.contact;

import ru.ls.qa.school.addressbook.pages.BasePage;

import static ru.ls.qa.school.addressbook.tests.TestBase.*;

public class ContactPage extends BasePage {

    public ContactPage fillForm() {
        app.getContactHelper().fillNewContactForm(utils.generate().contact());
        return this;
    }

    public ContactListPage submitUpdate() {
        app.getContactHelper().submitUpdateContact();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return pages.getContactListPage();
    }
}