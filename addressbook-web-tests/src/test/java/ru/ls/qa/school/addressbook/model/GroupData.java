package ru.ls.qa.school.addressbook.model;

import lombok.*;

@Data
@Builder
@With
public class GroupData {
    private Integer id;
    private String name;
    private String header;
    private String footer;
}