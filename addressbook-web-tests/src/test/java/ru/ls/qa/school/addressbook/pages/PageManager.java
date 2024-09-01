package ru.ls.qa.school.addressbook.pages;

public class PageManager  {
    public GroupListPage groupListPage = new GroupListPage();
    public ContactListPage contactListPage = new ContactListPage();
    public GroupCreationPage groupCreationPage = new GroupCreationPage();
    public ContactCreationPage contactCreationPage = new ContactCreationPage();

    public GroupCreationPage getGroupCreationPage() {
        return groupCreationPage;
    }

    public GroupListPage getGroupListPage() {
        return groupListPage;
    }

    public ContactListPage getContactListPage() { return contactListPage; }

    public ContactCreationPage getContactCreationPage() {
        return contactCreationPage;
    }
}