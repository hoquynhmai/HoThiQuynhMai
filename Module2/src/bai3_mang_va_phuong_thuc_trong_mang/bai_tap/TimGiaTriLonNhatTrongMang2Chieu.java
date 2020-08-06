package bai3_mang_va_phuong_thuc_trong_mang.bai_tap;

public class TimGiaTriLonNhatTrongMang2Chieu {
    public static void main(String[] args) {
        int[][] array = {{1,2,3},
                         {4,5,6},
                         {7,8,9}};
        int max = array[0][0];
        int indexColum = 0;
        int indexRow = 0;
        for(int colum = 0; colum < array.length;colum++){
            for(int row = 0; row < array[colum].length; row++){
                if (max < array[colum][row]){
                    max = array[colum][row];
                    indexColum = colum;
                    indexRow = row;
                }
            }
        }
        System.out.print("Giá trị lớn nhất trong mảng là: " + max + "\n" + "Nằm ở vị trí: " + "array[" + indexColum + "][" + indexRow + "]" );
    }
}
