package introction_to_java;

import java.util.Scanner;

public class DienTichHCNTH {
    public static void main(String[] args) {
        float width;
        float height;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập Chiều Rộng: ");
        width = scanner.nextFloat();

        System.out.println("Nhập Chiều Dài: ");
        height = scanner.nextFloat();
        float area = width * height;

        System.out.println("Diện Tích Là: " + area);
    }
}
