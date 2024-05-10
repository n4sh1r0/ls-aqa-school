package ru.ls.qa.school.test;

import ru.ls.qa.school.core.OddTask;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OddTest {
    @Test
    void isOdd() {
        assertTrue(OddTask.isOdd(1));
    }
    @Test
    void isEven() {
        assertFalse(OddTask.isOdd(0));
    }
}
