package ru.ls.qa.school.addressbook.pages;

import static ru.ls.qa.school.addressbook.tests.TestBase.app;
import static ru.ls.qa.school.addressbook.tests.TestBase.page;

public class BasePage {
    protected ApplicationManager app;

    public BasePage(ApplicationManager app) {
        this.app = app;
    }
}