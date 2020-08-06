package bai2_vong_lap_trong_for;

import java.util.Scanner;

public class UngDungTinhTienLaiTH {
    public static void main(String[] args) {
        double tienGoi = 1.0;
        int thang = 1;
        double laiSuat = 1.0;
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập số tiền gởi: ");

        tienGoi = input.nextDouble();
        System.out.println("Số Tháng Gởi: ");

        thang = input.nextInt();
        System.out.println("Nhập lãi suất (%): ");

        laiSuat = input.nextDouble();
        double tienLai = 0;
        for (int i = 0; i < thang; i++) {
            tienLai += tienGoi * (laiSuat / 100) / 12 * thang;
        }
        System.out.println("Total of interset: " + tienLai);
    }
}
