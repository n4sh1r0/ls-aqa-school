package ru.ls.qa.school.addressbook.pages;

import ru.ls.qa.school.addressbook.appmanager.ApplicationManager;
import ru.ls.qa.school.addressbook.model.ContactData;


public class ContactPage extends BasePage {

    public ContactPage (ApplicationManager app){
        super(app);
    }

    public ContactPage fillNewContactForm(ContactData contactData){
        app.getContactHelper().fillNewContactForm(contactData);
        return this;
    }

    public ContactPage submitCreationNewContact(){
        app.getContactHelper().submitCreationNewContact();
        return this;
    }
}