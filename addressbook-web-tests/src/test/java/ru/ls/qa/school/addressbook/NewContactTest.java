package ru.ls.qa.school.addressbook;// Generated by Selenium IDE

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class NewContactTest {
    private Map<String, Object> vars;

    @BeforeEach
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = true;
        open("http://localhost/addressbook");
        login("admin", "secret");
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testNewContact() {
        goToNewContactPage();
        fillContactForm(new ContactData("testname",
                "testname",
                "testname",
                "testname",
                "Moscow"));
        submitCreationNewContact();
        returnToMainPage();
        logout();
    }

    public static void returnToMainPage() {
        $(byLinkText("home")).click();
    }

    public static void submitCreationNewContact() {
        $("input:nth-child(87)").click();
    }

    public static void fillContactForm(ContactData contactData) {
        $(byName("firstname")).click();
        $(byName("firstname")).sendKeys(contactData.getFirstName());
        $(byName("middlename")).sendKeys(contactData.getMiddleName());
        $(byName("lastname")).sendKeys(contactData.getLastName());
        $(byName("nickname")).sendKeys(contactData.getNickname());
        $(byName("address")).click();
        $(byName("address")).sendKeys(contactData.getAddress());
    }

    public static void goToNewContactPage() {
        $(byLinkText("add new")).click();
    }

    public static void logout() {
        $(byLinkText("Logout")).click();
    }

    public static void login(String username, String password) {
        open("http://localhost/addressbook");
        $(byName("user")).click();
        $(byName("user")).val(username);
        $(byName("pass")).val(password);
        $("input:nth-child(7)").click();
    }


}
