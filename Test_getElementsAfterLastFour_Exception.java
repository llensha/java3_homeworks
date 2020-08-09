package Homework_6;

import org.junit.Assert;
import org.junit.Test;

import static Lesson_6.Homework_6.MainTests.getElementsAfterLastFour;

public class Test_getElementsAfterLastFour_Exception {

    @Test
    public void test() {
        int[] arrStart = {1, 2, 8, 6, 2, 3, 5, 1, 7};
        Assert.assertThrows(RuntimeException.class, () -> {
            getElementsAfterLastFour(arrStart);
        });
    }

}
