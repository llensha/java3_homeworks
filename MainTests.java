package Lesson_6.Homework_6;

import java.util.Arrays;

public class MainTests {

    public static void main(String[] args) {
//        System.out.println("\nЗадание 1\n");
//        try {
//            int[] arr1 = {1, 2, 4, 4, 2, 3, 4, 1, 7};
//            System.out.println("Исходный массив: " + Arrays.toString(arr1));
//            System.out.println("Элементы после последней 4: " + Arrays.toString(getElementsAfterLastFour(arr1)));
//            int[] arr2 = {1, 2, 4, 4, 2, 3, 5, 1, 7};
//            System.out.println("Исходный массив: " + Arrays.toString(arr2));
//            System.out.println("Элементы после последней 4: " + Arrays.toString(getElementsAfterLastFour(arr2)));
//            int[] arr3 = {1, 2, 4, 6, 2, 3, 5, 1, 7};
//            System.out.println("Исходный массив: " + Arrays.toString(arr3));
//            System.out.println("Элементы после последней 4: " + Arrays.toString(getElementsAfterLastFour(arr3)));
//            int[] arr4 = {1, 2, 8, 6, 2, 3, 5, 1, 4};
//            System.out.println("Исходный массив: " + Arrays.toString(arr4));
//            System.out.println("Элементы после последней 4: " + Arrays.toString(getElementsAfterLastFour(arr4)));
//            int[] arr5 = {1, 2, 8, 6, 2, 3, 5, 1, 7};
//            System.out.println("Исходный массив: " + Arrays.toString(arr5));
//            System.out.println("Элементы после последней 4: " + Arrays.toString(getElementsAfterLastFour(arr5)));
//        } catch (RuntimeException e) {
//            System.out.println("В массиве отсутствует 4");
//        }
//
//
//        System.out.println("\nЗадание 2\n");
//        int[] arr21 = {1, 1, 1, 4, 4, 1, 4, 4};
//        System.out.println("Массив: " + Arrays.toString(arr21) + " состоит из 1 и 4: " + checkArrayForOneAndFour(arr21));
//        int[] arr22 = {1, 1, 1, 1, 1, 1};
//        System.out.println("Массив: " + Arrays.toString(arr22) + " состоит из 1 и 4: " + checkArrayForOneAndFour(arr22));
//        int[] arr23 = {4, 4, 4, 4};
//        System.out.println("Массив: " + Arrays.toString(arr23) + " состоит из 1 и 4: " + checkArrayForOneAndFour(arr23));
//        int[] arr24 = {1, 4, 4, 1, 1, 4, 3};
//        System.out.println("Массив: " + Arrays.toString(arr24) + " состоит из 1 и 4: " + checkArrayForOneAndFour(arr24));

    }

    public static int[] getElementsAfterLastFour(int[] arr) {
        for (int i = arr.length-1; i >=0; i--) {
            if (arr[i] == 4) {
                int[] arrFinal = new int[arr.length - i - 1];
                System.arraycopy(arr, i+1, arrFinal, 0, arr.length - i - 1);
                return arrFinal;
            }
        }
        throw new RuntimeException();
    }

    public static boolean checkArrayForOneAndFour(int[] arr) {
        boolean hasOne = false;
        boolean hasFour = false;
        boolean hasNotAnother = true;
        for (int i : arr) {
            if (i == 1) {
                hasOne = true;
                break;
            }
        }
        for (int i : arr) {
            if (i == 4) {
                hasFour = true;
                break;
            }
        }
        for (int i : arr) {
            if (i != 1 && i != 4) {
                hasNotAnother = false;
                break;
            }
        }
        return hasOne && hasFour && hasNotAnother;
    }
}
