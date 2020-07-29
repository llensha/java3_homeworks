package Lesson_3.Homework_3;

import java.io.Serializable;

public class Cat implements Serializable {
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void info() {
        System.out.println("Клиентом передана информация о коте:");
        System.out.println("Имя: " + this.name);
        System.out.println("Возраст: " + this.age);
    }
}
