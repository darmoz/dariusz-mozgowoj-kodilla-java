package factory;

public final class Square implements Shape {
    final String name;
    final double length;

    public Square(final String name, final double length) {
        this.name = name;
        this.length = length;
    }

    @Override
    public String getName() {
        return name;
    }

    public double getLength() {
        return length;
    }

    public double getField() {
        return Math.pow(length,2.0);
    }

    public double getCircumference() {
        return 4*length;
    }
}
