package ru.ls.qa.school.addressbook.tests;
import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.model.ContactData;

public class NewContactTest extends TestBase {

    @Test
    public void testNewContact() {
        app.getNavigationHelper().goToNewContactPage();
        app.getContactHelper().fillNewContactForm(new ContactData("testname",
                "testname",
                "testname",
                "testname",
                "Moscow"));
        app.getContactHelper().submitCreationNewContact();
        app.getNavigationHelper().returnToMainPage();
        app.getSessionHelper().logout();
    }
}

