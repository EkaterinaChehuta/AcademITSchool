package ekaterina.chehuta.shape;

public class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return (width + height) * 2;
    }

    @Override
    public String toString() {
        return String.format("Rectangle.%nWidth = %f%nHeight = %f%nArea = %f%nPerimeter = %f", width, height, getArea(), getPerimeter());
    }

    @Override
    public boolean equals(Object shape) {
        if (this == shape) {
            return true;
        }

        if (shape == null || getClass() != shape.getClass()) {
            return false;
        }

        Rectangle rectangle = (Rectangle) shape;

        return width == rectangle.width &&
                height == rectangle.height;
    }

    @Override
    public int hashCode() {
        return (int) (getWidth() + getHeight());
    }
}