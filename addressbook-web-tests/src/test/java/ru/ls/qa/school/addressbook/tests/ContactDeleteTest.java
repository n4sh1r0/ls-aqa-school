package ru.ls.qa.school.addressbook.tests;

import org.junit.jupiter.api.Test;

public class ContactDeleteTest extends TestBase {


    @Test
    public void testContactDelete() {
        page.getContactListPage()
                .selectAllContacst()
                .initDeletionContact()
                .checkNumberOfContacts()
                .goToNewContactPage()
                .initContactCreation()
                .submitCreationNewContact()
                .selectFirstContact()
                .initDeletionContact()
                .returnToMainPage()
                .checkNumberOfContacts();
    }
}
