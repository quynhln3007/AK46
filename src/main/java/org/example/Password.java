package org.example;

public class Password {
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
    }
}
