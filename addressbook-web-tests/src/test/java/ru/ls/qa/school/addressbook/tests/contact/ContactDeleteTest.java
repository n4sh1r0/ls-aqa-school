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
        int beforeIndicator = app.getContactHelper().getContactCountIndicator();
        int beforeCount = app.getContactHelper().getContactCount();

        pages.getMainPage().deleteFirstContact();

        int resultIndicator = app.getContactHelper().getContactCountIndicator();
        int resultCount = app.getContactHelper().getContactCount();

        assertEquals(beforeIndicator - 1, resultIndicator);
        assertEquals(beforeCount - 1, resultCount);
    }
}