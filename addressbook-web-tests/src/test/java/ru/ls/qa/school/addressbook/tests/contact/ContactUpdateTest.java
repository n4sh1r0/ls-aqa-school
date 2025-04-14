package ru.ls.qa.school.addressbook.tests.contact;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.model.ContactData;
import ru.ls.qa.school.addressbook.tests.TestBase;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

public class ContactUpdateTest extends TestBase {

    @BeforeEach
    public void checkForContact() {
        if (ui.contact().checkListIsEmpty()) {
            openPage.mainPage()
                    .goToNewContactPage()
                    .fillForm()
                    .submitCreation();
        }
    }

    @Test
    public void testContactUpdate() {
        int beforeIndicator = ui.contact().getCountIndicator();
        int beforeCount = ui.contact().getListCount();
        int contactId = ui.contact().getFirstContactId();
        ArrayList<ContactData> contactsBefore = ui.contact()
                                                  .getList();
        ContactData modifiedContact = contactsBefore.iterator().next();
        ContactData contactBeforeUpdate = ui.contact().getFromList(contactId);
        ContactData expectedContact = utils.generate().contact();

        openPage.mainPage()
                .updateContact(modifiedContact)
                .fillForm(expectedContact)
                .submitUpdate();

        ContactData contactAfterUpdate = ui.contact().getFromList(contactId);

        ArrayList<ContactData> contactsAfter = ui.contact()
                                                  .getList();

        int resultIndicator = ui.contact().getCountIndicator();
        int resultCount = ui.contact().getListCount();

        assertThat(beforeIndicator)
                .as("Проверка счеткика количества контактов")
                .withFailMessage(String.format("Ожидаемое количестов контактов: %s, фактическое %s",resultIndicator, resultIndicator -1))
                .isEqualTo(resultIndicator);
        assertThat(beforeCount)
                .as("Проверка общего количества контактов")
                .isEqualTo(resultCount);

        assertThat(contactAfterUpdate)
                .as("Проверка обновления контакта")
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isNotEqualTo(contactBeforeUpdate);

        assertThat(contactAfterUpdate)
                .as("Проверка ожидаемого контакта")
                .usingRecursiveComparison()
                .ignoringFields("middleName", "nickname")
                .isEqualTo(expectedContact);
    }
}