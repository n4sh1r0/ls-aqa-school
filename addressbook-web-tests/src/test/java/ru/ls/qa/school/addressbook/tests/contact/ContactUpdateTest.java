package ru.ls.qa.school.addressbook.tests.contact;

import org.assertj.core.api.AssertJProxySetup;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.model.ContactData;
import ru.ls.qa.school.addressbook.tests.TestBase;

import static org.assertj.core.api.Assertions.*;

public class ContactUpdateTest extends TestBase {

    @BeforeEach
    public void checkForContact() {
        if (app.getContactHelper().listIsEmpty()) {
            pages.getMainPage()
                    .goToNewContactPage()
                    .fillContactForm()
                    .submitCreation()
                    .clickSortByLastName();
        }
    }

    @Test
    public void testContactUpdate() {
        int beforeIndicator = app.getContactHelper().getContactCountIndicator();
        int beforeCount = app.getContactHelper().getContactCount();

        int contactId = app.getContactHelper().getByRow(0).getId();

        ContactData expected = utils.generate().contact();
        expected.setId(contactId);

        pages.getMainPage()
                .clickUpdateFirstContact()//TODO ты не можешь брать первый контакт, так как у тебя сортировка происходит не по id, и при смене данных расположение апдейтнутого пользователя поменяется. Нужно подбирать юзера по id
                .fillForm(expected)
                .submitUpdate()
                .clickSortByLastName();

        int resultIndicator = app.getContactHelper().getContactCountIndicator();
        int resultCount = app.getContactHelper().getContactCount();

        //TODO поменять проверки на AssertJ в остальных классах, по аналогии
        assertThat(beforeIndicator)
                .as("Проверка: TODO")
                .isEqualTo(resultIndicator);
        assertThat(beforeCount)
                .as("Проверка: TODO")
                .isEqualTo(resultCount);

        ContactData result = app.getContactHelper().getById(contactId);

        //TODO Проверить  объекты нужно через AssertJ - как именно см. урок. ВАЖНО - нужно проверять только часть
        assertContacts(expected, result);
    }

    //TODO gпри проверке через AsserJ - нам этот метод будет не нужен
    private void assertContacts(ContactData expected, ContactData result) {
        assertEquals(expected.getId(), result.getId());
        assertNotEquals(expected.getLastName(), result.getLastName());
        assertNotEquals(expected.getFirstName(), result.getFirstName());
        assertEquals(expected.getAddress(), result.getAddress());
        assertNotEquals(expected.getEmail(), result.getEmail());
    }
}