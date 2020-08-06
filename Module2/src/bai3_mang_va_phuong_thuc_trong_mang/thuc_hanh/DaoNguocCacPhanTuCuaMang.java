package bai3_mang_va_phuong_thuc_trong_mang.thuc_hanh;

import java.util.Scanner;

public class DaoNguocCacPhanTuCuaMang {
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
        System.out.print("Phần tử trong mảng: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
        System.out.println();
        for (int j = 0; j < array.length / 2; j++) {
            int temp = array[j];
            array[j] = array[size - 1 - j];
            array[size - 1 - j] = temp;
        }
        System.out.print("Mảng đảo ngược: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
    }
}
