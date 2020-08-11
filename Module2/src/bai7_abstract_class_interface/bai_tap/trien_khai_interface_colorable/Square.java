package bai7_abstract_class_interface.bai_tap.trien_khai_interface_colorable;

import bai7_abstract_class_interface.bai_tap.trien_khai_interface_rezieable.shape.Rectangle;

public class Square extends Rectangle implements Colorable {
    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }
    public double getArea(){
        return this.getSide()*this.getSide();
    }

    @Override
    public void setWidth(double width) {
        setSide(width);
    }

    @Override
    public void setLength(double length) {
        setSide(length);
    }

    @Override
    public String toString() {
        return "A Square with side = "
                + getSide()
                + ", which is a subclass of "
                + super.toString();
    }
    @Override
    public void howToColor(){
        System.out.println("Tô 4 cạnh hình vuông");
    }
}
