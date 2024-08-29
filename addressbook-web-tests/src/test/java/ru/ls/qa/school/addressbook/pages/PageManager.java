package ru.ls.qa.school.addressbook.pages;
import ru.ls.qa.school.addressbook.tests.TestBase;

public class PageManager extends TestBase {
    private ContactListPage contactListPage = new ContactListPage();
    private ContactCreationPage ContactCreationPage = new ContactCreationPage();
    private GroupCreationPage groupCreationPage = new GroupCreationPage();
    private GroupListPage groupListPage = new GroupListPage();

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