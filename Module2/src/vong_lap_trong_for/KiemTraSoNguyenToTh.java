package vong_lap_trong_for;
import java.util.Scanner;
public class KiemTraSoNguyenToTh {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số cần kiểm tra:");
        int number = scanner.nextInt();
        if (number < 2)
            System.out.println(number + " Không Phải Là Số Nguyên Tố");
        else {
            int i = 2;
            boolean check = true;
            while (i <= Math.sqrt(number)) {
                if (number % i == 0) {
                    check = false;
                    break;
                }
                i++;
            }
            if (check)
                System.out.println(number + " Là Số Nguyên Tố");
            else
                System.out.println(number + " Không Phải Là Số Nguyên Tố");
        }
    }
}
