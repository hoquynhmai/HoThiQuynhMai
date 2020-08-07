package bai4_lop_va_doi_tuong_trong_java.bai_tap;

import java.util.Scanner;

public class QuadraticEquation_PTBH {
    private double a, b, c;
    double delta;

    public QuadraticEquation_PTBH() {

    }

    public QuadraticEquation_PTBH(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getDiscriminant() {
        delta = ((b * b) - (4 * a * c));
        return delta;
    }

    public double getRoot1() {
        if (delta >= 0) {
            return (-b + Math.sqrt(delta) / (2 * a));
        } else {
            return 0;
        }
    }

    public double getRoot2() {
        if (delta >= 0) {
            return (-b - Math.sqrt(delta) / (2 * a));
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập a: ");
        double a = input.nextDouble();

        System.out.print("Nhập b: ");
        double b = input.nextDouble();

        System.out.print("Nhập c: ");
        double c = input.nextDouble();

        QuadraticEquation_PTBH quadraticEquation = new QuadraticEquation_PTBH(a, b, c);

        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    System.out.print("Phương trình vô số nghiệm");
                } else {
                    System.out.print("Phương trình vô nghiệm");
                }
            } else {
                System.out.print("Phuong trình có 1 nghiệm: x = " + (-c / b));
            }
        } else {
            if (quadraticEquation.getDiscriminant() > 0) {
                System.out.print("Phương Trình có 2 nghiệm: " + "\n" + "x1 = " + quadraticEquation.getRoot1() + "\n" + "x2 = " + quadraticEquation.getRoot2());
            } else if (quadraticEquation.getDiscriminant() == 0) {
                System.out.print("Phương trình có nghiệm kép: x = " + (-b / (2 * a)));
            } else {
                System.out.println("Phương trình vô nghiệm");
            }
        }
    }
}
