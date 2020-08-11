package bai7_abstract_class_interface.bai_tap.trien_khai_interface_colorable;

import bai7_abstract_class_interface.bai_tap.trien_khai_interface_rezieable.shape.Circle;
import bai7_abstract_class_interface.bai_tap.trien_khai_interface_rezieable.shape.Rectangle;
import bai7_abstract_class_interface.bai_tap.trien_khai_interface_rezieable.shape.Shape;

public class ColorableTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Square();
        shapes[1] = new Circle();
        shapes[2] = new Rectangle();
        for (Shape shape : shapes) {
            if (shape instanceof Colorable) {
                Square square = new Square();
                System.out.print(shape.getArea() + " ");
                square.howToColor();
            } else {
                System.out.println(shape.getArea());
            }
        }
    }
}