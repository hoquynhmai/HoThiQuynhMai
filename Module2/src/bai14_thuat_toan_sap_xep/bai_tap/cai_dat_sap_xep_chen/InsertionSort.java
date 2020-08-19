package bai14_thuat_toan_sap_xep.bai_tap.cai_dat_sap_xep_chen;

public class InsertionSort {
    public static void main(String[] args) {
        int[] list = {1,9,55,44,33,77,0,8,9,10};
        System.out.println("Sau khi sắp xếp chèn: ");
        insertionSort(list);
    }
    public static void insertionSort(int[] list){
        int j = 0;
        for(int i = 0; i < list.length; i++){
            int key = list[i];
            j = i - 1;
            while (j >= 0 && list[j] > key)
            {
                list[j+1] = list[j];
                j = j-1;
            }
            list[j+1] = key;
        }
        for(int i = 0; i < list.length; i++){
            System.out.print(list[i] + " ");
        }
    }
}
