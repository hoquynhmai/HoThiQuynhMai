package bai_thi.controller;

import bai_thi.commons.DocGhiFile;
import bai_thi.commons.KiemTra;
import bai_thi.commons.NotFoundDirectoryException;
import bai_thi.models.DanhBa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    public static List<DanhBa> danhSach = new ArrayList<>();

    public static void main(String[] args) {
        hienThiMenu();
    }

    public static void hienThiMenu() {
        int chon = 0;
        do {
            System.out.println("----------CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ--------------\nChọn chức năng theo số (để tiếp tục)\n1.Xem Danh Sách\n2.Thêm Mới\n3.Cập Nhật" +
                    "\n4.Xóa\n5.Tìm Kiếm\n6.Đọc Từ File\n7.Ghi vào File\n8.Thoát\n----------------------------------------------------");
            System.out.print("Chọn chức năng: ");
            String chonMenu = input.nextLine();
            if (KiemTra.kiemTraSoNguyen(chonMenu)) {
                chon = Integer.parseInt(chonMenu);
                switch (chon) {
                    case 1:
                        xemDanhSach();
                        break;
                    case 2:
                        themMoi();
                        break;
                    case 3:
                        capNhat(danhSach);
                        break;
                    case 4:
                        xoa();
                        break;
                    case 5:
                        timKiem();
                        break;
                    case 6:
                        docTuFile();
                        break;
                    case 7:
                        ghiVaoFile(danhSach);
                        break;
                    case 8:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Sự lựa chọn không tồn tại. Bạn cần chọn lại");
                }
            } else System.out.println("Lựa chọn không hợp lệ");
        } while (true);
    }

    public static void xemDanhSach() {
        if (danhSach.isEmpty()) System.out.println("Chưa có thông tin danh bạ nào");
        else {
            System.out.println("Danh sách quản lý danh bạ gồm:");
            int bienDem = 0;
            for (DanhBa element : danhSach) {
                if (bienDem % 5 == 0 && bienDem != 0) {
                    System.out.println("Nhấn Enter để xem tiếp");
                    String nhap = input.nextLine();
                    if (!nhap.equals("")) System.out.println("Chỉ cần nhấn Enter");
                }
                System.out.println((bienDem + 1) + ". " + element.toString());
                bienDem++;
            }
        }
    }

    public static void themMoi() {
        String soDT = KiemTra.kiemTraSoDT();
        String nhomDanhBa = KiemTra.kiemTraNhapChu("Nhóm Danh Bạ");
        String hoTen = KiemTra.kiemTraNhapChu("Họ Tên");
        String gioiTinh = KiemTra.kiemTraNhapChu("Giới Tính");
        String diaChi = KiemTra.kiemTraNhapChu("Địa Chỉ");
        String ngaySinh = KiemTra.kiemTraNhapChu("Ngày Sinh");
        String email = KiemTra.kiemTraEmail();
        System.out.print("Bạn đã nhập thành công\n");
        DanhBa thongTin = new DanhBa(soDT, nhomDanhBa, hoTen, gioiTinh, diaChi, ngaySinh, email);
        danhSach.add(thongTin);
        xemDanhSach();
    }

    public static void capNhat(List<DanhBa> danhSach) {
        System.out.print("Số điện thoại bạn muốn cập nhật : ");
        String soDienThoai = input.nextLine();
        capNhatDanhSach(danhSach, soDienThoai);
    }

    public static void capNhatDanhSach(List<DanhBa> danhSach, String soDT) {
        int chon = 0;
        if (soDT.equals("")) {
            hienThiMenu();
        } else {
            boolean check = false;
            for (DanhBa element : danhSach) {
                if (soDT.equals(element.getSoDienThoai())) {
                    String chonMenu;
                    do {
                        System.out.print("--------------THÔNG TIN CẦN CẬP NHẬT----------------------\n" +
                                "1.Cập Nhật Nhóm Danh Bạ\n" +
                                "2.Cập Nhật Họ Tên\n" +
                                "3.Cập Nhật Giới Tính\n" +
                                "4.Cập Nhật Địa Chỉ\n" +
                                "5.Cập Nhật Ngày Sinh\n" +
                                "6.Cập Nhật Email\n" +
                                "7.Thoát Cập Nhật và Quay về Menu\n" +
                                "------------------------------------------------------\n" +
                                "Chọn thông tin cần cập nhật : ");
                        chonMenu = input.nextLine();
                        if (KiemTra.kiemTraSoNguyen(chonMenu)) {
                            chon = Integer.parseInt(chonMenu);
                            switch (chon) {
                                case 1:
                                    System.out.print("Nhập Nhóm Danh Bạ : ");
                                    String nhomDanhBa = input.nextLine();
                                    //String nhomDanhBa = KiemTra.kiemTraNhapChu("Nhóm Danh Bạ");
                                    element.setNhomDanhBa(nhomDanhBa);
                                    break;
                                case 2:
                                    System.out.print("Nhập Họ Tên: ");
                                    String hoTen = input.nextLine();
                                    //String hoTen = KiemTra.kiemTraNhapChu("Họ Tên");
                                    element.setHoTen(hoTen);
                                    break;
                                case 3:
                                    System.out.print("Nhập Giới Tính : ");
                                    String gioiTinh = input.nextLine();
                                    //String gioiTinh = KiemTra.kiemTraNhapChu("Giới Tính");
                                    element.setGioiTinh(gioiTinh);
                                    break;
                                case 4:
                                    System.out.print("Nhập Địa Chỉ : ");
                                    String diaChi = input.nextLine();
                                    //String diaChi = KiemTra.kiemTraNhapChu("Địa Chỉ");
                                    element.setDiaChi(diaChi);
                                    break;
                                case 5:
                                    System.out.print("Nhập Ngày Sinh : ");
                                    String ngaySinh = input.nextLine();
                                    //String ngaySinh = KiemTra.kiemTraNhapChu("Ngày Sinh");
                                    element.setNgaySinh(ngaySinh);
                                    break;
                                case 6:
                                    //System.out.print("Nhập Email : ");
                                    //String email = input.nextLine();
                                    String email = KiemTra.kiemTraEmail();
                                    element.setEmail(email);
                                    break;
                                case 7:
                                    hienThiMenu();
                                    break;
                                default:
                                    System.out.println("Lựa chọn không tồn tại. Bạn cần chọn lại");
                            }
                        } else System.out.println("Lựa chọn không hợp lệ");
                        check = true;
                        break;
                    } while (true);
                }
            }
            if (!check) {
                System.out.println("Không tìm được danh bạ với số điện thoại trên. Vui lòng nhập lại ");
                capNhat(danhSach);
            } else {
                System.out.println("Bạn đã cập nhật thông tin thành công");
            }
        }
    }

    public static void xoa() {
        if (danhSach.isEmpty()) System.out.println("Hiện tại chưa có thông tin nào");
        else {
            do {
                try {
                    DanhBa thongTin = null;
                    System.out.print("Nhập số điện thoại bạn cần xóa: ");
                    String nhap = input.nextLine();
                    for (int i = 0; i < danhSach.size(); i++) {
                        if (nhap.equals(danhSach.get(i).getSoDienThoai())) {
                            thongTin = danhSach.get(i);
                            break;
                        }
                    }
                    if (thongTin != null) {
                        do {
                            System.out.println("Bạn có thật sự muốn xóa số điện thoại này không?\n====================================================\nNhập Y để xóa\nNếu không thì nhập N\n====================================================");
                            String chon = input.nextLine();
                            if (chon.equals("Y")) {
                                danhSach.remove(thongTin);
                                xemDanhSach();
                                return;
                            }
                            if (chon.equals("N")) return;
                        } while (true);
                    } else throw new NotFoundDirectoryException();
                } catch (NotFoundDirectoryException e) {
                    e.thongBao();
                    System.out.println("====================================================\nBạn có muốn quay về Menu chính không?\nNhấn Enter để quay về\nNhập N để xóa tiếp\n====================================================");
                    if (input.nextLine().equals("")) return;
                }
            } while (true);
        }
    }

    public static void timKiem() {
        List<DanhBa> danhSach = DocGhiFile.docFile();
        if (danhSach.isEmpty()) System.out.println("Chưa có thông tin danh bạ nào");
        else {
            System.out.print("Nhập số điện thoại hoặc họ tên bạn muốn tìm kiếm: ");
            String timKiem = input.nextLine();
            boolean kiemTra = true;
            int bienDem = 1;
            for (DanhBa element : danhSach) {
                if (element.getSoDienThoai().contains(timKiem) || element.getHoTen().contains(timKiem)) {
                    kiemTra = false;
                    System.out.println(bienDem + ". " + element);
                    bienDem++;
                }
            }
            if (kiemTra) System.out.println("Không có danh bạ nào khớp với thông tin bạn nhập");
        }
    }

    public static void docTuFile() {
        System.out.println("Bạn có muốn cập nhật Danh Bạ?\n====================================================\nNhấn Y nếu muốn cập nhật\nNhấn N nếu không muốn cập nhật\n====================================================");
        String nhap = input.nextLine();
        if (nhap.equals("Y")) {
            danhSach = DocGhiFile.docFile();
            System.out.println("Cập nhật thành công");
            xemDanhSach();
        } else System.out.println("Hủy cập nhật");
    }

    public static void ghiVaoFile(List<DanhBa> danhSach) {
        System.out.print("Bạn muốn cập nhật File?\n====================================================\nNhấn Y nếu muốn cập nhật\nNhấn N nếu không muốn cập nhật\n====================================================\n");
        String capNhat = input.nextLine();
        if (capNhat.equals("Y")) {
            DocGhiFile.ghiFile(danhSach);
            System.out.println("Cập nhật thành công");
        } else System.out.println("Hủy cập nhật");
    }
}
