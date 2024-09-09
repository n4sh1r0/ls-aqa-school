package ru.ls.qa.school.addressbook.tests;

import org.junit.jupiter.api.Test;

public class ContactDeleteTest extends TestBase {


    @Test
    public void testContactDelete() {
        int before = app.contactHelper.getNumberOfContacts(); // 0, 1, 80

        var p = page.getContactListPage()
                .goToNewContactPage()
                .fillContactForm()
                .submitCreation()
                .deleteFirstContact();
        int result = app.contactHelper.getNumberOfContacts(); // before - 1
    }
}
