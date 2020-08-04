package introction_to_java;

import java.util.Scanner;

public class UngDungChuyenDoiTienTeBT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input USD: ");
        double USD = scanner.nextDouble();
        System.out.println("USD -> VND = " + 23000 * USD + " VND");
    }
}
