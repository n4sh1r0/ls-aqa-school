package ru.ls.qa.school.addressbook.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import ru.ls.qa.school.addressbook.app.ApplicationManager;
import ru.ls.qa.school.addressbook.pages.PageManager;
import ru.ls.qa.school.addressbook.utils.FactoryUtils;
import ru.ls.qa.school.addressbook.utils.UtilsManager;


public class TestBase {

    public static FactoryUtils generate = new FactoryUtils();
    public static ApplicationManager ui = new ApplicationManager();
    public static PageManager openPage = new PageManager();
    public static UtilsManager utils = new UtilsManager();


    @BeforeAll
    public static void setUp() {
        ui.init();
    }

    @AfterAll
    public static void tearDown() {
        ui.stop();
    }

}