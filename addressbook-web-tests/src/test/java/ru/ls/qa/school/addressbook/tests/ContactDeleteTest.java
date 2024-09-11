package ru.ls.qa.school.addressbook.tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactDeleteTest extends TestBase {


    @Test
    public void testContactDelete() {
            page.getContactListPage()
                .goToNewContactPage()
                .fillContactForm()
                .submitCreation();
        int beforeDeletion = app.contactHelper.getNumberOfContacts();
            page.getContactListPage().deleteFirstContact();
        int result = app.contactHelper.getNumberOfContacts(); // before - 1
        assertEquals(beforeDeletion - 1, result);
    }
}
