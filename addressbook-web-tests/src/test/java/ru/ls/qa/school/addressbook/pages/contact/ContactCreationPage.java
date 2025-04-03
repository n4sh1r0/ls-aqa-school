package ru.ls.qa.school.addressbook.pages.contact;

import ru.ls.qa.school.addressbook.model.ContactData;
import ru.ls.qa.school.addressbook.pages.BasePage;

import static ru.ls.qa.school.addressbook.tests.TestBase.*;

public class ContactCreationPage extends BasePage {

    public ContactCreationPage fillForm() {
        return fillForm(utils.generate().contact());
    }

    public ContactCreationPage fillForm(ContactData contact) {
        ui.contact().fillForm(utils.generate().contact());
        return this;
    }

    public ContactListPage initContactUpdate() {
        ui.contact().fillForm(utils.generate().contact());
        ui.contact().submitUpdateForm();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return openPage.contacs();
    }

    public ContactListPage submitCreation() {
        ui.contact().submitCreationNewContact();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return openPage.contacs();
    }
}