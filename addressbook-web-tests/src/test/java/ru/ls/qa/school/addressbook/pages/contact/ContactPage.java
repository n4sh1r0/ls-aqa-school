package ru.ls.qa.school.addressbook.pages.contact;

import ru.ls.qa.school.addressbook.model.ContactData;
import ru.ls.qa.school.addressbook.pages.BasePage;
import ru.ls.qa.school.addressbook.utils.FactoryUtils;

import static ru.ls.qa.school.addressbook.tests.TestBase.*;

public class ContactPage extends BasePage {

    public ContactPage fillForm() {
        return fillForm(utils.generate().contact());
    }

    public ContactPage fillForm(ContactData contact) {
        app.getContactHelper().fillNewContactForm(generate.contact());
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