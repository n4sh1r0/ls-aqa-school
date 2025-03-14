package ru.ls.qa.school.addressbook.tests.contact;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.model.ContactData;
import ru.ls.qa.school.addressbook.tests.TestBase;

import static org.assertj.core.api.Assertions.*;

public class ContactUpdateTest extends TestBase {

    @BeforeEach
    public void checkForContact() {
        if (app.getContactHelper().checkContactListIsEmpty()) {
            openPage.mainPage()
                    .goToNewContactPage()
                    .fillForm()
                    .submitCreation()
                    .clickSortByLastName();
        }
    }

    @Test
    public void testContactUpdate() {
        int beforeIndicator = app.getContactHelper().getContactCountIndicator();
        int beforeCount = app.getContactHelper().getContactCount();
        int contactId = app.getContactHelper().getFirstContactId();
        ContactData contactBeforeUpdate = app.getContactHelper().getContactById(contactId);
        ContactData expectedContact = utils.generate().contact();

        openPage.mainPage()
                .clickUpdateContactById(contactId)
                .fillForm(expectedContact)
                .submitUpdate();

        ContactData contactAfterUpdate = app.getContactHelper().getContactById(contactId);

        int resultIndicator = app.getContactHelper().getContactCountIndicator();
        int resultCount = app.getContactHelper().getContactCount();

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