package factory;

public final class Rectangle implements Shape{
    final String name;
    final double length;
    final double width;

    public Rectangle(final String name, final double length, final double width) {
        this.name = name;
        this.length = length;
        this.width = width;
    }

    @Override
    public String getName() {
        return name;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getField() {
        return length*width;
    }

    public double getCircumference() {
        return 2*width+2*length;
    }
}
