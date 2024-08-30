package ru.ls.qa.school.addressbook.pages;
import ru.ls.qa.school.addressbook.tests.TestBase;

public class PageManager extends TestBase {

    private final ContactListPage contactListPage = new ContactListPage();
    private final ContactCreationPage ContactCreationPage = new ContactCreationPage();
    private final GroupCreationPage groupCreationPage = new GroupCreationPage();
    private final GroupListPage groupListPage = new GroupListPage();

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