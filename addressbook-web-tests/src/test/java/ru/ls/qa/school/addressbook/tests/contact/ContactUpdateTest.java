package ru.ls.qa.school.addressbook.tests.contact;

import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.tests.TestBase;

public class ContactUpdateTest extends TestBase {

    @Test
    public void testContactUpdate() {
        pages.getMainPage()
                .goToNewContactPage()
                .fillContactForm()
                .submitCreation()
                .clickUpdateFirstContact()
                .fillForm()
                .submitUpdate();
    }
}