package bai5_access_modifies_static_method_static_property.bai_tap;

public class AccessModifiedCircle {
    private double radius = 1.0;
    private String color = "red";

    public AccessModifiedCircle(){
    }

    public void AccessModifiedCircle(double radius){
        this.radius = radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }
    public double getArea(){
        return (radius*radius*3.14);
    }
}
// Thay đổi access modified (trừ private) , còn lại vẫn chạy được
