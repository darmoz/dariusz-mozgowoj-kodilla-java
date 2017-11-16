package factory;

public final class Circle implements Shape {
    final String name;
    final double radius;

    public Circle(final String name, final double radius) {
        this.name = name;
        this.radius = radius;
    }

    @Override
    public String getName() {
        return name;
    }

    public double getRadius() {
        return radius;
    }

    public double getField() {
        return Math.PI*Math.pow(radius,2.0);
    }

    public double getCircumference() {
        return 2*Math.PI*radius;
    }
}
