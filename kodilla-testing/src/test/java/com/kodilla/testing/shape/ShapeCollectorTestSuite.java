package com.kodilla.testing.shape;

import com.kodilla.testing.shape.ShapeCollector;
import com.kodilla.testing.shape.Circle;
import com.kodilla.testing.shape.Square;
import com.kodilla.testing.shape.Triangle;
import com.kodilla.testing.shape.Shape;
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
        Shape circle = new Circle("circle",5);
        ShapeCollector collector = new ShapeCollector(circle);
        //When
        collector.addFigure(circle);
        //Then
        Assert.assertEquals(circle, collector.getFigure(0) );
    }
    @Test
    public void testRemoveFigure() {
        //Given
        Shape circle = new Circle("circle", 5);
        ShapeCollector collector = new ShapeCollector(circle);
        collector.addFigure(circle);
        //When
        boolean result = collector.removeFigure(circle);
        //Then
        Assert.assertTrue(result);
        Assert.assertEquals(0, collector.shapeList.size());
    }
    @Test
    public void testGetFigure() {
        //Given
        Shape circle = new Circle("circle", 5);
        ShapeCollector collector = new ShapeCollector(circle);
        collector.addFigure(circle);
        //When
        Shape figure = collector.getFigure(0);
        //Then
        Assert.assertEquals(circle, figure);
    }
    @Test
    public void testShowFigure() {
        //Given
        Shape circle = new Circle("circle", 5);
        ShapeCollector collector = new ShapeCollector(circle);
        collector.addFigure(circle);
        //When
        String showFigure = collector.showFigure();
        //Then
        Assert.assertEquals("circle 5.0", showFigure);
    }
}