package ru.ls.qa.school.addressbook.appmanager;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;

public class NavigationHelper {
    public void goToNewContactPage() {
        $(byLinkText("add new")).click();
    }

    public void goToGroupPage() {
        $(byLinkText("groups")).click();
    }

    public void returnToMainPage() {
        $(byLinkText("home")).click();
    }
}
