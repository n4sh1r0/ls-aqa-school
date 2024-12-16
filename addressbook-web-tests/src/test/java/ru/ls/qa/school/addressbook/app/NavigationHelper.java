package ru.ls.qa.school.addressbook.app;

import static com.codeborne.selenide.Selectors.byLinkText;

public class NavigationHelper extends BaseHelper {
    public void newContactPage() {
        click(byLinkText("add new"));
    }

    public void goToGroupPage() {
        click(byLinkText("groups"));
    }

    public void returnToMainPage() {
        click(byLinkText("home"));
    }
}