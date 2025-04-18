package ru.ls.qa.school.addressbook.tests.contact;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.model.ContactData;
import ru.ls.qa.school.addressbook.model.Contacts;
import ru.ls.qa.school.addressbook.tests.TestBase;

import static org.assertj.core.api.Assertions.assertThat;

public class ContactUpdateTest extends TestBase {

    @BeforeEach
    public void checkForContact() {
        if (ui.contact()
              .checkListIsEmpty()) {
            openPage.mainPage()
                    .goToNewContactPage()
                    .fillForm()
                    .submitCreation();
        }
    }

    @Test
    public void testContactUpdate() {
        int beforeIndicator = ui.contact()
                                .getCountIndicator();

        Contacts contactsBefore = ui.contact()
                                    .getList();
        ContactData modifiedContact = contactsBefore.iterator()
                                                    .next();
        ContactData expectedContact = utils.generate()
                                           .contact().withId(modifiedContact.getId());

        openPage.mainPage()
                .updateContact(modifiedContact)
                .fillForm(expectedContact)
                .submitUpdate();

        Contacts contactsAfter = ui.contact()
                                   .getList();

        int resultIndicator = ui.contact()
                                .getCountIndicator();

        assertThat(beforeIndicator)
                .as("Проверка счеткика количества контактов")
                .withFailMessage(String.format("Ожидаемое количестов контактов: %s, фактическое %s", resultIndicator, resultIndicator - 1))
                .isEqualTo(resultIndicator);

        assertThat(contactsAfter)
                .as("Проверка списка контактов после обновления")
                .withFailMessage(String.format("Ожидаемые контакты %s, полученные контакты %s", contactsBefore.without(modifiedContact).withAdded(expectedContact), contactsAfter))
                .usingRecursiveComparison()
                .comparingOnlyFields("id", "lastName", "firstName", "address", "email")
                .isEqualTo(contactsBefore.withChange(modifiedContact, expectedContact));
    }
}