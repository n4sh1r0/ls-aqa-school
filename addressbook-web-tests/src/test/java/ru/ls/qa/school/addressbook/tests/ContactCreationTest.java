package ru.ls.qa.school.addressbook.tests;

import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {

    @Test
    public void testNewContact() {
        pageManager.getContactPage()
                .goToNewContactPage()
                .fillContactForm(new ContactData("testfirstname",
                        "testmiddlename",
                        "testlastname",
                        "testnickname",
                        "Moscow"))
                .submitCreationNewContact()
                .returnToMainPage()
                .logout();
    }
}
