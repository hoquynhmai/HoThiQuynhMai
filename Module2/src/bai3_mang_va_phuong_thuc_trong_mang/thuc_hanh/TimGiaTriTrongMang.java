package bai3_mang_va_phuong_thuc_trong_mang.thuc_hanh;

import java.util.Scanner;

public class TimGiaTriTrongMang {
    public static void main(String[] args) {
        String[] students = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên cần tìm: ");
        String input_name = scanner.nextLine();

        boolean isExist = false;
        for (int i = 0; i < students.length; i++) {
            if (students[i].equals(input_name)) {
                System.out.println("Tên " + input_name + " ở vị trí thứ " + (i + 1) + " trong danh sách");
                isExist = true;
                break;
            }
        }
        if (!isExist)
            System.out.println("Không tìm thấy tên " + input_name + " trong danh sách");
    }
}
