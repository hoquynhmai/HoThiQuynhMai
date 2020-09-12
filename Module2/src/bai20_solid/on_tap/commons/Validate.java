package bai20_solid.on_tap.commons;

import java.util.Scanner;

public class Validate {
    static Scanner input = new Scanner(System.in);

    public static boolean kiemTraSoNguyen(String chon) {
        return chon.matches("^\\d+");
    }

    public static boolean kiemTraSoThuc(String soCanKiemTra) {
        return soCanKiemTra.matches("^\\d+([.]\\d+)?");
    }

    public static String kiemTraMaSP() {
        final String MA_SP_REGEX = "^SP\\d{5}$";
        String maSanPham;
        do {
            System.out.print("Nhập mã sản phẩm: ");
            maSanPham = input.nextLine();
            if (maSanPham.matches(MA_SP_REGEX)) break;
            else
                System.out.println("========================================\nNhập sai định dạng mã sản phẩm\nĐịnh dạng đúng là: SPYYYYY\nVới YYYYY là các số từ 0-9\n========================================");
        } while (true);
        return maSanPham;
    }

//    public static String kiemTraTenSPNhapKhau() {
//        final String SP_NHAP_KHAU = "^(Giay Adidas|Dong ho Rolex|Iphone XS)$";
//        String nhapTenSP;
//        do {
//            System.out.print("Sản Phẩm Nhập Khẩu: ");
//            nhapTenSP = input.nextLine();
//            if (nhapTenSP.matches(SP_NHAP_KHAU)) break;
//            else
//            System.out.println("========================================\nSản phẩm bạn nhập là Sản Phẩm Nhập Khẩu\nSản phẩm nhập khẩu bao gồm: Giay Adidas | Dong ho Rolex | Iphone XS\n========================================");
//        } while (true);
//        return nhapTenSP;
//    }

//    public static String kiemTraTenSPXuatKhau() {
//        final String SP_XUAT_KHAU = "^(Ao dai|Gao)$";
//        String nhapTenSP;
//        do {
//            System.out.print("Sản Phẩm Xuất Khẩu: ");
//            nhapTenSP = input.nextLine();
//            if (nhapTenSP.matches(SP_XUAT_KHAU)) break;
//            else
//                System.out.println("========================================\nSản phẩm bạn nhập là Sản Phẩm Xuất Khẩu\nSản phẩm xuất khẩu bao gồm: Ao dai | Gao\n========================================");
//        } while (true);
//        return nhapTenSP;
//    }

    public static String kiemTraGia(String loai) {
        String giaBan;
        do {
            System.out.print("Nhập " + loai + ": ");
            giaBan = input.nextLine();
            if (kiemTraSoThuc(giaBan) && Float.parseFloat(giaBan) > 0) break;
            else
                System.out.println("========================================\n" + loai + " Phải Là Số Dương\nĐịnh dạng số thực bằng dấu chấm\n========================================");
        } while (true);
        return giaBan;
    }

    public static String kiemTraSoLuongSP() {
        String soLuong;
        do {
            System.out.print("Nhập số lượng: ");
            soLuong = input.nextLine();
            if (kiemTraSoNguyen(soLuong) && Integer.parseInt(soLuong) > 0) break;
            else
                System.out.println("========================================\nSố Lượng Phải Là Số Nguyên Dương\n========================================");
        } while (true);
        return soLuong;
    }

//    public static String chuanHoaDL(String loại) {
//        final String CHUAN_HOA_DL = "^\\p{Lu}((\\p{Ll})*)(\\s\\p{Lu}(\\p{Ll})*)*$";
//        String duLieuCanKiemTra;
//        do {
//            try {
//                System.out.print(loại);
//                duLieuCanKiemTra = input.nextLine();
//                if (duLieuCanKiemTra.matches("^\\p{Lu}((\\p{Ll})*)(\\s\\p{Lu}(\\p{Ll})*)*$")) break;
//                else throw new NameException();
//            } catch (NameException e) {
//                System.out.println("========================================\nPhải in hoa ký tự đầu tiên trong mỗi từ\n========================================");
//            }
//        } while (true);
//        return duLieuCanKiemTra;
//    }

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
}
