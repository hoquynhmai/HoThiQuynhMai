package introction_to_java;

import java.util.Scanner;

public class HienThiLoiChaoBT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập Tên: ");
        String name = scanner.nextLine();
        System.out.println("Hello " + name);
    }
}
