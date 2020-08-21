package bai15_xu_ly_ngoai_le_debug.bai_tap;

import java.util.Scanner;

public class IllegalTriangleException extends Exception {
    public IllegalTriangleException(String notification) {
        super(notification);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập cạnh thứ nhất của tam giác: ");
        int side1 = input.nextInt();

        System.out.print("Nhập cạnh thứ hai của tam giác: ");
        int side2 = input.nextInt();

        System.out.print("Nhập cạnh thứ ba của tam giác: ");
        int side3 = input.nextInt();

        try {
            Triangle triangle = new Triangle(side1, side2, side3);
            System.out.println(triangle.toString());
        } catch (IllegalTriangleException e){
        System.out.println(e.getMessage());
        }
    }
}
