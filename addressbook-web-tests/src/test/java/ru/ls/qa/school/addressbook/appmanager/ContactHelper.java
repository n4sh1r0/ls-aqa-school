package ru.ls.qa.school.addressbook.appmanager;

import ru.ls.qa.school.addressbook.model.ContactData;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class ContactHelper extends BaseHelper {

    public void fillNewContactForm(ContactData contactData) {
        type(byName("firstname"), contactData.getFirstName());
        type(byName("middlename"), contactData.getMiddleName());
        type(byName("lastname"), contactData.getLastName());
        type(byName("nickname"), contactData.getNickname());
        type(byName("address"), contactData.getAddress());
        type(byName("email"), contactData.getEmail());
    }

    public void clickUpdateContact() {
        click(byXpath("//*[@id=\"maintable\"]/tbody/tr[2]/td[8]/a/img"));
    }

    public void checkUpdatedContactData(String email, String lastName, String firstName) {
        $x(format("//a[text()='%s']/../../td[2]", email)).shouldNotHave(text(lastName));
        $x(format("//a[text()='%s']/../../td[3]", email)).shouldNotHave(text(firstName));
    }

    public void submitUpdateContact() {
        click(byXpath("//*[@id=\"content\"]/form[1]/input[1]"));
    }

    public void clickSelectContact() {
        click(byXpath("/html/body/div/div[4]/form[2]/table/tbody/tr[2]/td[1]/input"));
    }

    public void clickDeleteContact() {
        click(byXpath("/html/body/div/div[4]/form[2]/div[2]/input"));
    }

    public void acceptAlert() {
        Selenide.confirm();
    }

    public void clickSelectAllContacts() {
        $("#MassCB").click();
    }

    public void submitCreation(){
        click(byXpath("//*[@id=\"content\"]/form/input[@name=\"submit\"][1]"));
    }

    public void checkNumberOfContacts() {
        checkMessage(byCssSelector("#content > label"), "Number of results: 0");
    }

}
