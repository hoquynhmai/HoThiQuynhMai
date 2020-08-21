package bai15_xu_ly_ngoai_le_debug.bai_tap;

public class Triangle {
    public  Triangle(int side1, int side2, int side3) throws IllegalTriangleException{
        if (side1 <= 0 || side2 <= 0 || side3 <= 0 || (side1 + side2) < side3 || (side2 + side3) < side1 || (side1 + side3) < side2) {
            throw  new IllegalTriangleException("Không phải là tam giác");
        } else throw  new IllegalTriangleException("Là tam giác hợp lệ");
    }
}
