package bai6_ke_thua.bai_tap.Cylinder;

import bai6_ke_thua.bai_tap.Circle.Circle;

public class Cylinder extends Circle {
    private double height;

    public Cylinder() {
    }

    public Cylinder(double height, double radius, String color) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getAreaAround() {
        return 2 * Math.PI * this.getRadius() * this.height;
    }

    public double getAreaTotal() {
        return this.getAreaAround() + (2 * this.getArea());
    }

    public double getVolume() {
        return getArea() * height;
    }
    public double getAreaBottom() {
        return super.getArea();
    }

    @Override
    public String toString() {
        return "Bán kính : " + this.getRadius()
                + " _ Màu sắc: " + this.getColor()
                + " _ Chiều cao: " + this.height
                + " _ Diện tích đáy: " + this.getAreaBottom()
                + " _ Diện tích xung quanh: " + this.getAreaAround()
                + " _ Diện tích toàn phần: " + this.getAreaTotal();
     }
}
