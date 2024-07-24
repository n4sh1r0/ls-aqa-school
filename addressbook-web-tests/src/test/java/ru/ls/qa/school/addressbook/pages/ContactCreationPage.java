package ru.ls.qa.school.addressbook.pages;

import ru.ls.qa.school.addressbook.appmanager.ApplicationManager;
import ru.ls.qa.school.addressbook.model.ContactData;

public class ContactCreationPage extends BasePage {
    public ContactCreationPage(ApplicationManager app) {super(app);}

    public ContactCreationPage fillNewContactForm(ContactData contactData){
        app.getContactHelper().fillNewContactForm(contactData);
        return this;
    }

    public ContactCreationPage returnToMainPage() {
        app.getNavigationHelper().returnToMainPage();
        return this;
    }
}
