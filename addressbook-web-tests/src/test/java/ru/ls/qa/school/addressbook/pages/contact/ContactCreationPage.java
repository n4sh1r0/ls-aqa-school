package ru.ls.qa.school.addressbook.pages.contact;

import ru.ls.qa.school.addressbook.model.ContactData;
import ru.ls.qa.school.addressbook.pages.BasePage;
import ru.ls.qa.school.addressbook.utils.FactoryUtils;

import static ru.ls.qa.school.addressbook.tests.TestBase.*;

public class ContactCreationPage extends BasePage {

    public ContactCreationPage fillForm() {
        return fillForm(utils.generate().contact());
    }

    public ContactCreationPage fillForm(ContactData contact) {
        app.getContactHelper().fillNewContactForm(generate.contact());
        return this;
    }

    public ContactListPage initContactUpdate() {
        app.getContactHelper().fillNewContactForm(new FactoryUtils().contact());
        app.getContactHelper().submitUpdate();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return openPage.contacs();
    }

    public ContactListPage submitCreation() {
        app.getContactHelper().submitCreationNewContact();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return openPage.contacs();
    }
}