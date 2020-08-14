package bai11_dsa_stack_queue.bai_tap;

import java.util.Stack;

public class DaoNguocPhanTuTrongMangSuDungStack {
    // Đảo ngược mảng số nguyên
    private static void stackOfIntegers() {
        Stack<Integer> stack = new Stack<>();
        int[] arrayInterger = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("Mảng số nguyên đã cho sẵn: ");
        for (int element : arrayInterger) {
            System.out.print(stack.push(element) + " ");
        }
        System.out.println();

        System.out.println("Mảng số nguyên đã bị đảo ngược: ");
        for (int element : arrayInterger) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    //Đảo ngược chuỗi
    private static void stackOfString() {
        Stack<String> wStack = new Stack<>();
        String string = "Hôm Nay Là Thứ Mấy";
        System.out.println("Chuỗi ban đầu: ");
        //String[] mWord = string.split("\\s")
        for (String mWord : string.split("\\s")) {
            System.out.print(wStack.push(mWord) + " ");
        }
        System.out.println();
        System.out.println("Chuỗi sau khi bị đảo ngược:");
        for (String mWord : string.split("\\s")) {
            System.out.print(wStack.pop() + " ");
        }
    }

    public static void main(String[] args) {
        System.out.println("1. Đảo ngược mảng số nguyên: ");
        stackOfIntegers();

        System.out.println("\n2. Đảo ngược chuỗi: ");
        stackOfString();
    }
}
