package bai3_mang_va_phuong_thuc_trong_mang.thuc_hanh;

import java.util.Scanner;

public class TimGiaTriLonNhatTrongMang {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Nhập kích thước của mảng: ");
            size = scanner.nextInt();
            if (size > 20)
                System.out.println("Kích thước của mảng phải nhỏ hơn hoặc bằng 20");
        } while (size > 20);
        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Phần tử thứ " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
            i++;
        }
        System.out.print("Mảng đã nhập: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "  ");
        }
        System.out.println();
        int max = array[0];
        int index = 1;
        for (int j = 0; j < array.length; j++) {
            if (array[j] > max) {
                max = array[j];
                index = j + 1;
            }
        }
        System.out.println("Giá trị lớn nhất trong mảng là: " + max + " _ Nằm ở vị trí thứ " + index);
    }
}
