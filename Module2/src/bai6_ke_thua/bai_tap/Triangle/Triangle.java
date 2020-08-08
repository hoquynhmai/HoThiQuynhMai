package bai6_ke_thua.bai_tap.Triangle;

import bai6_ke_thua.bai_tap.Shape.Shape;

public class Triangle extends Shape {
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    public Triangle() {
    }

    public Triangle(double side1, double side2, double side3,String color, boolean filled) {
        super(color, filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    // Công thức Heron tính Diện tích tam giác
    public double getArea() {
        double haftPerimeter = getPerimeter()/2;
        return Math.sqrt(haftPerimeter * (haftPerimeter- this.side1) * (haftPerimeter - this.side2) * (haftPerimeter - this.side3));
    }

    public double getPerimeter() {
        return this.side1 + this.side2 + this.side3;
    }

    @Override
    public String toString(){
        return "3 cạnh của tam giác: " + this.side1 + ", " + this.side2 + ", " + this.side3
                + " _ Chu Vi Tam Giác: " + this.getPerimeter()
                + " _ Diện tích Tam Giác: " + this.getArea()
                + super.toString();
    }
}
