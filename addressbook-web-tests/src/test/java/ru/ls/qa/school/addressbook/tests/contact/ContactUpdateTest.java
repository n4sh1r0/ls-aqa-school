package ru.ls.qa.school.addressbook.tests.contact;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.model.ContactData;
import ru.ls.qa.school.addressbook.tests.TestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        int contactId = app.getContactHelper().getByRow(0).getId();

        ContactData expected = utils.generate().contact();
        expected.setId(contactId);

        pages.getMainPage()
                .clickUpdateFirstContact()
                .fillForm(expected)
                .submitUpdate();

        int resultIndicator = app.getContactHelper().getContactCountIndicator();
        int resultCount = app.getContactHelper().getContactCount();

        assertEquals(beforeIndicator, resultIndicator);
        assertEquals(beforeCount, resultCount);

        ContactData result = app.getContactHelper().getById(contactId);
        assertEquals(expected, result);
        /**
         Assertions.assertThat(before)
         .usingRecursiveComparison()
         .ignoringFields("middleName", "nickname")
         .isEqualTo(after);
         **/
    }
}