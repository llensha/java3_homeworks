package Homework_6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static Lesson_6.Homework_6.MainTests.checkArrayForOneAndFour;

public class Test_checkArrayForOneAndFour {

    @ParameterizedTest
    @MethodSource("generator")
    public void massTestAdd(int[] arr, boolean expected) {

        Assertions.assertEquals(expected, checkArrayForOneAndFour(arr));
    }
    private static Stream<Arguments> generator() {
        int[] arr1 = {1, 1, 1, 4, 4, 1, 4, 4};
        int[] arr2 = {1, 1, 1, 1, 1, 1};
        int[] arr3 = {4, 4, 4, 4};
        int[] arr4 = {1, 4, 4, 1, 1, 4, 3};

        return Stream.of(
                Arguments.of(arr1, true),
                Arguments.of(arr2, false),
                Arguments.of(arr3, false),
                Arguments.of(arr4, false));
    }
}
