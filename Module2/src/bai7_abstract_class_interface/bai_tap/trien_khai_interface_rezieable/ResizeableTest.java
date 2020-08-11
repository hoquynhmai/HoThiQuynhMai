package bai7_abstract_class_interface.bai_tap.trien_khai_interface_rezieable;

import bai7_abstract_class_interface.bai_tap.trien_khai_interface_rezieable.shape.Circle;
import bai7_abstract_class_interface.bai_tap.trien_khai_interface_rezieable.shape.Rectangle;
import bai7_abstract_class_interface.bai_tap.trien_khai_interface_rezieable.shape.Shape;
import bai7_abstract_class_interface.bai_tap.trien_khai_interface_rezieable.shape.Square;

public class ResizeableTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle();
        shapes[1] = new Rectangle();
        shapes[2] = new Square();
        System.out.println("Pre: ");
        for (Shape shape : shapes){
            System.out.println(shape);
        }
        System.out.println("After: ");
        for (Shape shape : shapes) {
            shape.resize(Math.random() * 99 + 1);
            System.out.println(shape);
        }
    }
}
