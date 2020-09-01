package furama_resort.controllers;

import furama_resort.commons.DocGhiFileCSV;
import furama_resort.exception.*;
import furama_resort.libs.SapXepHoTenKhach;
import furama_resort.models.*;

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
                        addNewCustomer();
                        break;
                    case 4:
                        showInfoCustomer();
                        break;
                    case 5:
                        addNewBooking();
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
        for (Villa element : villaList) {
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
        for (House element : houseList) {
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
        for (Room element : roomList) {
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
                        showAllVilla();
                        break;
                    case 2:
                        showAllHouse();
                        break;
                    case 3:
                        showAllRoom();
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

    public static void showAllVilla() throws IOException {
        List<Villa> villaList = DocGhiFileCSV.docFileVilla();
        if (!villaList.isEmpty()) {
            for (Villa element : villaList) {
                System.out.println(element);
            }
        } else System.out.println("Hiện chưa có thông tin của Villa nào");
    }

    public static void showAllHouse() throws IOException {
        List<House> houseList = DocGhiFileCSV.docFileHouse();
        if (!houseList.isEmpty()) {
            for (House element : houseList) {
                System.out.println(element);
            }
        } else System.out.println("Hiện chưa có thông tin của House nào");
    }

    public static void showAllRoom() throws IOException {
        List<Room> roomList = DocGhiFileCSV.docFileRoom();
        if (!roomList.isEmpty()) {
            for (Room element : roomList) {
                System.out.println(element);
            }
        } else System.out.println("Hiện chưa có thông tin của Room nào");
    }

    public static void addNewCustomer() throws IOException {
        String hoTen = kiemTraHoTen();
        String ngaySinh = kiemTraNgaySinh();
        String gioiTinh = kiemTraGioiTinh();
        String cmnd = kiemTraCMND();
        String soDT = kiemTraSoDT();
        String email = kiemTraEmail();
        System.out.print("Nhập Loại Khách: ");
        String loaiKhach = chuanHoaDL(input.nextLine());
        System.out.print("Nhập địa chỉ: ");
        String diaChi = chuanHoaDL(input.nextLine());
        System.out.println("Đã nhập thành công");
        Customer customer = new Customer(hoTen, ngaySinh, gioiTinh, cmnd, soDT, email, loaiKhach, diaChi);
        DocGhiFileCSV.ghiFileCustomer(customer);
        List<Customer> customerList = DocGhiFileCSV.docFileCustomer();
        for (Customer element : customerList) {
            System.out.println(element.showInfo());
        }
    }

    //Đã sắp xếp theo tên (nếu trùng tên sẽ so sánh đến năm sinh)
    public static void showInfoCustomer() throws IOException {
        List<Customer> customerList = DocGhiFileCSV.docFileCustomer();
        if (!customerList.isEmpty()) {
            SapXepHoTenKhach sapXep = new SapXepHoTenKhach();
            customerList.sort(sapXep);
            for (Customer element : customerList) {
                System.out.println(element.showInfo());
            }
        } else System.out.println("Hiện chưa có thông tin nào");
    }

    public static void addNewBooking() throws IOException {
        List<Customer> customerList = DocGhiFileCSV.docFileCustomer();
        if (!customerList.isEmpty()) {
            int bienDem = 1;
            for (Customer element : customerList) {
                System.out.println(bienDem + ". Customer " + bienDem + " " + element.showInfo());
                bienDem++;
            }
            String nhap;
            do {
                System.out.print("Nhập số thứ tự Customer bạn muốn chọn: ");
                nhap = input.nextLine();
                if (kiemTraSoNguyen(nhap) && Integer.parseInt(nhap) > 0 && Integer.parseInt(nhap) <= customerList.size())
                    break;
                else System.out.println("Lựa chọn của bạn không hợp lệ");
            } while (true);
            Customer customer = customerList.get(Integer.parseInt(nhap) - 1);
            int chon = 0;
            do {
                System.out.println("-------------Menu-----------------\n1.Booking Villa\n2.Booking House\n3.Booking Room\n4.Back to menu\n5.Exit\n-----------------------------------");
                System.out.print("Chọn: ");
                String chonMenu = input.nextLine();
                if (kiemTraSoNguyen(chonMenu)) {
                    chon = Integer.parseInt(chonMenu);
                    switch (chon) {
                        case 1:
                            bookingVilla(customer);
                            displayMainMenu();
                            break;
                        case 2:
                            bookingHouse(customer);
                            displayMainMenu();
                            break;
                        case 3:
                            bookingRoom(customer);
                            displayMainMenu();
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
        } else System.out.println("Hiện chưa có thông tin nào");
    }

    public static void bookingVilla(Customer customer) throws IOException {
        List<Villa> villaList = DocGhiFileCSV.docFileVilla();
        if (!villaList.isEmpty()) {
            int bienDem = 1;
            for (Villa element : villaList) {
                System.out.println(bienDem + ". Villa " + bienDem + " " + element);
                bienDem++;
            }
            String nhap;
            do {
                System.out.print("Nhập số thứ tự Villa bạn muốn chọn: ");
                nhap = input.nextLine();
                if (kiemTraSoNguyen(nhap) && Integer.parseInt(nhap) > 0 && Integer.parseInt(nhap) <= villaList.size())
                    break;
                else System.out.println("Lựa chọn của bạn không hợp lệ");
            } while (true);
            customer.setDichVu(villaList.get(Integer.parseInt(nhap) - 1));
            DocGhiFileCSV.ghiFileBooking(customer);
        } else System.out.println("Hiện chưa có thông tin của Villa nào");
    }

    public static void bookingHouse(Customer customer) throws IOException {
        List<House> houseList = DocGhiFileCSV.docFileHouse();
        if (!houseList.isEmpty()) {
            int bienDem = 1;
            for (House element : houseList) {
                System.out.println(bienDem + ". House " + bienDem + " " + element);
                bienDem++;
            }
            String nhap;
            do {
                System.out.print("Nhập số thứ tự House bạn muốn chọn: ");
                nhap = input.nextLine();
                if (kiemTraSoNguyen(nhap) && Integer.parseInt(nhap) > 0 && Integer.parseInt(nhap) <= houseList.size())
                    break;
                else System.out.println("Lựa chọn của bạn không hợp lệ");
            } while (true);
            customer.setDichVu(houseList.get(Integer.parseInt(nhap) - 1));
            DocGhiFileCSV.ghiFileBooking(customer);
        } else System.out.println("Hiện chưa có thông tin của House nào");
    }

    public static void bookingRoom(Customer customer) throws IOException {
        List<Room> roomList = DocGhiFileCSV.docFileRoom();
        if (!roomList.isEmpty()) {
            int bienDem = 1;
            for (Room element : roomList) {
                System.out.println(bienDem + ". Room " + bienDem + " " + element);
                bienDem++;
            }
            String nhap;
            do {
                System.out.print("Nhập số thứ tự Room bạn muốn chọn: ");
                nhap = input.nextLine();
                if (kiemTraSoNguyen(nhap) && Integer.parseInt(nhap) > 0 && Integer.parseInt(nhap) <= roomList.size())
                    break;
                else System.out.println("Lựa chọn của bạn không hợp lệ");
            } while (true);
            customer.setDichVu(roomList.get(Integer.parseInt(nhap) - 1));
            DocGhiFileCSV.ghiFileBooking(customer);
        } else System.out.println("Hiện chưa có thông tin của Room nào");
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
                System.out.println("========================================\nĐịnh dạng không hợp lệ\nNếu là Villa nhập: SVVL-YYYY\nNếu là House nhập: SVHO-YYYY\nNếu là Room nhập: SVRO-YYYY\nVới YYYY: là số từ 0-9\n========================================");
        } while (true);
        return id;
    }

    public static String kiemTraTen(String tenDichVu) {
        String tenDV;
        do {
            System.out.print("Nhập tên dịch vụ: ");
            tenDV = input.nextLine();
            if (tenDV.equals("Villa")) {
                if (tenDV.matches("^(Villa)(\\s(\\w)+)+$")) break;
            }
            if (tenDV.equals("House")) {
                if (tenDV.matches("^(House)(\\s(\\w)+)+$")) break;
            }
            if (tenDV.equals("Room")) {
                if (tenDV.matches("^(Room)(\\s(\\w)+)+$")) break;
            } else
                System.out.println("========================================\nNhập sai tên dịch vụ\n(Villa - House - Room)\n========================================");
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
            else
                System.out.println("========================================\nDiện tích " + loai + " phải lớn hơn 30m2\n========================================");
        } while (true);
        return nhapDienTich;
    }

    public static String kiemTraChiPhiThue() {
        String chiPhi;
        do {
            System.out.print("Nhập chi phí thuê: ");
            chiPhi = input.nextLine();
            if (kiemTraSoThuc(chiPhi) && Float.parseFloat(chiPhi) > 0) break;
            else
                System.out.println("========================================\nChi Phí Thuê Phải Là Số Dương\n========================================");
        } while (true);
        return chiPhi;
    }

    public static String kiemTraSoLuongNguoi() {
        String soNguoi;
        do {
            System.out.print("Nhập số lượng người tối đa: ");
            soNguoi = input.nextLine();
            if (kiemTraSoNguyen(soNguoi) && Integer.parseInt(soNguoi) > 0 && Integer.parseInt(soNguoi) < 20) break;
            else
                System.out.println("========================================\nSố lượng người phải lớn hơn 0 và nhỏ hơn 20\n========================================");
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
            else
                System.out.println("========================================\nSố tầng phải là số nguyên dương\n========================================");
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
            else
                System.out.println("========================================\nChọn 1 trong các loại dịch vụ đi kèm sau: massage, karaoke, food, drink, car\n========================================");
        } while (true);
        return dichVu;
    }

    public static String kiemTraHoTen() {
        String hoTenKhach;
        do {
            try {
                System.out.print("Nhập Họ và Tên Khách Hàng: ");
                hoTenKhach = input.nextLine();
                //^[A-Z]([a-z]*)([\s][A-Z]([a-z]*))+$ : Họ Tên Không Dấu
                if (hoTenKhach.matches("^\\p{Lu}((\\p{Ll})*)(\\s\\p{Lu}(\\p{Ll})*)*$")) break;
                else throw new NameException();
            } catch (NameException e) {
                System.out.println("========================================\nTên Khách hàng phải in hoa ký tự đầu tiên trong mỗi từ\n========================================");
            }
        } while (true);
        return hoTenKhach;
    }

    public static String kiemTraEmail() {
        String email;
        do {
            try {
                System.out.print("Nhập địa chỉ Email: ");
                email = input.nextLine();
                if (email.matches("^\\w+@([a-z]{3,6})+[.]([a-z]{2,3})$")) break;
                else throw new EmailException();
            } catch (EmailException e) {
                System.out.println("========================================\nEmail phải đúng định dạng abc123@gmail.com\n========================================");
            }
        } while (true);
        return email;
    }

    public static String kiemTraGioiTinh() {
        String gioiTinh;
        do {
            try {
                System.out.print("Nhập giới tính: ");
                gioiTinh = input.nextLine();
                if (gioiTinh.matches("^([Mm][Aa][Ll][Ee])|([Ff][Ee][Mm][Aa][Ll][Ee])|([Uu][Nn][Kk][Nn][Oo][Ww][Nn])$")) {
                    gioiTinh = gioiTinh.toLowerCase();
                    gioiTinh = gioiTinh.substring(0, 1).toUpperCase() + gioiTinh.substring(1);
                    break;
                } else throw new GenderException();
            } catch (GenderException e) {
                System.out.println("========================================\nGiới tính không hợp lệ. Nhập 1 trong 3 giới tính sau: Male, Female, Unknown\n========================================");
            }
        } while (true);
        return gioiTinh;
    }

    public static String kiemTraCMND() {
        String soCMND;
        do {
            try {
                System.out.print("Nhập số CMND: ");
                soCMND = input.nextLine();
                if (soCMND.matches("^(\\d{3}\\s){2}\\d{3}$")) break;
                else throw new IdCardException();
            } catch (IdCardException e) {
                System.out.println("========================================\nSố CMND phải có 9 chữ số và theo định dạng XXX XXX XXX\n========================================");
            }
        } while (true);
        return soCMND;
    }

    public static String kiemTraNgaySinh() {
        String ngaySinh;
        do {
            try {
                System.out.print("Nhập ngày tháng năm sinh: ");
                ngaySinh = input.nextLine();
                if (ngaySinh.matches("^((0[1-9])|([1-2][0-9])|(3[0-1]))[/]((0[1-9])|(1[0-2]))[/]((19[0-9]{2})|(200[0-2]))$"))
                    break;
                else throw new BirthdayException();
            } catch (BirthdayException e) {
                System.out.println("========================================\nNgày sinh không hợp lệ.\nNăm sinh phải > 1900 và nhỏ hơn năm hiện tại 18 năm\nĐúng định dạng dd/mm/yyyy\n========================================");
            }
        } while (true);
        return ngaySinh;
    }

    public static String kiemTraSoDT() {
        String soDT;
        do {
            System.out.print("Nhập số điện thoại: ");
            soDT = input.nextLine();
            if (soDT.matches("^0\\d{9}(\\s)?$")) break;
            else
                System.out.println("========================================\nSố điện phải có 10 số và bắt đầu bằng số 0\n========================================");
        } while (true);
        return soDT;
    }
}
