package ru.ls.qa.school.addressbook.pages;

import ru.ls.qa.school.addressbook.appmanager.ApplicationManager;
import ru.ls.qa.school.addressbook.model.ContactData;


public class ContactPage extends BasePage {

    public ContactPage(ApplicationManager app) {
        super(app);
    }

    public ContactPage fillContactForm(ContactData contactData) {
        app.getContactHelper().fillContactForm(contactData);
        return this;
    }

    public ContactPage submitCreationNewContact() {
        app.getContactHelper().submitCreationNewContact();
        return this;
    }

    public ContactPage goToNewContactPage() {
        app.getNavigationHelper().goToNewContactPage();
        return this;
    }

    public ContactPage returnToMainPage() {
        app.getNavigationHelper().returnToMainPage();
        return this;
    }

    public ContactPage logout() {
        app.getSessionHelper().logout();
        return this;
    }

    public ContactPage clickUpdateContact() {
        app.getContactHelper().clickUpdateContact();
        return this;
    }

    public ContactPage checkUpdatedContactData() {
        app.getContactHelper().checkUpdatedContactData();
        return this;
    }

    public ContactPage submitUpdateContact() {
        app.getContactHelper().submitUpdateContact();
        return this;
    }

    public ContactPage clickSelectContact() {
        app.getContactHelper().clickSelectContact();
        return this;
    }

    public ContactPage clickDeleteContact() {
        app.getContactHelper().clickDeleteContact();
        return this;
    }

    public ContactPage acceptAllert() {
        app.getContactHelper().acceptAllert();
        return this;
    }

    public ContactPage clickSelectAllContacts() {
        app.getContactHelper().clickSelectAllContacts();
        return this;
    }

    public ContactPage checkNumberOfContacts() {
        app.getContactHelper().checkNumberOfContacts();
        return this;
    }


}