package bai3_mang_va_phuong_thuc_trong_mang.thuc_hanh;

public class TimGiaTriNhoNhatTrongMangSuDungPhuongThuc {
    public static void main(String[] args) {
        int[] arr = {4, 12, 0, 8, 1, 6, 9};
        int result = minValue(arr);
        System.out.println("Giá trị Nhỏ nhất trong mảng là: " + result);
    }
    public static int minValue(int[] arr) {
        int min = arr[0];
       for (int i = 0; i < arr.length; i++){
           if (arr[i] < min){
               min = arr[i];
           }
       }
       return min;
    }
}