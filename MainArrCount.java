package Lesson_8.Homework_8;

import java.util.Arrays;

public class MainArrCount {
    public static void main(String[] args) {
        final int M = 50;
        final int N = 5;

        int[] arr = makeNewArray(M, N);
        countArray(arr, N);
    }

    private static int[] makeNewArray(int length, int count) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (int) (Math.random() * count + 1);
        }
        System.out.println("Массив чисел: " + Arrays.toString(arr));
        return arr;
    }

    private static void countArray(int[] arr, int count) {
        int[] arrCount = new int[count];
        for (int i = 0; i < arr.length; i++) {
            arrCount[arr[i]-1] += 1;
        }
        for (int i = 0; i < arrCount.length; i++) {
            System.out.println((i+1) + " = " + arrCount[i]);
        }
    }


}
