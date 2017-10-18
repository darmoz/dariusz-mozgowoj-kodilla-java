package com.kodilla.stream.beautifier;

import java.awt.*;
import java.awt.color.*;

public class BeautifyApp {

    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();

        poemBeautifier.beautify("ora et labora", String::toUpperCase);
        poemBeautifier.beautify("GlorY", String::toLowerCase);
        poemBeautifier.beautify("Java", Markers::at);
        poemBeautifier.beautify("Flower", Markers::readOpposite);

    }
}
