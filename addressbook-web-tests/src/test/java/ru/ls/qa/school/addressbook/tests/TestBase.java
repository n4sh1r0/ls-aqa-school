package ru.ls.qa.school.addressbook.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ru.ls.qa.school.addressbook.appmanager.ApplicationManager;


public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeEach
    public void setUp() {
        app.init();
    }

    @AfterEach
    public void tearDown() {
        app.stop();
    }

}
