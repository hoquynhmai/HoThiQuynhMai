package codegym._3_array_method;

import java.util.Arrays;

public class MyArray2 {
    public static int[] arr_1 = {1, 2, 3, 4, 5, 6, 7};
    public static int[] arr_2 = new int[5];


    public static void delete(int[] arr_1, int index) {
        if (index < 0 || index >= arr_1.length) {
            System.out.println("index khong hop le.");
        } else {
            for (int i = index; i < arr_1.length - 1; i++) {
                arr_1[i] = arr_1[i + 1];
            }
            arr_1[arr_1.length - 1] = 0;
            System.out.println(Arrays.toString(arr_1));
        }
    }

    public static void main(String[] args) {
        delete(arr_1, 3);
    }
}
