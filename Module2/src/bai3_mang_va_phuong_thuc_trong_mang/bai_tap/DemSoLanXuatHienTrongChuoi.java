package bai3_mang_va_phuong_thuc_trong_mang.bai_tap;

import java.util.Scanner;

public class DemSoLanXuatHienTrongChuoi {
    public static void main(String[] args) {
        String chuoi = "Đồ Quỷ Sứ";
        Scanner input = new Scanner(System.in);
        System.out.print("Nhâp 1 ký tự cần tìm: ");
        char nhap = input.next().charAt(0);
        int count = 0;
        for (int i = 0; i < chuoi.length(); i++){
            if(nhap == chuoi.charAt(i)){
                count++;
            }
        }
        if (count == 0){
            System.out.println("Ký tự bạn nhập là: " + nhap + " , không xuất hiện trong chuỗi: " + chuoi);
        } else {
            System.out.println("Ký tự bạn nhập là: " + nhap + " , nó xuất hiện " + count + " lần trong chuỗi: " + chuoi);
        }
    }
}
