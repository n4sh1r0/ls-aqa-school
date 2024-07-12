package ru.ls.qa.school.core;

// Создаем класс Point
public class Point {
        public int x;
        public int y;

    // Создаем конструктор для значений x y
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

        // Создаем метод для рассчета дистанции
        public double distance (Point point){
        return Math.sqrt((x-point.x)*(x-point.x) + (y-point.y)*(y-point.y));
    }
}


