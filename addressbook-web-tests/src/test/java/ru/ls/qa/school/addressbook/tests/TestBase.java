package ru.ls.qa.school.addressbook.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import ru.ls.qa.school.addressbook.appmanager.ApplicationManager;


public class TestBase {

    protected static final ApplicationManager app = new ApplicationManager();

    @BeforeAll
    public static void setUp() {
        app.init();
    }

    @AfterAll
    public static void tearDown() {
        app.stop();
    }

}
