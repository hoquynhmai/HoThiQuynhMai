package bai20_solid.bai_tap.controller;

import bai20_solid.bai_tap.commons.DocGhiFile;
import bai20_solid.bai_tap.commons.KiemTra;
import bai20_solid.bai_tap.commons.NotFoundDirectoryException;
import bai20_solid.bai_tap.models.ConNguoi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainCotroller {
    static Scanner input = new Scanner(System.in);
    public static List<ConNguoi> danhSach = new ArrayList<>();

    public static void main(String[] args) {
        hienThiMenu();
    }

    public static void hienThiMenu() {
        int chon = 0;
        do {
            System.out.println("----------CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ--------------\n1.Xem Danh Sách\n2.Thêm Mới\n3.Cập Nhật" +
                    "\n4.Xóa\n5.Tìm Kiếm\n6.Đọc Từ File\n7.Ghi vào File\n8.Thoát\n----------------------------------------------------");
            System.out.print("Chọn: ");
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
        if (danhSach.isEmpty()) System.out.println("Danh sách chưa có thông tin nào");
        else {
            System.out.println("Danh sách quản lý danh bạ gồm:");
            int bienDem = 0;
            for (ConNguoi element : danhSach) {
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
        ConNguoi thongTin = new ConNguoi(soDT, nhomDanhBa, hoTen, gioiTinh, diaChi, ngaySinh, email);
        danhSach.add(thongTin);
        xemDanhSach();
    }

    public static void capNhat(List<ConNguoi> danhSach) {
        System.out.print("Số điện thoại bạn muốn cập nhật : ");
        String soDienThoai = input.nextLine();
        capNhatDanhSach(danhSach, soDienThoai);
    }

    public static void capNhatDanhSach(List<ConNguoi> danhSach, String soDT) {
        int chon = 0;
        if (soDT.equals("")) {
            hienThiMenu();
        } else {
            boolean check = false;
            for (ConNguoi element : danhSach) {
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
                                "7.Thoát\n" +
                                "------------------------------------------------------\n" +
                                "Chọn thông tin cần cập nhật : ");
                        chonMenu = input.nextLine();
                        if (KiemTra.kiemTraSoNguyen(chonMenu)) {
                            chon = Integer.parseInt(chonMenu);
                            switch (chon) {
                                case 1:
                                    System.out.print("Nhập nhóm danh bạ : ");
                                    String nhomDanhBa = input.nextLine();
                                    element.setNhomDanhBa(nhomDanhBa);
                                    break;
                                case 2:
                                    System.out.print("Nhập họ tên: ");
                                    String hoTen = input.nextLine();
                                    element.setHoTen(hoTen);
                                    break;
                                case 3:
                                    System.out.print("Nhập giới tính : ");
                                    String gioiTinh = input.nextLine();
                                    element.setGioiTinh(gioiTinh);
                                    break;
                                case 4:
                                    System.out.print("Nhập địa chỉ : ");
                                    String diaChi = input.nextLine();
                                    element.setDiaChi(diaChi);
                                    break;
                                case 5:
                                    System.out.print("Nhập ngày sinh : ");
                                    String ngaySinh = input.nextLine();
                                    element.setNgaySinh(ngaySinh);
                                    break;
                                case 6:
                                    System.out.print("Nhập email : ");
                                    String email = input.nextLine();
                                    element.setEmail(email);
                                    break;
                                case 7:
                                    System.exit(0);
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
                    ConNguoi thongTin = null;
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
                            System.out.println("Bạn có thật sự muốn xóa số điện thoại này không?\nNhập Y để xóa\nNếu không thì nhập N");
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
                    System.out.println("Bạn có muốn quay về Menu chính không?\nNhấn Enter để quay về\nNhập N để xóa tiếp");
                    if (input.nextLine().equals("")) return;
                }
            } while (true);
        }
    }

    public static void timKiem() {
        List<ConNguoi> danhSach = DocGhiFile.docFile();
        if (danhSach.isEmpty()) System.out.println("Danh sách chưa có thông tin nào");
        else {
            System.out.print("Nhập số điện thoại hoặc họ tên bạn muốn tìm kiếm: ");
            String timKiem = input.nextLine();
            boolean kiemTra = true;
            int bienDem = 1;
            for (ConNguoi element : danhSach) {
                if (element.getSoDienThoai().contains(timKiem) || element.getHoTen().contains(timKiem)) {
                    kiemTra = false;
                    System.out.println(bienDem + ". " + element);
                    bienDem++;
                }
            }
            if (kiemTra) System.out.println("Không có danh bạ khớp với thông tin bạn nhập");
        }
    }

    public static void docTuFile() {
        System.out.println("Bạn có muốn cập nhật Danh Bạ?\nNhấn Y nếu muốn cập nhật\nNhấn N nếu không muốn cập nhật");
        String nhap = input.nextLine();
        if (nhap.equals("Y")) {
            danhSach = DocGhiFile.docFile();
            System.out.println("Cập nhật thành công");
            xemDanhSach();
        } else System.out.println("Hủy cập nhật");
    }

    public static void ghiVaoFile(List<ConNguoi> danhSach) {
        System.out.print("Bạn muốn cập nhật File?\nNhấn Y nếu muốn cập nhật\nNhấn N nếu không muốn cập nhật\n");
        String capNhat = input.nextLine();
        if (capNhat.equals("Y")) {
            DocGhiFile.ghiFile(danhSach);
            System.out.println("Cập nhật thành công");
        } else System.out.println("Hủy cập nhật");
    }
}
