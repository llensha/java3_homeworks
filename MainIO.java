package Lesson_3.Homework_3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class MainIO {

    public static void main(String[] args) {
        System.out.println("\nЗадание 1:");
        try (FileInputStream in = new FileInputStream("for_HW_3/1.txt")) {

            byte[] arr = new byte[256];

            int x;
            while ((x = in.read(arr)) != -1) {
                System.out.print(new String(arr, 0, x));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\nЗадание 2:");

        SequenceInputStream in = null;
        FileOutputStream out = null;
        try {
            ArrayList<InputStream> ali = new ArrayList<>();

            ali.add(new FileInputStream("for_HW_3/2.txt"));
            ali.add(new FileInputStream("for_HW_3/3.txt"));
            ali.add(new FileInputStream("for_HW_3/4.txt"));
            ali.add(new FileInputStream("for_HW_3/5.txt"));
            ali.add(new FileInputStream("for_HW_3/6.txt"));

            in = new SequenceInputStream(Collections.enumeration(ali));

            File file = new File("for_HW_3/7.txt");
            file.createNewFile();
            out = new FileOutputStream(file);
            byte[] arr = new byte[256];
            int x;
            while ((x = in.read(arr)) != -1) {
                out.write(arr,0, x);
            }
            System.out.printf("Создан файл \"%s\"\n",file.getName());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
