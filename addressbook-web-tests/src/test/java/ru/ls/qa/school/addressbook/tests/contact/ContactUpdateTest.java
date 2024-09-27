package ru.ls.qa.school.addressbook.tests.contact;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
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
            firstContact = app.getContactHelper().getContact(0);
        }
    }

    @Test
    public void testContactUpdate() {
        int beforeIndicator = app.getContactHelper().getContactCountIndicator();
        int beforeCount = app.getContactHelper().getContactCount();

        //TODO Сортировать ничего не нужно. список по-умолчанию сортируется по id
        pages.getContactListPage().clickSortByLastName();
        firstContact = app.getContactHelper().getContact(0);
        pages.getMainPage()
                .clickUpdateFirstContact()
                .fillForm()
                .submitUpdate()
                .clickSortByLastName();

        int resultIndicator = app.getContactHelper().getContactCountIndicator();
        int resultCount = app.getContactHelper().getContactCount();

        assertEquals(beforeIndicator, resultIndicator);
        assertEquals(beforeCount, resultCount);

        //TODO это плохая проверка: она лишь проверяет что первая строка не такая как в прошлый раз.
        // нужно проверять соответствие того что теперь есть с тем что сохранялось
        assertNotEquals(firstContact, app.getContactHelper().getContact(0));
    }
}