package ru.ls.qa.school.addressbook.tests.contact;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.tests.TestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactDeleteTest extends TestBase {

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
    public void testContactDelete() {
        int before = app.getContactHelper().getNumberOfContacts();
        pages.getMainPage().deleteFirstContact();
        assertEquals(before - 1, app.getContactHelper().getNumberOfContacts());
    }
}