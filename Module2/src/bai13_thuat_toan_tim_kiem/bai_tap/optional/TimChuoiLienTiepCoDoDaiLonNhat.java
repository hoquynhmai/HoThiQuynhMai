package bai13_thuat_toan_tim_kiem.bai_tap.optional;

import java.util.Scanner;

public class TimChuoiLienTiepCoDoDaiLonNhat {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập chuỗi bất kỳ: ");
        String string = input.nextLine();
        String[] newString = string.split(" ");

        int index = 0;
        int lengthMax = 0;
        for (int i = 0; i < newString.length; i++){
            int length = newString[i].length();
            if(length > lengthMax){
                lengthMax = length;
                index = i;
            }
        }
        System.out.println("Chuỗi liên tiếp dài nhất là: " + newString[index] + "\nNằm ở vị trí thứ " + (index+1) + "\nCó độ dài là: " + lengthMax);
    }
}
