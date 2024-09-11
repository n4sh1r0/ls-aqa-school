package ru.ls.qa.school.addressbook.tests;

import org.junit.jupiter.api.Test;

public class ContactUpdateTest extends TestBase {

    @Test
    public void testContactUpdate() {
        page.getContactListPage()
                .goToNewContactPage()
                .fillContactForm()
                .submitCreation()
                .clickUpdateFirstContact()
                .initContactUpdate();
    }
}
