package ru.ls.qa.school.addressbook;

import com.codeborne.selenide.Configuration;

import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

public class ApplicationManager {
    private Map<String, Object> vars;

    public static void checkMessageAfterGroupCreation() {
        $(".msgbox").shouldHave(text("A new group has been entered into the address book.\n return to the group page"));
    }

    public static void submitGroupCreation() {
        $(byName("submit")).click();
    }

    public static void fillGroupForm(GroupData groupData) {
        $(byName("group_name")).click();
        $(byName("group_name")).val(groupData.getName());
        $(byName("group_header")).click();
        $(byName("group_header")).val(groupData.getHeader());
        $(byName("group_footer")).click();
        $(byName("group_footer")).val(groupData.getFooter());
    }

    public static void logout() {
        $(byLinkText("Logout")).click();
    }

    public static void returnToMainPage() {
        $(byLinkText("home")).click();
    }

    public static void initGroupCreation() {
        $(byName("new")).click();
    }

    public static void goToGroup() {
        $(byLinkText("groups")).click();
    }

    public static void login(String username, String password) {
        open("http://localhost/addressbook");
        $(byName("user")).click();
        $(byName("user")).val(username);
        $(byName("pass")).val(password);
        $("input:nth-child(7)").click();
    }

    public static void submitCreationNewContact() {
        $("input:nth-child(87)").click();
    }

    public static void fillNewContactForm(ContactData contactData) {
        $(byName("firstname")).click();
        $(byName("firstname")).sendKeys(contactData.getFirstName());
        $(byName("middlename")).sendKeys(contactData.getMiddleName());
        $(byName("lastname")).sendKeys(contactData.getLastName());
        $(byName("nickname")).sendKeys(contactData.getNickname());
        $(byName("address")).sendKeys(contactData.getAddress());
    }

    public static void goToNewContactPage() {
        $(byLinkText("add new")).click();
    }

    protected static void init() {
        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = true;
        open("http://localhost/addressbook");
        ApplicationManager.login("admin", "secret");
    }

    protected static void stop() {
        closeWebDriver();
    }
}
