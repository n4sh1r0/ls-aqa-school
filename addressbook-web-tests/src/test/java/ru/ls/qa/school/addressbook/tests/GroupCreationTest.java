package ru.ls.qa.school.addressbook.tests;


import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.model.GroupData;

import java.util.Random;

public class GroupCreationTest extends TestBase {

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

    String randomGroupName = generateRandomString(getRandomLength());
    String randomGroupHeader = generateRandomString(getRandomLength());
    String randomGroupFooter = generateRandomString(getRandomLength());


    @Test
    public void testNewGroup() {
        pageManager.getGroupPage()
                .goToGroupPage()
                .clickGroupCreation()
                .fillGroupForm(new GroupData(randomGroupName, randomGroupHeader, randomGroupFooter))
                .submitGroupCreation()
                .checkMessageAfterGroupCreation()
                .returnToMainPage()
                .logout();
    }

}
