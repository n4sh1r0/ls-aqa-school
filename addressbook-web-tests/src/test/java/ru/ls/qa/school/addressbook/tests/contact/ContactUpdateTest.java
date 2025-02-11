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



        int contactId = app.getContactHelper().getFirstContactId();
        ContactData contactBeforeUpdate = app.getContactHelper().getContactById(contactId);

        pages.getMainPage()
            .clickUpdateContactById(contactId)//TODO ты не можешь брать первый контакт, так как у тебя сортировка происходит не по id, и при смене данных расположение апдейтнутого пользователя поменяется. Нужно подбирать юзера по id
            .fillForm()
            .submitUpdate();

        ContactData contactAfterUpdate = app.getContactHelper().getContactById(contactId);

        int resultIndicator = app.getContactHelper().getContactCountIndicator();
        int resultCount = app.getContactHelper().getContactCount();

        //TODO поменять проверки на AssertJ в остальных классах, по аналогии
        assertThat(beforeIndicator)
                .as("Проверка: TODO")
                .isEqualTo(resultIndicator);
        assertThat(beforeCount)
                .as("Проверка: TODO")
                .isEqualTo(resultCount);

        assertThat(contactAfterUpdate)
                .as("Проверка обновления контакта")
                .isNotEqualTo(contactBeforeUpdate)
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isNotEqualTo(contactBeforeUpdate);
    }
}