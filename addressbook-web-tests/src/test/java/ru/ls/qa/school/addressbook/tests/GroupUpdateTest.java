package ru.ls.qa.school.addressbook.tests;


import org.junit.jupiter.api.Test;
import ru.ls.qa.school.addressbook.model.GroupData;

import java.util.Random;

public class GroupUpdateTest extends TestBase {

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

    @Test
    public void testUpdateGroup() {
        pageManager.getGroupPage()
                .goToGroupPage()
                .clickGroupCreation()
                .fillGroupForm(new GroupData("contacts", "phone", "number"))
                .submitGroupCreation()
                .checkMessageAfterGroupCreation()
                .goToGroupPage()
                .clickSelectGroup()
                .clickEditGroup()
                .fillGroupForm(new GroupData("updatedContacts", "updatedPhone", "updatedNumber"))
                .submitUpdateGroup()
                .goToGroupPage()
                .checkUpdatedDataGroup() // спросить
                .returnToMainPage()
                .logout();
    }

}