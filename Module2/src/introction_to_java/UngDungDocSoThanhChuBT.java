package introction_to_java;

import java.util.Scanner;

public class UngDungDocSoThanhChuBT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number, donVi, hangChuc, hangTram;
        System.out.print("Nhập số cần đọc : ");
        number = scanner.nextInt();
        donVi = -1;
        hangChuc = -1;
        hangTram = 0;
        if (number == 0) {
            System.out.print("Không");
        } else if (number > 0 && number <= 999) {
            if (number < 10) {
                donVi = number;
            } else if (number < 100) {
                hangChuc = number / 10;
                donVi = number - hangChuc * 10;
            } else {
                hangTram = number / 100;
                hangChuc = (number - hangTram * 100) / 10;
                donVi = number - (hangTram * 100 + hangChuc * 10);
                if (hangChuc == 0 && donVi == 0) {
                    hangChuc = -1;
                    donVi = -1;
                }
            }
            if (hangTram > 0) {
                switch (hangTram) {
                    case 1:
                        System.out.print("Một Trăm ");
                        break;
                    case 2:
                        System.out.print("Hai Trăm ");
                        break;
                    case 3:
                        System.out.print("Ba Trăm ");
                        break;
                    case 4:
                        System.out.print("Bốn Trăm ");
                        break;
                    case 5:
                        System.out.print("Năm Trăm ");
                        break;
                    case 6:
                        System.out.print("Sáu Trăm ");
                        break;
                    case 7:
                        System.out.print("Bảy Trăm ");
                        break;
                    case 8:
                        System.out.print("Tám Trăm ");
                        break;
                    case 9:
                        System.out.print("Chín Trăm ");
                        break;
                }
            }
            if (hangChuc > -1) {
                switch (hangChuc) {
                    case 0:
                        System.out.print("Lẻ ");
                        break;
                    case 1:
                        System.out.print("Mười ");
                        break;
                    case 2:
                        System.out.print("Hai Mươi ");
                        break;
                    case 3:
                        System.out.print("Ba Mươi ");
                        break;
                    case 4:
                        System.out.print("Bốn Mươi ");
                        break;
                    case 5:
                        System.out.print("Năm Mươi ");
                        break;
                    case 6:
                        System.out.print("Sáu Mươi ");
                        break;
                    case 7:
                        System.out.print("Bảy Mươi ");
                        break;
                    case 8:
                        System.out.print("Tám Mươi ");
                        break;
                    case 9:
                        System.out.print("Chín Mươi ");
                        break;
                }
            }
            if (donVi > -1) {
                switch (donVi) {
                    case 0:
                        System.out.print("");
                        break;
                    case 1:
                        if (hangChuc > 1) {
                            System.out.print("Mốt");
                        } else System.out.print("Một");
                        break;
                    case 2:
                        System.out.print("Hai");
                        break;
                    case 3:
                        System.out.print("Ba");
                        break;
                    case 4:
                        System.out.print("Bốn");
                        break;
                    case 5:
                        if (hangChuc > 0) {
                            System.out.print("Lăm");
                        } else System.out.print("Năm");
                        break;
                    case 6:
                        System.out.print("Sáu");
                        break;
                    case 7:
                        System.out.print("Bảy");
                        break;
                    case 8:
                        System.out.print("Tám");
                        break;
                    case 9:
                        System.out.print("Chín");
                        break;
                }
            }
        } else System.out.print("Out of ability");
    }
}