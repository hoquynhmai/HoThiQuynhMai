package bai20_solid.on_tap.controllers;

import bai20_solid.on_tap.commons.DocGhiFileCSV;
import bai20_solid.on_tap.commons.NotFoundProductException;
import bai20_solid.on_tap.commons.SapXep;
import bai20_solid.on_tap.commons.Validate;
import bai20_solid.on_tap.models.Animal;
import bai20_solid.on_tap.models.AnimalNK;
import bai20_solid.on_tap.models.AnimalXK;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MainControllers {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        sapXepSP();
        hienThiMenu();
    }

    public static void hienThiMenu() {
        int chon = 0;
        do {
            System.out.println("----------CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM--------------\n1.Thêm Mới\n2.Xóa\n3.Xem danh sách các sản phẩm\n4.Tìm Kiếm\n5.Thoát\n----------------------------------------------------");
            System.out.print("Chọn: ");
            String chonMenu = input.nextLine();
            if (Validate.kiemTraSoNguyen(chonMenu)) {
                chon = Integer.parseInt(chonMenu);
                switch (chon) {
                    case 1:
                        themMoi();
                        break;
                    case 2:
                        xoa();
                        break;
                    case 3:
                        xemDanhSachSP();
                        break;
                    case 4:
                        timKiem();
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Sự lựa chọn không tồn tại. Bạn cần chọn lại");
                }
            } else System.out.println("Lựa chọn không tồn tại");
        } while (true);
    }

    public static void themMoi() {
        int chon = 0;
        do {
            System.out.println("----------Thêm Mới Sản Phẩm--------------\n1.Thêm Mới Sản Phẩm Nhập Khẩu\n2.Thêm Mới Sản Phẩm Xuất Khẩu\n3.Quay lại Menu\n4.Thoát\n--------------------------------------------");
            System.out.print("Chọn: ");
            String chonMenu = input.nextLine();
            if (Validate.kiemTraSoNguyen(chonMenu)) {
                chon = Integer.parseInt(chonMenu);
                switch (chon) {
                    case 1:
                        themMoiSPNhapKhau();
                        break;
                    case 2:
                        themMoiSPXuatKhau();
                        break;
                    case 3:
                        hienThiMenu();
                        break;
                    case 4:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Sự lựa chọn không tồn tại. Bạn cần chọn lại");
                }
            } else System.out.println("Lựa chọn không tồn tại");
        } while (true);
    }

    public static int capNhatID() {
        int bienDem;
        List<Animal> danhSachSP = DocGhiFileCSV.docFileSP();
        if (danhSachSP.isEmpty()) {
            bienDem = 1;
        } else {
            int bienTam = danhSachSP.get(danhSachSP.size() - 1).getIdSP();
            bienDem = bienTam + 1;
        }
        return bienDem;
    }

    public static void themMoiSPNhapKhau() {
        int id = capNhatID();
        String maSP = Validate.kiemTraMaSP();
        String tenSPNhapKhau = Validate.kiemTraNhapChu("Tên Sản Phẩm Nhập Khẩu");
        String giaBan = Validate.kiemTraGia("Giá Bán");
        String soLuong = Validate.kiemTraSoLuongSP();
        String nhaSanXuat = Validate.kiemTraNhapChu("Nhập nhà sản xuất");
        String giaNhapKhau = Validate.kiemTraGia("Giá Nhập Khẩu");
        String tinhThanhNhap = Validate.kiemTraNhapChu("Nhập Tỉnh Thành Nhập");
        String thueNhapKhau = Validate.kiemTraGia("thuế nhập khẩu");
        System.out.print("Bạn đã nhập thành công\n");
        Animal sanPham = new AnimalNK(id, maSP, tenSPNhapKhau, giaBan, soLuong, nhaSanXuat, giaNhapKhau, tinhThanhNhap, thueNhapKhau);
        DocGhiFileCSV.ghiFileSP(sanPham);
        List<Animal> sanPhamDS = DocGhiFileCSV.docFileSP();
        for (Animal element : sanPhamDS) {
            System.out.println(element.hienThiThongTin());
        }
    }

    public static void themMoiSPXuatKhau() {
        int id = capNhatID();
        String maSP = Validate.kiemTraMaSP();
        String tenSPXuatKhau = Validate.kiemTraNhapChu("Tên Sản Phẩm Xuất Khẩu");
        String giaBan = Validate.kiemTraGia("Giá Bán");
        String soLuong = Validate.kiemTraSoLuongSP();
        String nhaSanXuat = Validate.kiemTraNhapChu("Nhập nhà sản xuất");
        String giaXuatKhau = Validate.kiemTraGia("Giá Xuất Khẩu");
        String quocGiaNhap = Validate.kiemTraNhapChu("Nhập Quốc Gia Nhập");
        System.out.print("Bạn đã nhập thành công\n");
        Animal sanPham = new AnimalXK(id, maSP, tenSPXuatKhau, giaBan, soLuong, nhaSanXuat, giaXuatKhau, quocGiaNhap);
        DocGhiFileCSV.ghiFileSP(sanPham);
        List<Animal> sanPhamDS = DocGhiFileCSV.docFileSP();
        for (Animal element : sanPhamDS) {
            System.out.println(element.hienThiThongTin());
        }
    }

    public static void xoa() {
        List<Animal> danhSachSP = DocGhiFileCSV.docFileSP();
        if (danhSachSP.isEmpty()) System.out.println("Hiện tại chưa có sản phẩm nào");
        else {
            do {
                try {
                    Animal sanPham = null;
                    System.out.print("Nhập mã sản phẩm bạn cần xóa: ");
                    String nhap = input.nextLine();
                    for (int i = 0; i < danhSachSP.size(); i++) {
                        if (nhap.equals(danhSachSP.get(i).getMaSP())) {
                            sanPham = danhSachSP.get(i);
                            break;
                        }
                    }
                    if (sanPham != null) {
                        do {
                            System.out.println("Bạn có thật sự muốn xóa sản phẩm này không?\nNhập Yes để xóa\nNếu không thì nhập No");
                            String chon = input.nextLine();
                            if (chon.equals("Yes")) {
                                danhSachSP.remove(sanPham);
                                DocGhiFileCSV.capNhatFile(danhSachSP);
                                xemDanhSachSP();
                                return;
                            }
                            if (chon.equals("No")) return;
                        } while (true);
                    } else throw new NotFoundProductException();
                } catch (NotFoundProductException e) {
                    e.thongBao();
                    System.out.println("Bạn có muốn quay về Menu chính không?\nNhấn Enter để quay về\nNhập No để xóa tiếp");
                    if (input.nextLine().equals("")) return;
                }
            } while (true);
        }
    }

    public static void xemDanhSachSP() {
        List<Animal> danhSachSP = DocGhiFileCSV.docFileSP();
        if (danhSachSP.isEmpty()) System.out.println("Danh sách chưa có sản phẩm nào");
        else {
            System.out.println("Danh sách các sản phẩm:");
            int bienDem = 1;
            for (Animal element : danhSachSP) {
                System.out.println(bienDem + ". " + element.hienThiThongTin());
                bienDem++;
            }
        }
    }

    public static void timKiem() {
        List<Animal> danhSachSP = DocGhiFileCSV.docFileSP();
        if (danhSachSP.isEmpty()) System.out.println("Danh sách chưa có sản phẩm nào");
        else {
            System.out.print("Nhập mã sản phẩm bạn muốn tìm: ");
            String timKiem = input.nextLine();
            boolean kiemTra = true;
            int bienDem = 1;
            for (Animal element : danhSachSP) {
                if (element.getMaSP().contains(timKiem) || element.getTenSP().contains(timKiem)){
                    kiemTra = false;
                    System.out.println(bienDem + ". " + element);
                    bienDem++;
                }
            }
            if (kiemTra) System.out.println("Không có sản phẩm khớp với thông tin bạn nhập");
        }
    }

    public static void sapXepSP(){
        List<Animal> danhSachSP = DocGhiFileCSV.docFileSP();
        if (danhSachSP.isEmpty()) System.out.println("Danh sách chưa có sản phẩm nào");
        else {
            danhSachSP.sort(new SapXep());
            Collections.reverse(danhSachSP);// sắp xếp giảm dần ....
            System.out.println("Danh sách các sản phẩm:");
            int bienDem = 1;
            for (Animal element : danhSachSP) {
                System.out.println(bienDem + ". " + element.hienThiThongTin());
                bienDem++;
            }
        }
    }
}
