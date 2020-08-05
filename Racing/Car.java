package Lesson_5.Homework_5.Racing;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Car implements Runnable {

    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    private Thread thread;
    private static CountDownLatch cdl;
    private static AtomicInteger isWin = new AtomicInteger(0);


    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        thread = new Thread(this);
        cdl = new CountDownLatch(CARS_COUNT);
        thread.start();
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Thread getThread() {
        return thread;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            if (cdl.getCount() == 1) {
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            }
            cdl.countDown();

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        if (isWin.incrementAndGet() == 1) {
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Победитель - " + this.name);
    }
    }

}
