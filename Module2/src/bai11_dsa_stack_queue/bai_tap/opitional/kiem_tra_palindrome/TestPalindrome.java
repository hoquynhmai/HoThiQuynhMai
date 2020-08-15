package bai11_dsa_stack_queue.bai_tap.opitional.kiem_tra_palindrome;

import java.util.Scanner;

public class TestPalindrome {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        System.out.print("Nhập chuỗi muốn kiểm tra: ");
        String string = input.nextLine();
        System.out.println("Chuỗi ban đầu: " + string);

        //StringBuffer(String str): Tạo ra một bộ đệm chuỗi với chuỗi cụ thể.
        StringBuffer newString = new StringBuffer(string).reverse();
        String reverseString = newString.toString();
        System.out.println("Chuỗi đảo ngược: " + reverseString);

        if (string.equalsIgnoreCase(reverseString)) {
            System.out.println("Là chuỗi Palindrome");
        } else {
            System.out.println("Không phải là chuỗi Palindrome");
        }
    }
}
