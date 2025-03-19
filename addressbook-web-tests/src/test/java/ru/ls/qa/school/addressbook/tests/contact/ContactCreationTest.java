package ru.ls.qa.school.addressbook.tests.contact;

import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.tests.TestBase;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreation() {
        int beforeIndicator = ui.contact().getCountIndicator();
        int beforeCount = ui.contact().getListCount();

        openPage.mainPage()
                .goToNewContactPage()
                .fillForm()
                .submitCreation();

        int resultIndicator = ui.contact().getCountIndicator();
        int resultCount = ui.contact().getListCount();

        assertThat(resultIndicator)
                .as("Проверка счетчика количества контактов")
                .withFailMessage(String.format("Ожидаемое количество контактов: %s, фактическое %s",resultIndicator, resultIndicator -1))
                .isEqualTo(beforeIndicator + 1);
        assertThat(resultCount)
                .as("Проверка общего количества контактов")
                .isEqualTo(beforeCount + 1);
    }
}