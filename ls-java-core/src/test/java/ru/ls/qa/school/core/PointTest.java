package ru.ls.qa.school.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PointTest {
    @Test
    public void testDistanceBetweenDifferentPoints() {

        Point point1 = new Point(1, 1);
        Point point2 = new Point(0, 0);

        double actualDistance = point1.distance(point2);
        double expectedDistance = 1.4142135623730951;

        assertEquals(expectedDistance, actualDistance, 0.0001);
    }
    @Test
    public void testDistanceBetweenSamePoints() {

        Point point1 = new Point(0, 0);
        Point point2 = new Point(0, 0);

        boolean samePoints;
        int point1X = point1.getX();
        int point2X = point2.getX();
        int point1Y = point2.getY();
        int point2Y = point2.getY();


        samePoints = (point1X == point2X) && (point1Y == point2Y);

        assertTrue(samePoints);
    }
    @Test
    public void testDistanceBetweenPoint2ToPoint1() {

        Point point1 = new Point(1, 1);
        Point point2 = new Point(4, 4);

        double actualDistance = point2.distance(point1);
        double expectedDistance = 4.242640687119285;

        assertEquals(expectedDistance, actualDistance, 0.0001);
    }

    @Test
    public void testDistanceBetweenOnePoint() {

        Point point1 = new Point(1, 1);

        double actualDistance = point1.distance(point1);
        double expectedDistance = 0;

        assertEquals(expectedDistance, actualDistance, 0.0001);
    }

}

