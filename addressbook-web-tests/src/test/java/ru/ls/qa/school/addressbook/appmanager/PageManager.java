package ru.ls.qa.school.addressbook.appmanager;

import ru.ls.qa.school.addressbook.pages.ContactCreationPage;
import ru.ls.qa.school.addressbook.pages.ContactListPage;
import ru.ls.qa.school.addressbook.pages.GroupCreationPage;
import ru.ls.qa.school.addressbook.pages.GroupListPage;

public class PageManager {
    public final ApplicationManager app;
    public GroupListPage groupListPage;
    public ContactListPage contactListPage;
    public GroupCreationPage groupCreationPage;
    public ContactCreationPage contactCreationPage;


    public PageManager(ApplicationManager app) {
        this.app = app;
    }

    public GroupCreationPage getGroupCreationPage() {
        return groupCreationPage;
    }

    public GroupListPage getGroupListPage() {
        return groupListPage;
    }

    public ContactListPage getContactListPage() {
        return contactListPage;
    }

    public ContactCreationPage getContactCreationPage() {
        return contactCreationPage;
    }
}