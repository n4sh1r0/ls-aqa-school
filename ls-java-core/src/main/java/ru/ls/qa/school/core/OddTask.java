package ru.ls.qa.school.core;

// Создаем класс OddTask
public class OddTask {
    // Создаем метод, вычисляющий четность числа

    public static boolean isOdd(int number) {
        return number % 2 != 0;
    }

    public static void main(String[] args) {
        int testnumber = 0; // Задаем тестовое число
        boolean isOdd = isOdd(testnumber);
        if (isOdd == true)
            System.out.println("Число " + testnumber + " является нечетным");
        else
            System.out.println("Число " + testnumber + " является четным");
    }
}