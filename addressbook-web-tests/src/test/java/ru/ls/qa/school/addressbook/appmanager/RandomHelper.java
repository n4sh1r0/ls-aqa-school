package ru.ls.qa.school.addressbook.appmanager;

import java.util.Random;

public class RandomHelper {
    public static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }

        return sb.toString();
    }

    public static int getRandomLength() {
        Random random = new Random();
        return 5 + random.nextInt(6);
    }

    public static String generateRandomEmail() {
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(6);

        for (int i = 0; i < 3; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }

        sb.append('@');

        for (int i = 0; i < 2; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }

        return sb.toString();
    }
}
