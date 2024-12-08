package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PasswordTest {
    @Test
    void verify_pass_is_Complexity() {
        Assert.assertTrue(Exercise.isComplexity("Lenhuquynh@3007"));
    }
    @Test
    void verify_pass_is_Complexity_case2() {
        Assert.assertTrue(Exercise.isComplexity("Lenhuquynh#3"));
    }

    @Test
    void verify_pass_is_not_Complexity_case1() {
        Assert.assertFalse(Password.isComplexity("lenhuquynh@3007"));
    }


    @Test
    void verify_pass_is_not_Complexity_case2() {
        Assert.assertFalse(Password.isComplexity("Lenhu@3"));
    }

    @Test
    void verify_pass_is_not_Complexity_case3() {
        Assert.assertFalse(Password.isComplexity("Lenhuq30"));
    }

    @Test
    void verify_pass_is_not_Complexity_case4() {
        Assert.assertFalse(Password.isComplexity("LENHUQUYNH@3"));
    }

    @Test
    void verify_pass_is_Complexity_case3() {
        Assert.assertTrue(Password.isComplexity("Lenhu quynh@3"));
    }
    @Test
    void verify_pass_is_Complexity_case4(){
        Assert.assertTrue(Password.isComplexity("Lenhuquynh$3"));
    }
}
