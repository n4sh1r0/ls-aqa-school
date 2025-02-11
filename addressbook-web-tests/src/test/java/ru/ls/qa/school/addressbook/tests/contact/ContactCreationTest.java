package ru.ls.qa.school.addressbook.tests.contact;

import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.tests.TestBase;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreation() {
        int beforeIndicator = app.getContactHelper().getContactCountIndicator();
        int beforeCount = app.getContactHelper().getContactCount();

        pages.getMainPage()
                .goToNewContactPage()
                .fillContactForm()
                .submitCreation();

        int resultIndicator = app.getContactHelper().getContactCountIndicator();
        int resultCount = app.getContactHelper().getContactCount();

        assertThat(resultIndicator)
                .isEqualTo(beforeIndicator + 1);
        assertThat(resultCount)
                .isEqualTo(beforeCount + 1);
    }
}