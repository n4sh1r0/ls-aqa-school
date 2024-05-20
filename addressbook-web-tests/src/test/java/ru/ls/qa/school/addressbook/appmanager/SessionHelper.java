package ru.ls.qa.school.addressbook.appmanager;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SessionHelper {
    public static void login(String username, String password) {
        open("http://localhost/addressbook");
        $(byName("user")).click();
        $(byName("user")).val(username);
        $(byName("pass")).val(password);
        $("input:nth-child(7)").click();
    }

    public  void logout() {
        $(byLinkText("Logout")).click();
    }
}
