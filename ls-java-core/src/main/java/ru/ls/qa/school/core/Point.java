package ru.ls.qa.school.core;

// Создаем класс Point
public class Point {
        private int x;
        private int y;

    // Создаем конструктор для значений x y
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

        // Создаем метод для рассчета дистанции
        public double distance (Point point){
        return Math.sqrt(Math.pow(x-point.x, 2) + Math.pow(y-point.y, 2));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}


