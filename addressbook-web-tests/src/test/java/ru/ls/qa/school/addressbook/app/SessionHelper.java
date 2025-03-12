package ru.ls.qa.school.addressbook.app;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SessionHelper extends BaseHelper {
    public static void login(String username, String password) {
        open("http://localhost/addressbook");
        type(byName("user"), username);
        type(byName("pass"), password);
        click(byXpath("//*[@id='LoginForm']/input[3]"));
    }

    public void logout() {
        $(byLinkText("Logout")).click();
    }
}