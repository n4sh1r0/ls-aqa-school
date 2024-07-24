package ru.ls.qa.school.addressbook.pages;

import ru.ls.qa.school.addressbook.appmanager.ApplicationManager;
import ru.ls.qa.school.addressbook.model.GroupData;


public class GroupCreationPage extends BasePage {


    public GroupCreationPage(ApplicationManager app) {
        super(app);
    }

    public GroupCreationPage fillGroupForm(GroupData groupData){
        app.getGroupHelper().fillGroupForm(groupData);
        return this;
    }

    public GroupCreationPage checkMessageAfterGroupCreation(){
        app.getGroupHelper().checkMessageAfterGroupCreation();
        return this;
    }

    public GroupCreationPage returnToMainPage(){
        app.getNavigationHelper().returnToMainPage();
        return this;
    }

}
