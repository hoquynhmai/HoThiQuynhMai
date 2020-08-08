package bai6_ke_thua.bai_tap.Circle;

public class Circle {
    private double radius;
    private String color;

    public Circle() {
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
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
    public double getArea(){
        return radius * radius * Math.PI;
    }
    @Override
    public String toString() {
        return "Bán kính: "
                + getRadius()
                + " _ Màu sắc "
                + getColor()
                + " _ Diện tích hình tròn: "
                + this.getArea();
    }
}
