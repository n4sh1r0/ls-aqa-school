package ru.ls.qa.school.addressbook.model;

import lombok.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@With
        //TODO добавить во все тесты сравнение объекта целиком используя в молях EqualsAndHashCode/ после этого написать Паше на темцу сравнения списков
public class GroupData {
    private Integer id;
    private String name;
    private String header;
    private String footer;
}