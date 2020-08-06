package bai2_vong_lap_trong_for;

import java.util.Scanner;

public class TimUocChungLonNhatTH {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Nhập số thứ nhất: ");
        int num1 = input.nextInt();

        System.out.print("Nhập số thứ hai: ");
        int num2 = input.nextInt();

        num1 = Math.abs(num1);
        num2 = Math.abs(num2);
        if (num1 == 0 || num2 == 0) {
            System.out.println("Không Có Ước Chung Lớn Nhất");
        }
        while (num1 != num2) {
            if (num1 > num2) {
                num1 = num1 - num2;
            } else {
                num2 = num2 - num1;
            }
        }
        System.out.println("Ước Chung Lớn Nhất Là: " + num1);
    }
}
