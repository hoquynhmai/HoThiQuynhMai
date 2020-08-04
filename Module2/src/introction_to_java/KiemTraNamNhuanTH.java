package introction_to_java;
import java.util.Scanner;
public class KiemTraNamNhuanTH {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Nhap nam: ");
    int nam = scanner.nextInt();
        if(nam % 4 == 0){
            if(nam % 100 == 0){
                if(nam % 400 == 0){
                    System.out.printf("%d Là Năm Nhuận", nam);
                } else {
                    System.out.printf("%d Không Phải Là Năm Nhuận", nam);
                }
            } else {
                System.out.printf("%d Là Năm Nhuận", nam);
            }
        } else {
            System.out.printf("%d Không Phải Là Năm Nhuậnn", nam);
        }
    }
}

//    boolean isLeapYear = false;
//
//if(year % 4 == 0){
//        if(year % 100 == 0){
//        if(year % 400 == 0){
//        isLeapYear = true;
//        }
//        } else {
//        isLeapYear = true;
//        }
//        }
//
//        if(isLeapYear){
//        System.out.printf("%d is a leap year", year);
//        } else {
//        System.out.printf("%d is NOT a leap year", year);
//        }