package Lesson_1.Homework_1;

import java.util.ArrayList;
import java.util.Iterator;

public class Box<T extends Fruit> {
    private ArrayList<T> fruits = new ArrayList<>();

    public void add(T fruit) {
        fruits.add(fruit);
    }

    public float getWeight() {
        float boxWeight = 0;
        for (T fruit : fruits) {
            boxWeight += fruit.getWeight();
        }
        return boxWeight;
    }

    public boolean compare(Box<?> box) {
        return this.getWeight() == box.getWeight();
    }

    public void put(Box<T> box) {
        Iterator<T> iter = fruits.iterator();
        while (iter.hasNext()){
            box.add(iter.next());
            iter.remove();
        }
    }

}
