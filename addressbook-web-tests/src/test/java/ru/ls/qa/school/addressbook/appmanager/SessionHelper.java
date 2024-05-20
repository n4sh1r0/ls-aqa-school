package ru.ls.qa.school.addressbook.appmanager;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SessionHelper extends BaseHelper {
    public static void login(String username, String password) {
        open("http://localhost/addressbook");
        type(byName("user"), username);
        type(byName("pass"), password);
        $("input:nth-child(7)").click(); // не понимаю как обратиться через click к cssSelector как к локатору
    }

    public  void logout() {
        $(byLinkText("Logout")).click();
    }
}
