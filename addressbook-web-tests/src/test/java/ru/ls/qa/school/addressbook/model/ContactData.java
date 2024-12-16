package ru.ls.qa.school.addressbook.model;

import lombok.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@With
public class ContactData {
    private Integer id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String nickname;
    private String address;
    private String email;
}