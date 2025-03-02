package ru.ls.qa.school.addressbook.tests.contact;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.model.ContactData;
import ru.ls.qa.school.addressbook.tests.TestBase;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
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
        int contactId = app.getContactHelper().getFirstContactId();

        Set<ContactData> contactsBefore = app.getContactHelper().getListOfContacts();
        System.out.println(contactsBefore);


        pages.getContactListPage().dropContactById(contactId);

        int resultIndicator = app.getContactHelper().getContactCountIndicator();
        int resultCount = app.getContactHelper().getContactCount();

        Set<ContactData> contactsAfter = app.getContactHelper().getListOfContacts();
        System.out.println(contactsAfter);

        assertThat(resultIndicator)
                .as("Проверка счеткика количества контактов")
                .isEqualTo(beforeIndicator - 1);
        assertThat(resultCount)
                .as("Проверка общего количества контактов")
                .isEqualTo(beforeCount - 1);

        contactsBefore.removeIf(contact -> contact.getId() == contactId);
        assertThat(contactsAfter)
                .as("Проверка списка контактов после удаления")
                .containsExactlyInAnyOrderElementsOf(contactsBefore);
    }
}