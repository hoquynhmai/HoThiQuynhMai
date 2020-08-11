package bai7_abstract_class_interface.thuc_hanh.trien_khai_interface_comparable_cho_cac_lop_hinh_hoc;

public class Circle {
    private double radius;
    private String color;
    private boolean filled;

    public Circle() {
    }
    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        this.radius = radius;
        this.color = color;
        this.filled = filled;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "Bán kính: "
                + getRadius()
                + " _ Màu sắc "
                + getColor()
                + " _ Và "
                + (isFilled() ? "filled" : "not filled");
    }
}
