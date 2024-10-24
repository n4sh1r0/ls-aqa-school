package ru.ls.qa.school.addressbook.utils;

import ru.ls.qa.school.addressbook.model.ContactData;
import ru.ls.qa.school.addressbook.model.GroupData;

import static ru.ls.qa.school.addressbook.utils.primitive.RandomUtils.*;

public class GenerateUtils {

    public ContactData contact() {
        return ContactData.builder()
                .firstName(generateRandomString(getRandomLength()))
                .lastName(generateRandomString(getRandomLength()))
                .middleName(generateRandomString(getRandomLength()))
                .email(generateRandomEmail())
                .nickname(generateRandomString(getRandomLength()))
                .address("Moscow").build();
    }

    public GroupData group() {
        return GroupData.builder()
                .name(generateRandomString(getRandomLength()))
                .header(generateRandomString(getRandomLength()))
                .footer(generateRandomString(getRandomLength())).build();
    }
}