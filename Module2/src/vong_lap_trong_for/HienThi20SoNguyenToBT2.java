package vong_lap_trong_for;

import java.util.Scanner;

public class HienThi20SoNguyenToBT2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập số lượng cần hiển thị: ");
        int number = input.nextInt();

        System.out.printf(number + " số nguyên tố đầu tiên là: ");
        int count = 0;
        int i = 2;
        while (count < number) {
            if (kiemTraSoNguyenTo(i)) {
                System.out.print(i + " ");
                count++;
            }
            i++;
        }
    }

    public static boolean kiemTraSoNguyenTo(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
