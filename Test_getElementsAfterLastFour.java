package Homework_6;

import org.junit.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static Lesson_6.Homework_6.MainTests.getElementsAfterLastFour;

@RunWith(Parameterized.class)
public class Test_getElementsAfterLastFour {

    @Parameterized.Parameters
    public static Collection<int[][]> data() {
        return Arrays.asList(new int[][][]{
                {{1, 2, 4, 4, 2, 3, 4, 1, 7},{1, 7}},
                {{1, 2, 4, 4, 2, 3, 5, 1, 7},{2, 3, 5, 1, 7}},
                {{1, 2, 4, 6, 2, 3, 5, 1, 7},{6, 2, 3, 5, 1, 7}},
                {{1, 2, 8, 6, 2, 3, 5, 1, 4},{}},
        });
    }

    private int[] arrStart;
    private int[] arrFinal;

    public Test_getElementsAfterLastFour(int[] arrStart, int[] arrFinal) {
        this.arrStart = arrStart;
        this.arrFinal = arrFinal;
    }

    @Test
    public void massTestAdd() {
        Assert.assertArrayEquals(arrFinal, getElementsAfterLastFour(arrStart));
    }

}
