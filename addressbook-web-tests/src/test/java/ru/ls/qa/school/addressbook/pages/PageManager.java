package ru.ls.qa.school.addressbook.pages;

import ru.ls.qa.school.addressbook.pages.contact.ContactCreationPage;
import ru.ls.qa.school.addressbook.pages.contact.ContactListPage;
import ru.ls.qa.school.addressbook.pages.contact.ContactPage;
import ru.ls.qa.school.addressbook.pages.group.GroupActionResultPage;
import ru.ls.qa.school.addressbook.pages.group.GroupCreationPage;
import ru.ls.qa.school.addressbook.pages.group.GroupListPage;
import ru.ls.qa.school.addressbook.pages.group.GroupPage;

public class PageManager {

    private GroupListPage groupListPage = new GroupListPage();
    private ContactListPage contactListPage = new ContactListPage();
    private GroupCreationPage groupCreationPage = new GroupCreationPage();
    private ContactCreationPage contactCreationPage = new ContactCreationPage();
    private ContactPage contactPage = new ContactPage();
    private GroupActionResultPage groupActionResultPage = new GroupActionResultPage();
    private GroupPage groupPage = new GroupPage();

    public ContactListPage getMainPage() {
        return contactListPage;
    }

    public ContactListPage getContactListPage() {
        return contactListPage;
    }

    public GroupListPage getGroupListPage() {
        return groupListPage;
    }

    public GroupCreationPage getGroupCreationPage() {
        return groupCreationPage;
    }

    public ContactCreationPage getContactCreationPage() {
        return contactCreationPage;
    }

    public ContactPage getContactPage() {
        return contactPage;
    }

    public GroupActionResultPage getGroupActionResultPage() {
        return groupActionResultPage;
    }

    public GroupPage getGroupPage() {
        return groupPage;
    }
}