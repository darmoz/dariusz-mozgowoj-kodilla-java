package com.kodilla.testing.shape;

import java.util.*;
import com.kodilla.testing.shape.Circle;
import com.kodilla.testing.shape.Square;
import com.kodilla.testing.shape.Triangle;

public class ShapeCollector {
    Shape shape;
    ArrayList<Shape> shapeList = new ArrayList<Shape>();

/*    public ShapeCollector(ArrayList<Shape> shapeList) {

        this.shapeList = shapeList;
    }*/

    public void addFigure(Shape shape) {

        shapeList.add(shape);
    }

    public boolean removeFigure(Shape shape) {
        boolean result = false;
        if (shapeList.contains(shape)) {
            shapeList.remove(shape);
            result = true;
        }
        return result;
    }

    public Shape getFigure(int n){
        Shape result = null;
        if(shapeList.size() >= n) {
            Shape figure = shapeList.get(n);
            result = figure;
        }
        return result;
    }

    public String showFigure(int n){
        String figureDescriptor = shapeList.get(n).toString();
        return figureDescriptor;
    }
}
