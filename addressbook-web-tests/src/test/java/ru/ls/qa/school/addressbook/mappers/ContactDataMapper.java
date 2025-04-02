package ru.ls.qa.school.addressbook.mappers;

import ru.ls.qa.school.addressbook.model.ContactData;

import java.util.List;

public class ContactDataMapper {
    public static ContactData map(List<String> protoData) {
        return ContactData.builder()
                .firstName(protoData.get(2))
                .lastName(protoData.get(1))
                .address(protoData.get(3))
                .email(protoData.get(5))
                .build();
    }
}
