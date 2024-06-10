package ru.ls.qa.school.addressbook.tests;

import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.model.ContactData;

public class ContactUpdateTest extends TestBase {

    @Test
    public void testContactUpdate() {
        pageManager.getContactPage()
                .goToNewContactPage()
                .fillContactForm(new ContactData("testfirstname",
                        "testmiddlename",
                        "testlastname",
                        "testnickname",
                        "Moscow"))
                .submitCreationNewContact()
                .returnToMainPage()
                .clickUpdateContact()
                .fillContactForm(new ContactData("updatedfirstname",
                        "testmiddlename",
                        "updatedlastname",
                        "testnickname",
                        "updatedaddress"))
                .submitUpdateContact()
                .returnToMainPage()
                .checkUpdatedContactData() // спросить на созвоне
                .logout();
    }
}
