package bai6_ke_thua.bai_tap.Triangle;

import java.util.Scanner;

public class TriangleTest {
    public static void main(String[] args) {
        Triangle triangle_1 = new Triangle();
        System.out.println("Triangle 1: " + triangle_1);

        Triangle triangle_2 = new Triangle(3.4, 4.4, 6.7,"red", true);
        System.out.println("Triangle 2: " + triangle_2);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập cạnh thứ nhất của tam giác: ");
        double side1 = scanner.nextDouble();

        System.out.print("Nhập cạnh thứ hai của tam giác: ");
        double side2 = scanner.nextDouble();

        System.out.print("Nhập cạnh thứ ba của tam giác: ");
        double side3 = scanner.nextDouble();

        Triangle triangle_3 = new Triangle(side1,side2,side3, "yellow", false);
        System.out.println("Triangle 3: " + triangle_3);
    }
}
