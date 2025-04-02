package ru.ls.qa.school.addressbook.utils;

import ru.ls.qa.school.addressbook.model.ContactData;
import ru.ls.qa.school.addressbook.model.GroupData;

import static ru.ls.qa.school.addressbook.utils.primitive.RandomUtils.*;

public class FactoryUtils {

    private static String generateString() {
        return (generateRandomString(getRandomLength()));
    }

    public ContactData contact() {
        return ContactData.builder()
                .firstName(generateString())
                .lastName(generateString())
                .middleName(generateString())
                .email(generateRandomEmail())
                .nickname(generateString())
                .address("Moscow").build();
    }

    public GroupData group() {
        return GroupData.builder()
                .name(generateString())
                .header(generateString())
                .footer(generateString()).build();
    }
}