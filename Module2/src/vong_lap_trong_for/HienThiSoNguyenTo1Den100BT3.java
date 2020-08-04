package vong_lap_trong_for;

public class HienThiSoNguyenTo1Den100BT3 {
    public static void main(String[] args) {
        int i;
        int num;
        String soNguyenTo = "";
        for (i = 1; i <= 100; i++) {
            int count = 0;
            for (num = i; num >= 1; num--) {
                if (i % num == 0) {
                    count++;
                }
            }
            if (count == 2) {
                soNguyenTo = soNguyenTo + i + " ";
            }
        }
        System.out.println("Các số nguyên tố từ 1 đến 100 là:");
        System.out.println(soNguyenTo);
    }
}
