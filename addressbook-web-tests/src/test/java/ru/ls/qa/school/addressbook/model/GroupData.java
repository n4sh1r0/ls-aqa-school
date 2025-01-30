package ru.ls.qa.school.addressbook.model;

import lombok.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@With
//TODO добавить во все тесты сравнение объекта целиком используя в молях EqualsAndHashCode.
// после этого добавить получение списков моделей из ui и их сравнение.
// пример сравнения есть в классе ContactUpdateTest
public class GroupData {
    private Integer id;
    private String name;
    private String header;
    private String footer;
}