package bai5_access_modifies_static_method_static_property.bai_tap;

public class TestAccessModifiedCircle {
    public static void main(String[] args) {
        AccessModifiedCircle circle1 = new AccessModifiedCircle();
//        circle1.getRadius(10);
        System.out.println("Bán kính hình tròn: " + circle1.getRadius()+ "\n" + "Diện tích hình tròn: " + circle1.getArea());
    }
}
