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
    public ContactPage goToNewContactPage(){
        app.getNavigationHelper().goToNewContactPage();
        return this;
    }
    public ContactPage returnToMainPage(){
        app.getNavigationHelper().returnToMainPage();
        return this;
    }
    public ContactPage logout(){
        app.getSessionHelper().logout();
        return this;
    }
}