package ru.ls.qa.school.addressbook.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import ru.ls.qa.school.addressbook.appmanager.ApplicationManager;
import ru.ls.qa.school.addressbook.appmanager.PageManager;
import ru.ls.qa.school.addressbook.pages.ContactPage;
import ru.ls.qa.school.addressbook.pages.GroupPage;


public class TestBase  {

    public static ApplicationManager app = new ApplicationManager();
    public static PageManager page = new PageManager();



    @BeforeAll
    public static void setUp() {
        app.init();
    }

    @AfterAll
    public static void tearDown() {
        app.stop();
    }

}
