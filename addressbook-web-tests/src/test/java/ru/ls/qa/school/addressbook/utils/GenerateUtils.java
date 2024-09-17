package ru.ls.qa.school.addressbook.utils;

import ru.ls.qa.school.addressbook.model.ContactData;
import ru.ls.qa.school.addressbook.model.GroupData;

import static ru.ls.qa.school.addressbook.utils.primitive.RandomUtils.*;

public class GenerateUtils {

    public ContactData contact() {
        return new ContactData(generateRandomString(getRandomLength()),
                generateRandomString(getRandomLength()),
                generateRandomString(getRandomLength()),
                generateRandomString(getRandomLength()),
                "Moscow",
                generateRandomEmail());
    }

    public GroupData group() {
        return new GroupData(generateRandomString(getRandomLength()),
                generateRandomString(getRandomLength()),
                generateRandomString(getRandomLength()));
    }
}