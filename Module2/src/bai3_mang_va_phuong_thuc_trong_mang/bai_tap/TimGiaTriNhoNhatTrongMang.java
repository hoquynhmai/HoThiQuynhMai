package bai3_mang_va_phuong_thuc_trong_mang.bai_tap;

import java.util.Scanner;

public class TimGiaTriNhoNhatTrongMang {
    public static void main(String[] args) {
        int size = 0;
        int[] arr;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Nhập kích thước của mảng: ");
            size = scanner.nextInt();
            if (size > 20)
                System.out.println("Kích thước của mảng phải nhỏ hơn hoặc bằng 20");
        } while (size > 20);
        arr = new int[size];
        int i = 0;
        while (i < arr.length) {
            System.out.print("Phần tử thứ " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
            i++;
        }
        System.out.print("Mảng đã nhập: ");
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }
        System.out.println();
        int result = minValue(arr);
        System.out.println("Giá trị Nhỏ nhất trong mảng là: " + result);
    }

    public static int minValue(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}

