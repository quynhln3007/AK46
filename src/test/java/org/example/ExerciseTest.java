package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ExerciseTest {
    @Test
    void verify_10_is_EvenNumber() {
        Assert.assertTrue(Exercise.isEven(10));
    }

    @Test
    void verify_11_is_OddNumber() {
        Assert.assertFalse(Exercise.isEven(11));
    }

    @Test
    void verify_0_is_EvenNumber() {
        Assert.assertTrue(Exercise.isEven(0));
    }

    @Test
    void verify_2024_is_leapYear() {
        Assert.assertTrue(Exercise.isLeapYear(2024));
    }

    @Test
    void verify_2023_is_not_leapYear() {
        Assert.assertFalse(Exercise.isLeapYear(2023));
    }






}
