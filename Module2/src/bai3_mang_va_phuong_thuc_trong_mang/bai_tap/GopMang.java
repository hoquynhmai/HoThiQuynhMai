package bai3_mang_va_phuong_thuc_trong_mang.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class GopMang {
    public static void main(String[] args) {
        int[] array1 = new int[5];
        int[] array2 = new int[5];
        int[] array3 = new int[10];
        Scanner input = new Scanner(System.in);

        // Nhập Mảng 1 và Hiển thị Mảng 1
        System.out.println("Mảng 1: ");
        for (int i = 0; i < array1.length; i++) {
            System.out.print("Phần tử thứ " + (i + 1) + ": ");
            array1[i] = input.nextInt();
        }
        System.out.print("Mảng 1 đã nhập: ");
        for (int element1 : array1)
            System.out.print(element1 + " ");
        System.out.println();

        // Nhập Mảng 2 và Hiển thị Mảng 2
        System.out.println("Mảng 2: ");
        for (int i = 0; i < array2.length; i++) {
            System.out.print("Phần tử thứ " + (i + 1) + ": ");
            array2[i] = input.nextInt();
        }
        System.out.print("Mảng 2 đã nhập: ");
        for (int element2 : array2)
            System.out.print(element2 + " ");

        //Nối Mảng 1 và 2 vào Mảng 3
        for (int i = 0; i < array3.length; i++) {
            if (i < array1.length) {
                array3[i] = array1[i];
            } else {
                array3[i] = array2[i - array1.length];
            }
        }
        System.out.println();
        System.out.print("Mảng 3: ");
        for (int element3 : array3) {
            System.out.print(element3 + " ");
        }
    }
}
