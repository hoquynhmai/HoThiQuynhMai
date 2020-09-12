package bai20_solid.bai_tap.commons;

import furama_resort.exception.EmailException;

import java.util.Scanner;

public class KiemTra {
    static Scanner input = new Scanner(System.in);

    public static boolean kiemTraSoNguyen(String chon) {
        return chon.matches("^\\d+");
    }

    public static String kiemTraNhapChu(String thongTin){
        String nhapThongTin;
        do {
            System.out.print("Nhập " + thongTin + " : ");
            nhapThongTin = input.nextLine();
            if (nhapThongTin.equals("")) System.out.println("Thông tin không được bỏ trống");
            else break;
        } while (true);
        return nhapThongTin;
    }

    public static String kiemTraEmail() {
        String email;
        do {
            try {
                System.out.print("Nhập Địa Chỉ Email: ");
                email = input.nextLine();
                if (email.matches("^\\w+@([a-z]{3,6})+[.]([a-z]{2,3})$")) break;
                else throw new EmailException();
            } catch (EmailException e) {
                System.out.println("========================================\nEmail phải đúng định dạng, ví dụ: abc123@gmail.com\n========================================");
            }
        } while (true);
        return email;
    }

    public static String kiemTraSoDT() {
        String soDT;
        do {
            System.out.print("Nhập Số Điện Thoại: ");
            soDT = input.nextLine();
            if (soDT.matches("^0\\d{9}$")) break;
            else
                System.out.println("========================================\nSố điện phải có 10 số và bắt đầu bằng số 0\n========================================");
        } while (true);
        return soDT;
    }
}
