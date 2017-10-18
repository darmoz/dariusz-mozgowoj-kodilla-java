package com.kodilla.stream.beautifier;

public class Markers {

    public static String at(String text) {

        return "@" + " " + text + " " + "@";
    }

    public static String readOpposite(String text) {
        String[] arry = text.split("");
        String result = "";
        for(int i=arry.length-1; i>=0; i--){
            result = result + arry[i];
        }
        return result;
    }
}
