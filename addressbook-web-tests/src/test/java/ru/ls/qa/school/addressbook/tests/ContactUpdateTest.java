package ru.ls.qa.school.addressbook.tests;

import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.model.ContactData;
import static ru.ls.qa.school.addressbook.appmanager.RandomHelper.*;

import java.util.Random;

public class ContactUpdateTest extends TestBase {

    @Test
    public void testContactUpdate() {
        page.getContactListPage()
                .goToNewContactPage()
                .initContactCreation()
                .submitCreationNewContact()
                .returnToMainPage()
                .clickUpdateContact()
                .initContactUpdate();
    }
}
