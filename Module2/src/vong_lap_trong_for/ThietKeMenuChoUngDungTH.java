package vong_lap_trong_for;

import java.util.Scanner;

public class ThietKeMenuChoUngDungTH {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Menu");
        System.out.println("1. Vẽ Hình Tam Giác");
        System.out.println("2. Vẽ Hình Vuông");
        System.out.println("3. Vẽ Hình Chữ Nhật");
        System.out.println("0. Thoát");
        System.out.print("Chọn: ");

        while (true) {
            int chon = input.nextInt();
            switch (chon) {
                case 1:
                    System.out.println("Vẽ Hình Tam Giác");
                    System.out.println("******");
                    System.out.println("*****");
                    System.out.println("****");
                    System.out.println("***");
                    System.out.println("**");
                    System.out.println("*");
                    break;
                case 2:
                    System.out.println("Vẽ Hình Vuông");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    break;
                case 3:
                    System.out.println("Vẽ Hình Chữ Nhật");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
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
