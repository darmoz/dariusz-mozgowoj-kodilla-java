package factory;

import org.junit.Assert;
import org.junit.Test;

public class ShapeFactoryTestSuite {
    @Test
    public void testCircle() {
        //given
        ShapeFactory factory = new ShapeFactory();
        Shape circle = factory.makeShape("CIRCLE");
        //when
        String circleName = circle.getName();
        double circleField = circle.getField();
        //then
        Assert.assertEquals("The rounded circle", circleName);
        Assert.assertEquals(Math.PI*Math.pow(4.50, 2.0),circleField, 0.0);

    }

    @Test
    public void testSquare() {
        //given
        ShapeFactory factory = new ShapeFactory();
        Shape square = factory.makeShape("SQUARE");
        //when
        double squareField = square.getField();
        double squareCircumference = square.getCircumference();
        //then
        Assert.assertEquals(Math.pow(7.0, 2.0), squareField, 0.0);
        Assert.assertEquals(4*7.0,squareCircumference, 0.0);
    }
}
