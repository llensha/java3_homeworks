package Lesson_7.Homework_7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class MainTest {

    public static void main(String[] args) {

        String className = "classname";
        Class testClass = null;
        try {
            testClass = Class.forName(className);
        } catch (ClassNotFoundException e) {
            System.out.println(String.format("Класс '%s' не найден", className));
        }

        try {
            start(testClass);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    private static void start(Class testClass) throws InvocationTargetException, IllegalAccessException {

        Method[] methods = testClass.getDeclaredMethods();
        checkCountMethods(testClass, BeforeSuite.class, methods);
        checkCountMethods(testClass, AfterSuite.class, methods);

        if (testClass.isAnnotationPresent(BeforeSuite.class)) {
            for (Method m : methods) {
                if (m.isAnnotationPresent(BeforeSuite.class)) {
                    m.invoke(testClass);
                }
            }
        }

        if (testClass.isAnnotationPresent(Test.class)) {
            TreeMap<Integer, Method> testMethods = new TreeMap<>(Collections.reverseOrder());
            for (Method m : methods) {
                if (m.isAnnotationPresent(Test.class)) {
                    testMethods.put(m.getAnnotation(Test.class).priority(), m);
                }
            }
            for (Map.Entry<Integer, Method> item : testMethods.entrySet()){
                item.getValue().invoke(testClass);
            }
        }

        if (testClass.isAnnotationPresent(AfterSuite.class)) {
            for (Method m : methods) {
                if (m.isAnnotationPresent(AfterSuite.class)) {
                    m.invoke(testClass);
                }
            }
        }
    }

    private static void checkCountMethods(Class testClass, Class annotation, Method[] methods) {
        if (testClass.isAnnotationPresent(annotation)) {
            int count = 0;
            for (Method m : methods) {
                if (m.isAnnotationPresent(annotation)) {
                    count++;
                }
            }
            if (count > 1) throw new RuntimeException("В тестируемом классе не должно быть более одного метода с аннотацией "
                    + annotation.getName());
        }
    }
}
