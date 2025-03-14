package ru.ls.qa.school.addressbook.tests.contact;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.model.ContactData;
import ru.ls.qa.school.addressbook.tests.TestBase;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactDeleteTest extends TestBase {

    @BeforeEach
    public void checkForContact() {
        if (app.contact().checkListIsEmpty()) {
            openPage.mainPage()
                    .goToNewContactPage()
                    .fillForm()
                    .submitCreation();
        }
    }

    @Test
    public void testContactDelete() {
        int beforeIndicator = app.contact().getCountIndicator();
        int beforeCount = app.contact().getListCount();
        int contactId = app.contact().getFirstContactId();
        Set<ContactData> contactsBefore = app.contact().getList();

        openPage.contacs().dropContactById(contactId);

        int resultIndicator = app.contact().getCountIndicator();
        int resultCount = app.contact().getListCount();

        Set<ContactData> contactsAfter = app.contact().getList();

        assertThat(resultIndicator)
                .as("Проверка счеткика количества контактов")
                .withFailMessage(String.format("Ожидаемое количестов контактов: %s, фактическое %s",resultIndicator, resultIndicator -1))
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