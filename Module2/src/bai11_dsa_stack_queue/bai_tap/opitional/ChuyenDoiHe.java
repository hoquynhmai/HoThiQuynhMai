package bai11_dsa_stack_queue.bai_tap.opitional;

import java.math.BigInteger;
import java.util.Scanner;

public class ChuyenDoiHe {
    //Chuyển đổi từ hệ thập phân sang hệ nhị phân _ decimal: thập phân _ binary: nhị phân
    public static void changeDecimalToBinary() {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập số cần chuyển đổi : ");
        int decimalNumber = input.nextInt();

        System.out.print("Hệ nhị phân của " + decimalNumber + " là: ");
        System.out.print(Integer.toBinaryString(decimalNumber));
    }

    //Chuyển đổi từ hệ nhị phân sang hệ thập phân
    public static void changeBinaryToDecimal() {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập số cần chuyển đổi : ");
        String binaryNumber = input.nextLine();

        System.out.print("Hệ nhị phân của " + binaryNumber + " là: ");
        System.out.print(Integer.parseInt(binaryNumber,2));
    }

    // Chuyển đổi từ hệ thập phân sang hệ 16 _ Hexadecimal: hệ 16
    public static void changeDecimalToHexadecimal(){
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập số cần chuyển đổi: ");
        int decimalNumber = input.nextInt();

        System.out.print("Hệ 16 của " + decimalNumber + " là: ");
        System.out.print(Integer.toHexString(decimalNumber));
    }
    // Chuyển đổi từ hệ 16 sang hệ thập phân
    public static void changeHexadecimalToDecimal() {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập số cần chuyển đổi : ");
        String hexaNumber = input.nextLine();

        System.out.print("Hệ thập phân của " + hexaNumber + " là: ");
        System.out.print(Integer.parseInt(hexaNumber,16));
    }

    // Chuyển đổi từ hệ nhị phân sang hệ 16
    public static void changeHexadecimalToBinary() {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập số cần chuyển đổi : ");
        String hexaNumber = input.nextLine();

        System.out.print("Hệ 16 của " + hexaNumber + " là: ");
        System.out.print(new BigInteger(hexaNumber,16).toString(2));
    }

    // Chuyển đổi từ hệ 16 sang hệ nhị phân
    public static void changeBinaryToHexadecimal() {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập số cần chuyển đổi : ");
        String hexaNumber = input.nextLine();

        System.out.print("Hệ nhị phân của " + hexaNumber + " là: ");
        System.out.print(new BigInteger(hexaNumber,2).toString(16));
    }


    public static void main(String[] args) {
        System.out.println("1. Chuyển đổi từ hệ thập phân sang hệ nhị phân (155 -> 10011011)");
        changeDecimalToBinary();
        System.out.println();

        System.out.println("\n2. Chuyển đổi từ nhị thập phân sang hệ thập phân ( 10011 --> 19)");
        changeBinaryToDecimal();
        System.out.println();

        System.out.println("\n3. Chuyển đổi từ thập thập phân sang hệ 16 (254 --> FE)");
        changeDecimalToHexadecimal();
        System.out.println();

        System.out.println("\n4. Chuyển đổi từ 16 phân sang hệ thập phân (6F --> 111)");
        changeHexadecimalToDecimal();
        System.out.println();

        System.out.println("\n5. Chuyển đổi từ 16 phân sang hệ nhị phân (EE --> 11101110)");
        changeHexadecimalToBinary();
        System.out.println();

        System.out.println("\n6. Chuyển đổi từ nhị phân phân sang hệ 16 (11101110 --> EE)");
        changeBinaryToHexadecimal();
        System.out.println();
    }
}
