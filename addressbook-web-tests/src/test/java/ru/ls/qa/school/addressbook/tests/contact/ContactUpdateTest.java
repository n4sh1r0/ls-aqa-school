package ru.ls.qa.school.addressbook.tests.contact;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.tests.TestBase;

public class ContactUpdateTest extends TestBase {

    @BeforeEach
    public void checkForContact() {
        if (app.getContactHelper().listIsEmpty()) {
            pages.getMainPage()
                    .goToNewContactPage()
                    .fillContactForm()
                    .submitCreation();
        }
    }

    @Test
    public void testContactUpdate() {
        pages.getMainPage()
                .clickUpdateFirstContact()
                .fillForm()
                .submitUpdate();
    }
}