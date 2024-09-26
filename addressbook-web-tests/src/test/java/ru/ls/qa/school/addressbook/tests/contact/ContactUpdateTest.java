package ru.ls.qa.school.addressbook.tests.contact;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.tests.TestBase;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ContactUpdateTest extends TestBase {
    List<String> firstContact = new ArrayList<String>();

    @BeforeEach
    public void checkForContact() {
        if (app.getContactHelper().listIsEmpty()) {
            pages.getMainPage()
                    .goToNewContactPage()
                    .fillContactForm()
                    .submitCreation()
                    .clickSortByLastName();
            firstContact = app.getContactHelper().getRow(0);
        }
    }

    @Test
    public void testContactUpdate() {
        pages.getContactListPage().clickSortByLastName();
        firstContact = app.getContactHelper().getRow(0);
        pages.getMainPage()
                .clickUpdateFirstContact()
                .fillForm()
                .submitUpdate()
                .clickSortByLastName();
        assertNotEquals(firstContact, app.getContactHelper().getRow(0));
    }
}