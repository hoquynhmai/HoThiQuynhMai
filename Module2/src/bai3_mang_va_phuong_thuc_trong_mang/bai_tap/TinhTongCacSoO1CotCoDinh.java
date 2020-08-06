package bai3_mang_va_phuong_thuc_trong_mang.bai_tap;

import javax.security.sasl.SaslClient;
import java.util.Scanner;

public class TinhTongCacSoO1CotCoDinh {
    public static void main(String[] args) {
        int[][] array = {{1, 2, 3, 7},
                         {4, 5, 6, 8, 9, 10},
                         {7, 8, 9}};
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập cột muốn tính tổng: ");
        int number = input.nextInt();

        int sum = 0;
        for (int row = 0; row < array[number].length; row++) {
            sum += array[number][row];
        }
        System.out.println("Cột " + number);
        System.out.println(sum);
    }
}
