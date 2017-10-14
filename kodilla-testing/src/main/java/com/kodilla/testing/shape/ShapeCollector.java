package com.kodilla.testing.shape;

import java.util.*;
import com.kodilla.testing.shape.Circle;
import com.kodilla.testing.shape.Square;
import com.kodilla.testing.shape.Triangle;

public class ShapeCollector {
    Shape shape;
    ArrayList<Shape> shapeList = new ArrayList<>();

    public ShapeCollector(Shape shape){
        this.shape=shape;
    }

    public void addFigure(Shape shape){
         shapeList.add(shape);
    }

    public boolean removeFigure(Shape shape){
        boolean result = false;
        if (shapeList.contains(shape)){
            shapeList.remove(shape);
            result = true;
        }
        return result;
    }

    public Shape getFigure(int n){
        Shape figure = shapeList.get(n);
        return figure;
    }

    public String showFigure(){
        int n = shapeList.indexOf(shape);
        String figureDescriptor = shapeList.get(n).toString();
        return figureDescriptor;
    }
}
