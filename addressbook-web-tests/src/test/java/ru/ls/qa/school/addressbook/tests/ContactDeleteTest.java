package ru.ls.qa.school.addressbook.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static java.nio.file.Files.exists;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactDeleteTest extends TestBase {

    @BeforeEach
    public void checkForContact() {
        if (!$(".center").exists()) {
            page.getContactListPage()
                    .goToNewContactPage()
                    .fillContactForm()
                    .submitCreation();
        }
    }


    @Test
    public void testContactDelete() {
        int beforeDeletion = app.contactHelper.getNumberOfContacts();
            page.getContactListPage().deleteFirstContact();
        int result = app.contactHelper.getNumberOfContacts(); // before - 1
        assertEquals(beforeDeletion - 1, result);
    }
}
