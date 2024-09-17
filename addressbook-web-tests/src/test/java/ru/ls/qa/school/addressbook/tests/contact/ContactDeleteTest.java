package ru.ls.qa.school.addressbook.tests.contact;

import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.tests.TestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactDeleteTest extends TestBase {


    @Test
    public void testContactDelete() {
        var page = pages.getMainPage()
                .goToNewContactPage()
                .fillContactForm()
                .submitCreation();
        int before = app.getContactHelper().getNumberOfContacts();
        page.deleteFirstContact();
        int result = app.getContactHelper().getNumberOfContacts(); // before - 1
        assertEquals(before - 1, result);
    }
}