package com.jayklef.unix_financials.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppUtils {

    public static boolean isPasswordValid(String password){
        // passworD12@ min = 8, max = 20

        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*+=])(?=\\S+$).{8,20}$";

        Pattern pattern = Pattern.compile(regex);
        if (password == null){
            return false;
        }
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
