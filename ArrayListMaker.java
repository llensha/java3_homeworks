package Lesson_1.Homework_1;

import java.util.ArrayList;

public class ArrayListMaker<T> {
    private T[] arr;

    public ArrayListMaker(T[] arr) {
        this.arr = arr;
    }

    public void makeArrayList() {
        ArrayList<T> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        System.out.println("ArrayList: " + list);
    }
}
