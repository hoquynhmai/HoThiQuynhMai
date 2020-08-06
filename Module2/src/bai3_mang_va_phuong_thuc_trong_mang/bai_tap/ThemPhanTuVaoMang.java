package bai3_mang_va_phuong_thuc_trong_mang.bai_tap;

import java.util.Scanner;

public class ThemPhanTuVaoMang {
    public static void main(String[] args) {
        // Tạo mảng array có sẵn giá trị và hiển thị array
        int[] array = {5, 95, 25, 75, 45, 55, 65, 35, 85, 15};
        System.out.print("Mảng đã cho: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        // Nhập số cần tìm
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.print("Nhập số cần chèn vào mảng : ");
        int insertValue = scanner.nextInt();

        // Nhập vị trí muốn chèn (chỉ số)
        System.out.print("Nhập vị trí cần chèn vào mảng : ");
        int insertPosition = scanner.nextInt();

        //Duyệt mảng và hiển thị mảng sau khi đã chèn
        if (insertPosition < 0 || insertPosition > array.length - 1) {
            System.out.print("Vị trí cần chèn không hợp lệ !");
        } else {
            array = insertElement(array, insertValue, insertPosition);
            System.out.print("Mảng đã cho sau khi chèn số " + insertValue + " là : ");
            for (int element : array) {
                System.out.print(element + " ");
            }
        }

    }

    // Phương thức chèn giá trị vào mảng
    public static int[] insertElement(int[] array, int insertValue, int insertPosition) {
        int length = array.length;
        int[] newArray = new int[length + 1];
        System.arraycopy(array, 0, newArray, 0, insertPosition);
        newArray[insertPosition] = insertValue;
        System.arraycopy(array, insertPosition, newArray, insertPosition + 1, length - insertPosition);
        return newArray;
    }
}
