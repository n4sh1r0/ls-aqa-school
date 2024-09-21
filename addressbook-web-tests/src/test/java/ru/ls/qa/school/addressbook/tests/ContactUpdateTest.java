package ru.ls.qa.school.addressbook.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;

public class ContactUpdateTest extends TestBase {

    @BeforeEach
    public void checkForContact() {
        if (!$(".center").exists()) {
            page.getContactListPage()
                    .goToNewContactPage()
                    .fillContactForm()
                    .submitCreation();
        }
    }

    @Test
    public void testContactUpdate() {
        page.getContactListPage()
                .goToNewContactPage()
                .fillContactForm()
                .submitCreation()
                .clickUpdateFirstContact()
                .initContactUpdate();
    }
}
