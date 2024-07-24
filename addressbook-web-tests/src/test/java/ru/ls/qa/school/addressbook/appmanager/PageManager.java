package ru.ls.qa.school.addressbook.appmanager;
import ru.ls.qa.school.addressbook.pages.ContactCreationPage;
import ru.ls.qa.school.addressbook.pages.ContactListPage;
import ru.ls.qa.school.addressbook.pages.GroupCreationPage;
import ru.ls.qa.school.addressbook.pages.GroupListPage;
import ru.ls.qa.school.addressbook.tests.TestBase;

import static ru.ls.qa.school.addressbook.tests.TestBase.app;

public class PageManager extends TestBase {
    ContactListPage contactListPage = new ContactListPage(app);
    ContactCreationPage ContactCreationPage = new ContactCreationPage(app);
    GroupCreationPage groupCreationPage = new GroupCreationPage(app);
    GroupListPage groupListPage = new GroupListPage(app);

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
        return ContactCreationPage;
    }
}