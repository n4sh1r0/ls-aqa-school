package ru.ls.qa.school.addressbook.pages;
import ru.ls.qa.school.addressbook.appmanager.ApplicationManager;
import ru.ls.qa.school.addressbook.model.GroupData;

public class GroupPage extends BasePage {

    public GroupPage (ApplicationManager app){
        super(app);
    }

    public GroupPage initGroupCreation(){
        app.getGroupHelper().initGroupCreation();
        return this;
    }

    public GroupPage fillGroupForm(GroupData groupData){
        app.getGroupHelper().fillGroupForm(groupData);
        return this;
    }

    public GroupPage submitGroupCreation(){
        app.getGroupHelper().submitGroupCreation();
        return this;
    }

    public GroupPage checkMessageAfterGroupCreation(){
        app.getGroupHelper().checkMessageAfterGroupCreation();
        return this;
    }


}