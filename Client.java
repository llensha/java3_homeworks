package Lesson_3.Homework_3;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    Socket socket;
    DataOutputStream out;

    final String IP_ADDRESS = "localhost";
    final int PORT = 8189;

    public Client() {
        try {
            socket = new Socket(IP_ADDRESS, PORT);
            out = new DataOutputStream(socket.getOutputStream());
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try (ObjectOutputStream oos = new ObjectOutputStream(out)) {
                        Scanner scanner = new Scanner(System.in);
                        String oneMore;
                        do {
                            System.out.print("Введите имя кота: ");
                            String name = scanner.next();
                            System.out.print("Введите возраст кота: ");
                            int age = scanner.nextInt();

                            Cat cat = new Cat(name, age);
                            oos.writeObject(cat);

                            System.out.println("Информация о коте передана на сервер");
                            System.out.print("Продолжить? Y/N: ");
                            oneMore = scanner.next();
                        } while (oneMore.equalsIgnoreCase("Y"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Client();
    }
}
