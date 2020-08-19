package bai13_thuat_toan_tim_kiem.bai_tap.optional.thuat_toan_nhi_phan_su_dung_de_quy;

public class BinarySearch {
    static int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};

    static int binarySearch(int[] list, int key, int firstIndex, int lastIndex) {
        if(lastIndex >= firstIndex) {
            int mid = (firstIndex + lastIndex )/ 2;
            if (key > list[mid] && firstIndex < mid) {
                return binarySearch(list, key, (mid + 1), lastIndex);
            } else if (key < list[mid] && lastIndex > mid) {
                return binarySearch(list, key, firstIndex, (mid - 1));
            } else if (key == list[mid]) {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(list, 10, 0, 12));  /* 3 */
        System.out.println(binarySearch(list, 2, 0, 12));  /* 0 */
        System.out.println(binarySearch(list, 79, 0, 12)); /* 12 */
        System.out.println(binarySearch(list, 59, 0, 12));  /* 7 */
        System.out.println(binarySearch(list, 5, 0, 12));  /* -1 */
        System.out.println(binarySearch(list, 60, 0, 12)); /* 8 */ //4,60
    }
}
