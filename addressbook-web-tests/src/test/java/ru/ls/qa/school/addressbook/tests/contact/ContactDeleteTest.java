package ru.ls.qa.school.addressbook.tests.contact;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.model.ContactData;
import ru.ls.qa.school.addressbook.tests.TestBase;

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

        //TODO вытащить List всех контактов Set<ContactData> contactsBefore

        ContactData contact = pages.getContactListPage().getContact(1); //TODO достать любой контакт из списка? вместо получения по id

        pages.getMainPage().dropContact(contact.getId()); //TODO передать контакт, который нужно удалить

        int resultIndicator = app.getContactHelper().getContactCountIndicator();
        int resultCount = app.getContactHelper().getContactCount();

        //TODO вытащить List всех контактов после удаления Set<ContactData> contactsAfter

        assertEquals(beforeIndicator - 1, resultIndicator);
        assertEquals(beforeCount - 1, resultCount);

        //TODO сравнить между собой списки contactsAfter и contactsBefore, УДАЛИВ из него contact
        //TODO нужно разобраться что такое Set и почему мы используем его а не ArrayList
    }
}