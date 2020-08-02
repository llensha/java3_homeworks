package Lesson_4.Homework_4;

public class Mfu {

    public static void main(String[] args) {

        MyThread t1 = new MyThread("Чел1", "copy");
        t1.start();

        MyThread t2 = new MyThread("Чел2", "scan");
        t2.start();

        MyThread t3 = new MyThread("Чел3", "print");
        t3.start();

        MyThread t4 = new MyThread("Чел4", "copy");
        t4.start();

        MyThread t5 = new MyThread("Чел5", "scan");
        t5.start();

        MyThread t6 = new MyThread("Чел6", "print");
        t6.start();

    }

}

class MyThread extends Thread {

    private final static Object mfu_feed = new Object();
    private final static Object mfu_print = new Object();
    private String man;
    private String operation;

    public MyThread(String man, String operation) {
        this.man = man;
        this.operation = operation;
    }

    public void run() {
        if (operation.equalsIgnoreCase("copy")) {
            copy(this.man);
        } else if (operation.equalsIgnoreCase("scan")) {
            scan(this.man);
        } else if (operation.equalsIgnoreCase("print")) {
            print(this.man);
        } else {
            System.out.println("Операция невозможна");
        }
    }

    private static void copy(String man) {
        System.out.println(man + " подошел к МФУ для копирования");
        synchronized (mfu_feed) {
            synchronized (mfu_print) {
                System.out.println(man + " копирует");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(man + " закончил копировать");
            }
        }
    }

    private static void print(String man) {
        System.out.println(man + " подошел к МФУ для печати");
        synchronized (mfu_print) {
            System.out.println(man + " печатает");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(man + " закончил печатать");
        }
    }

    private static void scan(String man) {
        System.out.println(man + " подошел к МФУ для сканирования");
        synchronized (mfu_feed) {
            System.out.println(man + " сканирует");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(man + " закончил сканировать");
        }
    }

}
