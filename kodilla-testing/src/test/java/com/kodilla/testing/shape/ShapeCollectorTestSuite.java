package com.kodilla.testing.shape;

import com.kodilla.testing.shape.ShapeCollector;
import com.kodilla.testing.shape.Circle;
import com.kodilla.testing.shape.Square;
import com.kodilla.testing.shape.Triangle;
import com.kodilla.testing.shape.Shape;
import java.util.*;
import org.junit.*;


public class ShapeCollectorTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    public void testAddFigure() {
        //Given
        Shape circle = new Circle("circle", 5);
        Shape triangle = new Triangle("triangle", 4);
        Shape square = new Square("square", 2);
        ShapeCollector collector = new ShapeCollector();
        //When
        collector.addFigure(circle);
        //Then
        Assert.assertEquals(circle, collector.getFigure(0) );
    }

    @Test
    public void testRemoveFigure() {
        //Given
        Shape circle = new Circle("circle", 5);
        Shape triangle = new Triangle("triangle", 4);
        Shape square = new Square("square", 2);
        ShapeCollector collector = new ShapeCollector();
        collector.addFigure(circle);
        collector.addFigure(triangle);
        collector.addFigure(square);
        //When
        boolean result = collector.removeFigure(triangle);
        //Then
        Assert.assertTrue(result);
        Assert.assertEquals(2, collector.shapeList.size() );
    }

    @Test
    public void testGetFigure() {
        //Given
        Shape circle = new Circle("circle", 5);
        Shape triangle = new Triangle("triangle", 4);
        Shape square = new Square("square", 2);
        ShapeCollector collector = new ShapeCollector();
        collector.addFigure(circle);
        collector.addFigure(triangle);
        collector.addFigure(square);
        //When
        Shape result = collector.getFigure(1);
        //Then
        Assert.assertEquals(triangle, collector.getFigure(1));
    }
}