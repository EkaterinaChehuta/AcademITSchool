package ekaterina.chehuta.shape;

public class Square implements Shape {
    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public double getWidth() {
        return sideLength;
    }

    @Override
    public double getHeight() {
        return sideLength;
    }

    @Override
    public double getArea() {
        return Math.pow(sideLength, 2);
    }

    @Override
    public double getPerimeter() {
        return sideLength * 4;
    }

    @Override
    public String toString() {
        return String.format("Square.%nSideLength = %f%nArea = %f%nPerimeter = %f", sideLength, getArea(), getPerimeter());
    }

    @Override
    public boolean equals(Object shape) {
        if (this == shape) {
            return true;
        }

        if (shape == null || getClass() != shape.getClass()) {
            return false;
        }

        Square square = (Square) shape;

        return sideLength == square.sideLength;
    }

    @Override
    public int hashCode() {
        final int prime = 29;
        int hash = 1;
        hash = prime * hash + Double.hashCode(sideLength);
        return hash;
    }
}