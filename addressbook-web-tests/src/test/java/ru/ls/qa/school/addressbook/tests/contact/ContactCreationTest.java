package ru.ls.qa.school.addressbook.tests.contact;

import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.tests.TestBase;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreation() {
        int beforeIndicator = app.getContactHelper().getContactCountIndicator();
        int beforeCount = app.getContactHelper().getContactCount();

        openPage.mainPage()
                .goToNewContactPage()
                .fillForm()
                .submitCreation();

        int resultIndicator = app.getContactHelper().getContactCountIndicator();
        int resultCount = app.getContactHelper().getContactCount();

        assertThat(resultIndicator)
                .as("Проверка счеткика количества контактов")
                .withFailMessage(String.format("Ожидаемое количестов контактов: %s, фактическое %s",resultIndicator, resultIndicator -1))
                .isEqualTo(beforeIndicator + 1);
        assertThat(resultCount)
                .as("Проверка общего количества контактов")
                .isEqualTo(beforeCount + 1);
    }
}