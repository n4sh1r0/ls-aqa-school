package ru.ls.qa.school.addressbook.pages;

import ru.ls.qa.school.addressbook.appmanager.ApplicationManager;

public class BasePage {
    protected ApplicationManager app;

    public BasePage(ApplicationManager app) {
        this.app = app;
    }
}