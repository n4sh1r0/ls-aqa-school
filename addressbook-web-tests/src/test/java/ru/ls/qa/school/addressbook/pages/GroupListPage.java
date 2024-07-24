package ru.ls.qa.school.addressbook.pages;
import ru.ls.qa.school.addressbook.appmanager.ApplicationManager;
import ru.ls.qa.school.addressbook.model.GroupData;

public class GroupListPage extends BasePage {

    public GroupListPage(ApplicationManager app) {
        super(app);
    }

    public GroupListPage initGroupCreation(){
        app.getGroupHelper().initGroupCreation();
        return this;
    }

    public GroupListPage goToGroupPage(){
        app.getNavigationHelper().goToGroupPage();
        return this;
    }


}