package ru.ls.qa.school.addressbook.pages;
import ru.ls.qa.school.addressbook.appmanager.ApplicationManager;
import ru.ls.qa.school.addressbook.model.GroupData;

public class GroupPage extends BasePage {

    public GroupPage (ApplicationManager app){
        super(app);
    }

    public GroupPage clickGroupCreation(){
        app.getGroupHelper().clickGroupCreation();
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

    public GroupPage logout(){
        app.getSessionHelper().logout();
        return this;
    }

    public GroupPage returnToMainPage(){
        app.getNavigationHelper().returnToMainPage();
        return this;
    }

    public GroupPage clickSelectGroup(){
        app.getGroupHelper().clickSelectGroup();
        return this;
    }

    public GroupPage clickEditGroup(){
        app.getGroupHelper().clickEditGroup();
        return this;
    }

    public GroupPage submitUpdateGroup(){
        app.getGroupHelper().submitUpdateGroup();
        return this;
    }

    public GroupPage checkUpdatedDataGroup(){
        app.getGroupHelper().checkUpdatedDataGroup();
        return this;
    }

    public GroupPage goToGroupPage(){
        app.getNavigationHelper().goToGroupPage();
        return this;
    }



}