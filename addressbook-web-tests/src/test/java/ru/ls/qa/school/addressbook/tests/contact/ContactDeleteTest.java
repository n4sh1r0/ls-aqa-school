package ru.ls.qa.school.addressbook.tests.contact;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.model.ContactData;
import ru.ls.qa.school.addressbook.pages.contact.ContactListPage;
import ru.ls.qa.school.addressbook.tests.TestBase;

import java.util.ArrayList;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class ContactDeleteTest extends TestBase {

    static ContactListPage page;

    @BeforeEach
    public void checkForContact() {
        page = openPage.mainPage();
        if (ui.contact()
              .checkListIsEmpty()) {
            page = page.goToNewContactPage()
                       .fillForm()
                       .submitCreation();
        }
    }

    @Test
    public void testContactDelete() {
        int beforeIndicator = ui.contact()
                                .getCountIndicator();
        int beforeCount = ui.contact()
                            .getListCount();
        int contactId = ui.contact()
                          .getFirstContactId();
        ArrayList<ContactData> contactsBefore = ui.contact()
                                            .getList();
        ContactData deletedContact = contactsBefore.iterator().next();

        page.deleteContact(deletedContact);

        int resultIndicator = ui.contact()
                                .getCountIndicator();
        int resultCount = ui.contact()
                            .getListCount();

        ArrayList<ContactData> contactsAfter = ui.contact().getList();

        assertThat(resultIndicator)
                .as("Проверка счеткика количества контактов")
                .withFailMessage(String.format("Ожидаемое количестов контактов: %s, фактическое %s", resultIndicator, resultIndicator - 1))
                .isEqualTo(beforeIndicator - 1);
        assertThat(resultCount)
                .as("Проверка общего количества контактов")
                .isEqualTo(beforeCount - 1);

        contactsBefore.remove(deletedContact);
        assertThat(contactsAfter)
                .as("Проверка списка контактов после удаления")
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(contactsBefore);
    }
}