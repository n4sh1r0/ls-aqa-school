package ru.ls.qa.school.addressbook.tests;

import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.model.ContactData;

public class ContactDeleteTest extends TestBase {

    @Test
    public void testContactDelete() {
        pageManager.getContactPage()
                .clickSelectAllContacts()
                .clickDeleteContact()
                .returnToMainPage()
                .checkNumberOfContacts()
                .goToNewContactPage()
                .fillContactForm(new ContactData("testfirstname",
                        "testmiddlename",
                        "testlastname",
                        "testnickname",
                        "Moscow"))
                .submitCreationNewContact()
                .returnToMainPage()
                .clickSelectContact()
                .clickDeleteContact()
                .acceptAllert()
                .returnToMainPage()
                .checkNumberOfContacts()
                .logout();

    }
}
