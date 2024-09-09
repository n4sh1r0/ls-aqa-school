package ru.ls.qa.school.addressbook.tests;

import org.junit.jupiter.api.Test;


public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreation() {
        page.getContactListPage()
                .goToNewContactPage()
                .fillContactForm()
                .submitCreation();
    }
}

