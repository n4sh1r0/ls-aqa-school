package ru.ls.qa.school.addressbook.model;

import lombok.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@With
public class GroupData {
    private String name;
    private String header;
    private String footer;
}