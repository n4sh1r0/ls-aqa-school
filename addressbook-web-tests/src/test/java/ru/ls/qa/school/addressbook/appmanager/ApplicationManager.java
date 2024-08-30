package ru.ls.qa.school.addressbook.appmanager;

import com.codeborne.selenide.Configuration;
import ru.ls.qa.school.addressbook.tests.TestBase;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class ApplicationManager {
    public GroupHelper groupHelper = new GroupHelper();
    public NavigationHelper navigationHelper = new NavigationHelper();
    public ContactHelper contactHelper = new ContactHelper();
    public SessionHelper sessionHelper = new SessionHelper();


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
