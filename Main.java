package Lesson_1.Homework_1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nЗадание 1\n");

        Integer[] numbers = {77, 55, 33, 88, 22};
        System.out.println("Начальный массив:                " + Arrays.toString(numbers));
        changeElementsOfArray(numbers, 2, 4);
        changeElementsOfArray(numbers, 0, 3);

        String[] fruits = {"apple", "apricot", "melon", "pineapple", "lemon"};
        System.out.println("\nНачальный массив:                " + Arrays.toString(fruits));
        changeElementsOfArray(fruits, 1, 3);
        changeElementsOfArray(fruits, 0, 4);

        System.out.println("\nЗадание 2\n");

        String[] animals = {"dog", "cat", "frog", "monkey", "bird"};
        System.out.println("Массив:    " + Arrays.toString(animals));
        ArrayListMaker<String> animalsList = new ArrayListMaker<>(animals);
        animalsList.makeArrayList();

        Integer[] nums = {13, 21, 33, 45, 57};
        System.out.println("\nМассив:    " + Arrays.toString(nums));
        ArrayListMaker<Integer> numsList = new ArrayListMaker<>(nums);
        numsList.makeArrayList();

        System.out.println("\nЗадание 3\n");

        Box<Apple> appleBox1 = new Box<>();
        Box<Apple> appleBox2 = new Box<>();
        Box<Orange> orangeBox = new Box<>();

        for (int i = 0; i < 10; i++) {
            appleBox1.add(new Apple());
        }
        for (int i = 0; i < 30; i++) {
            appleBox2.add(new Apple());
        }
        for (int i = 0; i < 20; i++) {
            orangeBox.add(new Orange());
        }

        System.out.println("Вес первой коробки с яблоками = " + appleBox1.getWeight());
        System.out.println("Вес второй коробки с яблоками = " + appleBox2.getWeight());
        System.out.println("Вес коробки с апельсинами = " + orangeBox.getWeight());
        System.out.println();
        System.out.println("Совпадение веса первой и второй коробок с яблоками: " + appleBox1.compare(appleBox2));
        System.out.println("Совпадение веса первой коробки с яблоками и коробки с апельсинами: " + appleBox1.compare(orangeBox));
        System.out.println("Совпадение веса второй коробки с яблоками и коробки с апельсинами: " + appleBox2.compare(orangeBox));
        System.out.println();
        appleBox1.put(appleBox2);
        System.out.println("После перекладывания яблок из коробки 1 в коробку 2:");
        System.out.println("Вес первой коробки с яблоками = " + appleBox1.getWeight());
        System.out.println("Вес второй коробки с яблоками = " + appleBox2.getWeight());
    }

    private static void changeElementsOfArray(Object[] objects, int index1, int index2) {
        Object tmp = objects[index1];
        objects[index1] = objects[index2];
        objects[index2] = tmp;
        System.out.println(String.format("Поменяли местами элементы %d и %d: ", index1, index2) + Arrays.toString(objects));
    }
}
