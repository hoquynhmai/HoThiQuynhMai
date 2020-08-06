package bai3_mang_va_phuong_thuc_trong_mang.bai_tap;

import java.util.Scanner;

public class XoaPhanTuKhoiMang {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.print("Mảng số nguyên đã cho: ");
        for (int element : array) {
            System.out.print(element + " ");
        }
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.print("Nhập giá trị cần tìm: ");
        int value = input.nextInt();

        int deletePostion = -1;
        for (int i = 0; i < array.length; i++) {
            if (value == array[i]) {
                deletePostion = i;
            }
        }
        if (deletePostion > -1) {
            for (int j = deletePostion; j < array.length - 1; j++) {
                array[j] = array[j + 1];
            }
            array[array.length - 1] = 0;
            System.out.print("Mảng số nguyên sau khi xóa số " + value + " là : ");
        } else {
            System.out.println("Số bạn nhập là " + value + " , không có trong mảng số nguyên đã cho !");
            System.out.print("Mảng số nguyên đã cho là : ");
        }
        for (int element : array) {
            System.out.print(element + " ");
        }
    }
}


