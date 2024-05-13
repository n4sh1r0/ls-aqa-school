package ru.ls.qa.school.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PointTest {
    @Test
    public void testDistanceBeetwenDifferentPoints() {

        Point point1 = new Point(1, 1);
        Point point2 = new Point(0, 0);

        double actualDistance = point1.distance(point2);
        double expectedDistance = 1.4142135623730951;

        assertEquals(expectedDistance, actualDistance, 0.0001);
    }
    @Test
    public void testDistanceBeetwenSamePoints() {

        Point point1 = new Point(0, 0);
        Point point2 = new Point(0, 0);

        boolean samePoints;

        samePoints = (point1.x == point2.x) && (point1.y == point2.y);

        assertTrue(samePoints);
    }
}

