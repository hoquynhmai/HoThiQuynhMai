package bai2_vong_lap_trong_for;

import java.util.Scanner;

public class HienThiCacLoaiHinhBT1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Menu");
        System.out.println("1. Vẽ Hình Chữ Nhật");
        System.out.println("2. Vẽ Hình Tam Giác");
        System.out.println("3. Vẽ Hình Tam Giác Cân");
        System.out.println("0. Thoát");
        System.out.print("Chọn: ");

        while (true) {
            int chon = input.nextInt();
            switch (chon) {
                case 1:
                    System.out.println("Vẽ Hình Chữ Nhật");
                    for (byte hang = 1; hang <= 3; hang++) {
                        for (byte cot = 1; cot <= 10; cot++) {
                            System.out.print("*");
                        }
                        System.out.println("");
                    }
                    break;
                case 2:
                    System.out.println("Vẽ Tam Giác");
                    System.out.println("Tam Giác 1");
                    for (byte hang = 1; hang <= 5; hang++) {
                        for (byte cot = 1; cot <= hang; cot++) {
                            System.out.print("*");
                        }
                        System.out.println("");
                    }
                    System.out.println("");

                    System.out.println("Tam Giác 2");
                    for (byte hang = 1; hang <= 5; hang++) {
                        for (byte cot = 5; hang <= cot; cot--) {
                            System.out.print("*");
                        }
                        System.out.println("");
                    }
                    System.out.println();

                    System.out.println("Tam Giác 3");
                    for (byte hang = 4, cot; hang >= 0; hang--) {
                        for (cot = 1; cot <= hang; cot++) {
                            System.out.print(" ");
                        }
                        for (cot = 4; cot >= hang; cot--) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    System.out.println();

                    System.out.println("Tam Giác 4");
                    for(byte hang=0,cot;hang<=5;hang++){
                        for(cot=1;cot<=hang;cot++){
                            System.out.print(" ");
                        }
                        for(hang=5;hang>=cot;hang--){
                            System.out.print("*");
                        }
                        System.out.println();
                    }

                    System.out.print("Enter your choice: ");
                    break;
                    //Tam giác 3,4 xem lại
                case 3:
                    System.out.println("Vẽ Hình Tam Giác Cân");
                    for (byte hang = 1; hang <= 5; hang++) {
                        for (byte cot = 1; cot <= hang; cot++) {
                            System.out.print(" *");
                        }
                        System.out.println("");
                    }
                    System.out.println("");
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
