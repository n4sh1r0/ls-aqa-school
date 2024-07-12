package ru.ls.qa.school.core;

public class PointTask {
    public static void main(String[] args) {

        Point point1 = new Point(0, 0);
        Point point2 = new Point(1, 1);

        double distance = point1.distance(point2);
        System.out.println("Расстояние между точками = " + distance);
    }
}