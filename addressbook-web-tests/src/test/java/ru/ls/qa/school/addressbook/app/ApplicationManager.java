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
        session().login("admin", "secret");
    }

    public void stop() {
        closeWebDriver();
    }

    public GroupHelper group() {
        return groupHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public ContactHelper contact() {
        return contactHelper;
    }

    public SessionHelper session() {
        return sessionHelper;
    }
}