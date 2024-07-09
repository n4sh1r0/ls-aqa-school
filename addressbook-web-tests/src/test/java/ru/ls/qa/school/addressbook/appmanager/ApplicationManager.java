package ru.ls.qa.school.addressbook.appmanager;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class ApplicationManager {
    private final GroupHelper groupHelper = new GroupHelper();
    private final NavigationHelper navigationHelper = new NavigationHelper();
    private final ContactHelper contactHelper = new ContactHelper();
    private final SessionHelper sessionHelper = new SessionHelper();


    public void init() {
        Configuration.browser = "chrome";
        open("http://localhost/addressbook");
        SessionHelper.login("admin", "secret");
    }

    public void stop() {
        closeWebDriver();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }
}
