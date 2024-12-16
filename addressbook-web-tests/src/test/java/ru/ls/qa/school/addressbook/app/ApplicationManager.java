package ru.ls.qa.school.addressbook.app;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class ApplicationManager {
    private GroupHelper groupHelper = new GroupHelper();
    private NavigationHelper navigationHelper = new NavigationHelper();
    private ContactHelper contactHelper = new ContactHelper();
    private SessionHelper sessionHelper = new SessionHelper();


    public void init() {
        Configuration.browser = System.getProperty("selenide.browser", "chrome");
        // "chrome", "firefox", "legacy_firefox", "ie", "htmlunit", "opera", "safari", "edge"
        open("http://localhost/addressbook");
        SessionHelper.login("admin", "secret");
    }

    public void stop() {
        closeWebDriver();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }
}