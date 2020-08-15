package bai11_dsa_stack_queue.bai_tap.opitional.kiem_tra_palindrome;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TestPalindromeQueue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập chuỗi cần kiểm tra: ");
        String string = input.nextLine();

        Queue<Character> queue = new LinkedList<>();
        for (int i = (string.length() - 1); i >= 0; i--) {
            char character = string.charAt(i);
            queue.add(character);
        }
        System.out.println(queue);

        StringBuffer newString = new StringBuffer(string).reverse();
        String reverseString = newString.toString();
        if(string.equalsIgnoreCase(reverseString)){
            System.out.println("Là chuỗi Palindrome");
        } else {
            System.out.println("Không phải là chuỗi Palindrome");
        }
    }
}

