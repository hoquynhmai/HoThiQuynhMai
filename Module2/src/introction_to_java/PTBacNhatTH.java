package introction_to_java;

import java.util.Scanner;

public class PTBacNhatTH {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("a: ");
        double a = scanner.nextDouble();

        System.out.print("b: ");
        double b = scanner.nextDouble();

        System.out.print("c: ");
        double c = scanner.nextDouble();
        if (a != 0) {
            double answer = (c - b) / a;
            System.out.printf("Phương Trình Có Nghiệm Với x = %f!\n", answer);
            //%f! : chưa hiểu
        } else {
            if (b == 0) {
                System.out.print("Phương Trình Vô Số Nghiệm!");
            } else {
                System.out.print("Phương Trình Vô Nghiệm!");
            }
        }
    }
}
