package ru.ls.qa.school.addressbook.appmanager;
import ru.ls.qa.school.addressbook.pages.ContactPage;
import ru.ls.qa.school.addressbook.pages.GroupPage;

public class PageManager {
    public final ApplicationManager app;
    public GroupPage groupPage;
    public ContactPage contactPage;

    public PageManager(ApplicationManager app) {
        this.app = app;
    }

    public GroupPage getGroupPage() {
        if (groupPage == null) {
            groupPage = new GroupPage(app);
        }
        return groupPage;
    }

    public ContactPage getContactPage() {
        if (contactPage == null) {
            contactPage = new ContactPage(app);
        }
        return contactPage;
    }
}