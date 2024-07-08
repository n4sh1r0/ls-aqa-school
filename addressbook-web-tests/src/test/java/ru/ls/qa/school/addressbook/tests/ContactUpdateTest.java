package ru.ls.qa.school.addressbook.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.model.ContactData;

import java.util.Random;

import static com.codeborne.selenide.Selenide.$;

public class ContactUpdateTest extends TestBase {

    public static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }

        return sb.toString();
    }

    public static int getRandomLength() {
        Random random = new Random();
        return 5 + random.nextInt(6);
    }

    public static String generateRandomEmail() {
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(6);

        for (int i = 0; i < 3; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }

        sb.append('@');

        for (int i = 0; i < 2; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }

        return sb.toString();
    }

    public static String randomFirstName = generateRandomString(getRandomLength());
    String randomMiddleName = generateRandomString(getRandomLength());
    String randomNickName = generateRandomString(getRandomLength());
    public static String randomLastName = generateRandomString(getRandomLength());
    public static String randomEmail = generateRandomEmail();

    @BeforeEach
    public void checkForElement() {
        if (!$(".center").exists()) {
            pageManager.getContactPage()
                    .goToNewContactPage()
                    .fillContactForm(new ContactData(randomFirstName,
                            randomMiddleName,
                            randomLastName,
                            randomNickName,
                            "Moscow",
                            randomEmail))
                    .submitCreationNewContact()
                    .returnToMainPage();
        }
    }

    @Test
       public void testContactUpdate() {
        pageManager.getContactPage()
                .clickUpdateContact()
                .fillContactForm(new ContactData(generateRandomString(getRandomLength()),
                        generateRandomString(getRandomLength()),
                        generateRandomString(getRandomLength()),
                        generateRandomString(getRandomLength()),
                        generateRandomString(getRandomLength()),
                        randomEmail))
                .submitUpdateContact()
                .returnToMainPage()
                .checkDataOfUpdatedContact()
                .logout();
    }
}
