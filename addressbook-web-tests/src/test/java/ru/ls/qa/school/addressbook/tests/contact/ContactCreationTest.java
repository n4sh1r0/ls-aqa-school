package ru.ls.qa.school.addressbook.tests.contact;

import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.tests.TestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreation() {
        int beforeCreation = app.getContactHelper().getContactCount();
        pages.getMainPage()
                .goToNewContactPage()
                .fillContactForm()
                .submitCreation();
        assertEquals(app.getContactHelper().getContactCount(), beforeCreation + 1);
    }
}