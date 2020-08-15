package bai11_dsa_stack_queue.bai_tap.opitional.chuyen_doi_he;

import java.util.Scanner;
import java.util.Stack;

public class ChuyenDoiHeBangStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        System.out.print("Nhập hệ số thập phân cần chuyển đổi: ");
        Scanner input = new Scanner(System.in);
        int decimalNumber = input.nextInt();
        int temp = decimalNumber;
        int count = 0;
        int result;
        while (temp != 0) {
            result = temp % 2;
            stack.push(result);
            count++;
            temp = temp / 2;
        }
        System.out.println(stack);
        System.out.print("Hệ nhị phân của " + decimalNumber + " là: ");
        while (count != 0) {
            System.out.print(stack.pop());
            count--;
        }
    }
}
