package ru.ls.qa.school.addressbook.app;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class BaseHelper {
    protected static void click(By locator) {
        $(locator).click();
    }

    protected static void type(By locator, String text) {
        $(locator).val(text);
    }

    protected static void checkMessage(By locator, String message) {
        $(locator).shouldHave(text(message));
    }
}