package com.example.lab4;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MultiDimensionalArray arr = new MultiDimensionalArray(3, 3, 3, 4);

        // Заполним массив случайными значениями
        for (int i = 0; i < arr.data.length; i++) {
            arr.data[i] = Math.random();
        }

        // Прямой доступ к элементу массива
        long start = System.nanoTime();
        double element = arr.get(2, 1, 0, 3);
        long end = System.nanoTime();
        System.out.println("Прямой доступ к элементу: " + element + " (время: " + (end - start) + " нс)");

        // Доступ через векторы Айлиффа
        start = System.nanoTime();
        double ailiff = arr.getAiliff(1, 0, -1, 3);
        end = System.nanoTime();
        System.out.println("Доступ через векторы Айлиффа: " + ailiff + " (время: " + (end - start) + " нс)");

        // Определение векторов для индекса {2, 1, -3, 5}
        start = System.nanoTime();
        int[] vector = arr.calculateVector(2, 1, -3, 5);
        end = System.nanoTime();
        System.out.println("Определение векторов: " + Arrays.toString(vector) + " (время: " + (end - start) + " нс)");

    }
}



