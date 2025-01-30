package ru.ls.qa.school.addressbook.utils;

public class UtilsManager {
    private FactoryUtils generateUtils = new FactoryUtils();

    public FactoryUtils generate() {
        return generateUtils;
    }
}
