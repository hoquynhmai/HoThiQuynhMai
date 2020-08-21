package bai14_thuat_toan_sap_xep.bai_tap.minh_hoa_sap_xep_chen;

import java.util.Scanner;

public class InsertionSortByStep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter list size: ");
        int size = scanner.nextInt();
        int[] list = new int[size];
        System.out.println("Enter " + list.length + " values: ");
        for (int i = 0; i < list.length; i++) {
            list[i] = scanner.nextInt();
        }
        System.out.print("Your input list: ");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println("\n---------Strart Insertion Sort--------------");
        insertionSortByStep(list);
    }

    public static void insertionSortByStep(int[] list) {
        boolean needNextPass = true;
        int j = 0;
        for (int k = 1; k < list.length && needNextPass; k++) {
            needNextPass = false;
            for (int i = 0; i < list.length; i++) {
                int key = list[i];
                j = i - 1;

                while (j >= 0 && list[j] > key) {
                    if (list[j] > list[j + 1])
                        System.out.println("Di chuyển " + list[j] + " Lùi về sau để chèn " + list[j + 1]);
                    list[j + 1] = list[j];
                    j = j - 1;
                    list[j + 1] = key;
                    needNextPass = true;
                }
            }
            if (needNextPass == false) {
                System.out.println("Mảng có thể được sắp xếp và không cần chuyển tiếp");
                break;
            }
            System.out.println("Danh sách sau khi sắp xếp chèn: ");
            for (int l = 0; l < list.length; l++) {
                System.out.print(list[l] + " ");
            }
            System.out.println();
        }
    }
}
