package bai3_mang_va_phuong_thuc_trong_mang.thuc_hanh;

import java.util.Scanner;

public class ChuyenDoiNhietDo {
    public static void main(String[] args) {
        System.out.println("Menu");
        System.out.println("1. Chuyển đổi từ Độ F sang Độ C");
        System.out.println("2. Chuyển đổi từ Độ C sang Độ F");
        System.out.println("0. Thoát");
        Scanner input = new Scanner(System.in);
        System.out.print("Chọn: ");
        double doF;
        double doC;
        while (true) {
            int chon = input.nextInt();
            switch (chon){
                case 1 :
                    System.out.println("Độ F sang Độ C");
                    System.out.print("Nhập độ F: ");
                    doF = input.nextDouble();
                    System.out.println(doF + " độ F = " + ((5.0 / 9) * (doF - 32)) + " Độ C");
                    break;
                case 2 :
                    System.out.println("Độ C sang Độ F");
                    System.out.print("Nhập độ C: ");
                    doC = input.nextDouble();
                    System.out.println(doC + " độ C = " + (((9.0 / 5) * doC) + 32) + " Độ F");
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Chọn lại");
                    break;
            }
        }
    }
}
// 50 doC = 122 doF
// 100 doF = 37.7778 doC
