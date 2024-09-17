package ru.ls.qa.school.addressbook.tests.contact;

import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.tests.TestBase;


public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreation() {
        pages.getMainPage()
                .goToNewContactPage()
                .fillContactForm()
                .submitCreation();
    }
}