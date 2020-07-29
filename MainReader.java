package Lesson_3.Homework_3;

import java.io.*;
import java.util.Scanner;

public class MainReader {

    public static void main(String[] args) {
        long timeStart = System.currentTimeMillis();

        System.out.println("\nЗадание 3: ");
        Scanner scanner = new Scanner(System.in);
        int pageNumber;
        System.out.println("Время запуска: " + (System.currentTimeMillis() - timeStart));

        do {
            System.out.print("Введите номер страницы от 1 до 5000: ");
            pageNumber = scanner.nextInt();
        } while (pageNumber < 1 || pageNumber > 5000);

        long timePoint2 = System.currentTimeMillis();

        try (RandomAccessFile raf = new RandomAccessFile("for_HW_3/8.txt", "r")) {
            byte[] arr = new byte[3600];
            raf.seek((pageNumber - 1) * 3600);
            raf.read(arr);
            System.out.println(new String(arr));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\nВремя чтения: " + (System.currentTimeMillis() - timePoint2));

    }
}
