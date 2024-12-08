package org.example;

import java.util.Arrays;
import java.util.List;

public class Exercise {
    public static void main(String[] args) {
 /*   int[] array={1,4,9,8,2,8};
        int max = array[0];
        for(int num: array){
            if(max <num)
                max = num;
        }
        System.out.println("Phan tu lon nhat la "+max);
     */
        //Array vs List vs Set?
        int[] array={1,4,9,8,2,8};
        int max= Arrays.stream(array).max().getAsInt();
        System.out.println(max);
        List<Integer> list=Arrays.stream(array).boxed().toList();
        int maxIndex=list.indexOf(max);
        System.out.println(maxIndex);
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0);
    }


    public static boolean isVowels(String input) {
        if (input.length() != 1) throw new IllegalArgumentException("input string length must be equals 1");
        return "aeiouAEIOU".contains(input);
    }


    /**
     * ## 2. Password Complexity
     * len > 8 characters
     * include number
     * include lowercases
     * include uppercases
     * include "!@#$%^&*()"
     * <p>
     * **create a function**:
     * <p>
     * - String as input
     * - Boolean as output
     */
    public static boolean isComplexity(String password) {
        boolean upper = false;
        boolean lower = false;
        boolean digit = false;
        boolean spec=false;
        if (password.length() < 8) {
            return false;
        }
      //  if("!@#$%^&*()".contains(password)){
       //     spec=true;
       // }

        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                upper = true;
            }
            if (Character.isLowerCase(password.charAt(i))) {
                lower = true;
            }
            if (Character.isDigit(password.charAt(i))) {
                digit = true;
            }

         if (!Character.isLetter(password.charAt(i)) && !Character.isDigit(password.charAt(i)) && !Character.isWhitespace(password.charAt(i)))
           {
                spec = true;
            }
            }


        return (upper && lower && digit &&spec);
    }}



