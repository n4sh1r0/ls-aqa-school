package ru.ls.qa.school.addressbook.tests;

import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.model.ContactData;

public class NewContactTest extends TestBase {

    @Test
    public void testNewContact() {
        page.getContactPage()
                .goToNewContactPage()
                .fillNewContactForm(new ContactData("testfirstname",
                        "testmiddlename",
                        "testlastname",
                        "testnickname",
                        "Moscow"))
                .submitCreationNewContact()
                .returnToMainPage()
                .logout();
    }
}

