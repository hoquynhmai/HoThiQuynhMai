package furama_resort.controllers;

import furama_resort.commons.DocGhiFileCSV;
import furama_resort.models.House;
import furama_resort.models.Room;
import furama_resort.models.Villa;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MainController {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        try {
            displayMainMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void displayMainMenu() throws IOException {
        int chon = 0;
        do {
            System.out.println("-------------Menu-----------------\n1.Add New Services\n2.Show Services\n3.Add New Customer\n4.Show Information of Customer\n5.Add New Booking\n6.Show Information of Employee\n7.Exit\n-----------------------------------");
            System.out.print("Chọn: ");
            String chonMenu = input.nextLine();
            if (kiemTraSoNguyen(chonMenu)) {
                chon = Integer.parseInt(chonMenu);
                switch (chon) {
                    case 1:
                        addNewServices();
                        break;
                    case 2:
                        showServices();
                        break;
                    case 3:
                        //addNewCustomer();
                        break;
                    case 4:
                        //showInfoCustomer();
                        break;
                    case 5:
                        //addNewBooking();
                        break;
                    case 6:
                        //showInfoEmployee();
                        break;
                    case 7:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Sự lựa chọn không tồn tại. Bạn cần chọn lại");
                }
            } else System.out.println("Lựa chọn không tồn tại");
        } while (true);
    }

    public static void addNewServices() throws IOException {
        int chon = 0;
        do {
            System.out.println("-------------Menu-----------------\n1.Add New Villa\n2.Add New House\n3.Add New Room\n4.Back to Menu\n5.Exit\n-----------------------------------");
            System.out.print("Chọn: ");
            String chonMenu = input.nextLine();
            if (kiemTraSoNguyen(chonMenu)) {
                chon = Integer.parseInt(chonMenu);
                switch (chon) {
                    case 1:
                        addNewVilla();
                        break;
                    case 2:
                        addNewHouse();
                        break;
                    case 3:
                        addNewRoom();
                        break;
                    case 4:
                        displayMainMenu();
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

    public static void addNewVilla() throws IOException {
        String id = kiemTraID("VL");
        String tenDichVu = kiemTraTen("Villa");
        String dienTichSuDung = kiemTraDienTich("sử dụng");
        String giaThue = kiemTraChiPhiThue();
        String soLuongNguoiThue = kiemTraSoLuongNguoi();
        System.out.print("Nhập Kiểu thuê: ");
        String kieuThue = chuanHoaDL(input.nextLine());
        System.out.print("Nhập tiêu chuẩn Phòng: ");
        String tieuChuanPhong = chuanHoaDL(input.nextLine());
        System.out.print("Nhập mô tả tiện nghi khác: ");
        String moTaTienNghiKhac = input.nextLine();
        String dienTichHoBoi = kiemTraDienTich(" hồ bơi");
        String soTang = kiemTraSoTang();
        System.out.print("Bạn đã nhập thành công\n");
        Villa villa = new Villa(id, tenDichVu, dienTichSuDung, giaThue, soLuongNguoiThue, kieuThue, tieuChuanPhong, moTaTienNghiKhac, dienTichHoBoi, soTang);
        DocGhiFileCSV.ghiFileVilla(villa);
        List<Villa> villaList = DocGhiFileCSV.docFileVilla();
        for(Villa element: villaList){
            System.out.println(element.showInfo());
        }
    }

    public static void addNewHouse() throws IOException {
        String id = kiemTraID("HO");
        String tenDichVu = kiemTraTen("House");
        String dienTichSuDung = kiemTraDienTich("sử dụng");
        String giaThue = kiemTraChiPhiThue();
        String soLuongNguoiThue = kiemTraSoLuongNguoi();
        System.out.print("Nhập Kiểu thuê: ");
        String kieuThue = chuanHoaDL(input.nextLine());
        System.out.print("Nhập tiêu chuẩn Phòng: ");
        String tieuChuanPhong = chuanHoaDL(input.nextLine());
        System.out.print("Nhập mô tả tiện nghi khác: ");
        String moTaTienNghiKhac = input.nextLine();
        String soTang = kiemTraSoTang();
        System.out.print("Bạn đã nhập thành công\n");
        House house = new House(id, tenDichVu, dienTichSuDung, giaThue, soLuongNguoiThue, kieuThue, tieuChuanPhong, moTaTienNghiKhac, soTang);
        DocGhiFileCSV.ghiFileHouse(house);
        List<House> houseList = DocGhiFileCSV.docFileHouse();
        for(House element: houseList){
            System.out.println(element.showInfo());
        }
    }

    public static void addNewRoom() throws IOException {
        String id = kiemTraID("RO");
        String tenDichVu = kiemTraTen("Room");
        String dienTichSuDung = kiemTraDienTich("sử dụng");
        String giaThue = kiemTraChiPhiThue();
        String soLuongNguoiThue = kiemTraSoLuongNguoi();
        System.out.print("Nhập Kiểu thuê: ");
        String kieuThue = chuanHoaDL(input.nextLine());
        String dichVuDiKem = dichVuDiKem();
        System.out.print("Bạn đã nhập thành công\n");
        Room room = new Room(id, tenDichVu, dienTichSuDung, giaThue, soLuongNguoiThue, kieuThue, dichVuDiKem);
        DocGhiFileCSV.ghiFileRoom(room);
        List<Room> roomList = DocGhiFileCSV.docFileRoom();
        for(Room element: roomList){
            System.out.println(element.showInfo());
        }
    }

    public static void showServices() throws IOException {
        int chon = 0;
        do {
            System.out.println("-------------Menu-----------------\n1.Show All Villa\n2.Show All House\n3.Show All Room\n4.Show All Name Villa Not Duplicate\n5.Show All Name House Not Duplicate\n6.Show All Name Name Not Duplicate\n7.Back to menu\n8.Exit\n-----------------------------------");
            System.out.print("Chọn: ");
            String chonMenu = input.nextLine();
            if (kiemTraSoNguyen(chonMenu)) {
                chon = Integer.parseInt(chonMenu);
                switch (chon) {
                    case 1:
                        //showAllVilla();
                        break;
                    case 2:
                        //showAllHouse();
                        break;
                    case 3:
                        //showAllRoom();
                        break;
                    case 4:
                        //showAllNameVillaNotDuplicate();
                        break;
                    case 5:
                        //showAllNameHouseNotDuplicate();
                        break;
                    case 6:
                        //showAllNameRoomNotDuplicate();
                        break;
                    case 7:
                        displayMainMenu();
                        break;
                    case 8:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Sự lựa chọn không tồn tại. Bạn cần chọn lại");
                }
            } else System.out.println("Lựa chọn không tồn tại");
        } while (true);
    }

    public static void showAllVilla() {

    }

    public static String kiemTraID(String tenDichVu) {
        final String ID_REGEX = "^SV" + tenDichVu + "[-]\\d{4}$";
        String id;
        do {
            System.out.print("Nhập ID: ");
            id = input.nextLine();
//            Pattern pattern = Pattern.compile(ID_REGEX);
//            Matcher matcher = pattern.matcher(id);
            if (id.matches(ID_REGEX)) break;
            else
                System.out.println("Định dạng không hợp lệ\nNếu là Villa nhập: SVVL-YYYY\nNếu là House nhập: SVHO-YYYY\nNếu là Room nhập: SVRO-YYYY\nVới YYYY: là số từ 0-9");
        } while (true);
        return id;
    }

    public static String kiemTraTen(String tenDichVu) {
        String tenDV;
        do {
            System.out.print("Nhập tên dịch vụ: ");
            tenDV = input.nextLine();
            if (tenDV.equals(tenDichVu)) break;
            else System.out.println("Nhập sai tên dịch vụ\n(Villa - House - Room)");
        } while (true);
        return tenDV;
    }

    public static boolean kiemTraSoNguyen(String chon) {
        return chon.matches("^\\d+");
    }

    public static boolean kiemTraSoThuc(String soCanKiemTra) {
        return soCanKiemTra.matches("^\\d+([.]\\d+)?");
    }

    public static String kiemTraDienTich(String loai) {
        String nhapDienTich;
        do {
            System.out.print("Nhập diện tích " + loai + " : ");
            nhapDienTich = input.nextLine();
            if (kiemTraSoThuc(nhapDienTich) && Float.parseFloat(nhapDienTich) > 30) break;
            else System.out.println("Diện tích " + loai + " phải lớn hơn 30m2");
        } while (true);
        return nhapDienTich;
    }

    public static String kiemTraChiPhiThue() {
        String chiPhi;
        do {
            System.out.print("Nhập chi phí thuê: ");
            chiPhi = input.nextLine();
            if (kiemTraSoThuc(chiPhi) && Float.parseFloat(chiPhi) > 0) break;
            else System.out.println("Chi Phí Thuê Phải Là Số Dương");
        } while (true);
        return chiPhi;
    }

    public static String kiemTraSoLuongNguoi() {
        String soNguoi;
        do {
            System.out.print("Nhập số lượng người tối đa: ");
            soNguoi = input.nextLine();
            if (kiemTraSoNguyen(soNguoi) && Integer.parseInt(soNguoi) > 0 && Integer.parseInt(soNguoi) < 20) break;
            else System.out.println("Số lượng người phải lớn hơn 0 và nhỏ hơn 20");
        } while (true);
        return soNguoi;
    }

    public static String chuanHoaDL(String duLieu) {
        duLieu = duLieu.toLowerCase();
        duLieu = duLieu.substring(0, 1).toUpperCase() + duLieu.substring(1);
        return duLieu;
    }

    public static String kiemTraSoTang() {
        String soTang;
        do {
            System.out.print("Nhập số tầng: ");
            soTang = input.nextLine();
            if (kiemTraSoNguyen(soTang) && Integer.parseInt(soTang) > 0) break;
            else System.out.println("Số tầng phải là số nguyên dương");
        } while (true);
        return soTang;
    }

    public static String dichVuDiKem() {
        final String DV_DI_KEM_REGEX = "^(massage|karaoke|food|drink|car)([,](massage|karaoke|food|drink|car)){0,4}$";
        String dichVu;
        do {
            System.out.print("Dịch vụ đi kèm: ");
            dichVu = input.nextLine();
            if (dichVu.matches(DV_DI_KEM_REGEX)) break;
            else System.out.println("Chọn 1 trong các loại dịch vụ đi kèm sau: Massage, Karaoke, Food, Drink, Car");
        } while (true);
        return dichVu;
    }
}
