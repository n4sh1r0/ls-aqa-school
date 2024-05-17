package ru.ls.qa.school.addressbook;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import java.util.*;

public class NewGroupTest {
  private Map<String, Object> vars;
  @BeforeEach
  public void setUp() {
    Configuration.browser = "chrome";
    open("http://localhost/addressbook");
    login("admin", "secret");
  }
  @AfterEach
  public void tearDown() {
    closeWebDriver();
  }
  @Test
  public void testNewGroup() {
    goToGroup();
    initGroupCreation();
    fillGroupForm(new GroupData("contacts", "phone", "number"));
    submitGroupCreation();
    checkMessageAfterGroupCreation();
    returnToGroupPage();
  }

  private static void returnToGroupPage() {
    $(byLinkText("groups")).click();
  }


  private static void checkMessageAfterGroupCreation() {
    $(".msgbox").shouldHave(text("A new group has been entered into the address book.\n return to the group page"));
  }

  private static void submitGroupCreation() {
    $(byName("submit")).click();
  }

  private static void fillGroupForm(GroupData groupData) {
    $(byName("group_name")).click();
    $(byName("group_name")).val(groupData.getName());
    $(byName("group_header")).click();
    $(byName("group_header")).val(groupData.getHeader());
    $(byName("group_footer")).click();
    $(byName("group_footer")).val(groupData.getFooter());
  }

  private static void initGroupCreation() {
    $(byName("new")).click();
  }

  private static void goToGroup() {
    $(byLinkText("groups")).click();
  }

  public static void login(String username, String password) {
    open("http://localhost/addressbook");
    $(byName("user")).click();
    $(byName("user")).val(username);
    $(byName("pass")).click();
    $(byName("pass")).val(password);
    $("input:nth-child(7)").click();
  }
}
