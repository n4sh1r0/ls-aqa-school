package ru.ls.qa.school.addressbook.tests;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class ContactUpdateTest extends TestBase {

    @Test
    public void testContactUpdate() {
        page.getContactListPage()
                .goToNewContactPage()
                .initContactCreation()
                .clickUpdateFirstContact()
                .initContactUpdate();
    }
}
