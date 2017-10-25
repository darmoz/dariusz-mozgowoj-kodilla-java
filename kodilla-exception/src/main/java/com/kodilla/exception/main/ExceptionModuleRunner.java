package com.kodilla.exception.main;

import com.kodilla.exception.io.FileReaderWithoutHandling;

import java.io.IOException;

public class ExceptionModuleRunner {

    public static void main (String[] args){

        FileReaderWithoutHandling fileReader = new FileReaderWithoutHandling();
        try {
            fileReader.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}