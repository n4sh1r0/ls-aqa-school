package ru.ls.qa.school.addressbook.tests;

import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.model.ContactData;


public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreation() {
        page.getContactListPage()
                .goToNewContactPage()
                .initContactCreation();
    }
}

