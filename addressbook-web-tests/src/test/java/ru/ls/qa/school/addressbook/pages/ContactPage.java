package ru.ls.qa.school.addressbook.pages;

import ru.ls.qa.school.addressbook.model.ContactData;

import static ru.ls.qa.school.addressbook.appmanager.RandomHelper.*;
import static ru.ls.qa.school.addressbook.tests.TestBase.*;

public class ContactPage extends BasePage {
    //TODO сюда вынести все что связано с обновлением контакта

    public ContactListPage initContactUpdate() {
        app.getContactHelper().fillNewContactForm(utils.generate().contact());
        app.getContactHelper().submitUpdateContact();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return page.getContactListPage();
    }



}
