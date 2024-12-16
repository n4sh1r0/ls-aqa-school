package ru.ls.qa.school.addressbook.model;

import lombok.*;

import static lombok.EqualsAndHashCode.Include;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@With
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ContactData {
    @Include
    private Integer id;
    @Include
    private String firstName;
    private String middleName;
    @Include
    private String lastName;
    private String nickname;
    @Include
    private String address;
    @Include
    private String email;
}