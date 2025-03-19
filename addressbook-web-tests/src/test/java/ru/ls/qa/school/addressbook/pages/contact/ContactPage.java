package ru.ls.qa.school.addressbook.pages.contact;

import ru.ls.qa.school.addressbook.model.ContactData;
import ru.ls.qa.school.addressbook.pages.BasePage;

import static ru.ls.qa.school.addressbook.tests.TestBase.*;

public class ContactPage extends BasePage {

    public ContactPage fillForm() {
        return fillForm(utils.generate().contact());
    }

    public ContactPage fillForm(ContactData contact) {
        ui.contact().fillForm(contact);
        return this;
    }

    public ContactListPage submitUpdate() {
        ui.contact().submitUpdateForm();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return openPage.contacs();
    }
}