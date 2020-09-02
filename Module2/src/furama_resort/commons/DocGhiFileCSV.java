package furama_resort.commons;

import furama_resort.models.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DocGhiFileCSV {
    public static final String DAU_PHAY = ",";

    public static void ghiFileVilla(Villa villa) throws IOException {
        File file = new File("D:\\CODE GYM\\C0620G1-HoThiQuynhMai\\Module2\\src\\furama_resort\\data\\Villa.csv");
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(villa.getId()).append(DAU_PHAY).append(villa.getTenDichVu()).append(DAU_PHAY).append(villa.getDienTichSuDung()).append(DAU_PHAY).append(villa.getGiaThue()).append(DAU_PHAY).append(villa.getSoLuongNguoiThue()).append(DAU_PHAY).append(villa.getKieuThue()).append(DAU_PHAY).append(villa.getTieuChuanPhong()).append(DAU_PHAY).append(villa.getMoTaTienNghiKhac()).append(DAU_PHAY).append(villa.getDienTichHoBoi()).append(DAU_PHAY).append(villa.getSoTang());
            bufferedWriter.write(stringBuilder.toString());
            bufferedWriter.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bufferedWriter.flush();
            bufferedWriter.close();
        }
    }

    public static List<Villa> docFileVilla() throws IOException {
        List<Villa> villaList = new ArrayList<>();
        File file = new File("D:\\CODE GYM\\C0620G1-HoThiQuynhMai\\Module2\\src\\furama_resort\\data\\Villa.csv");
        BufferedReader bufferedReader = null;
        try {
            FileReader fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String dong = bufferedReader.readLine();
            String[] mang;
            while ((dong = bufferedReader.readLine()) != null) {
                mang = dong.split(DAU_PHAY);
                Villa villa = new Villa(mang[0], mang[1], mang[2], mang[3], mang[4], mang[5], mang[6], mang[7], mang[8], mang[9]);
                villaList.add(villa);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            assert bufferedReader != null;
            bufferedReader.close();
        }
        return villaList;
    }

    public static void ghiFileHouse(House house) throws IOException {
        File file = new File("D:\\CODE GYM\\C0620G1-HoThiQuynhMai\\Module2\\src\\furama_resort\\data\\House.csv");
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(house.getId()).append(DAU_PHAY).append(house.getTenDichVu()).append(DAU_PHAY).append(house.getDienTichSuDung()).append(DAU_PHAY).append(house.getGiaThue()).append(DAU_PHAY).append(house.getSoLuongNguoiThue()).append(DAU_PHAY).append(house.getKieuThue()).append(DAU_PHAY).append(house.getTieuChuanPhong()).append(DAU_PHAY).append(house.getMoTaTienNghiKhac()).append(DAU_PHAY).append(house.getSoTang());
            bufferedWriter.write(stringBuilder.toString());
            bufferedWriter.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bufferedWriter.flush();
            bufferedWriter.close();
        }
    }

    public static List<House> docFileHouse() throws IOException {
        List<House> houseList = new ArrayList<>();
        File file = new File("D:\\CODE GYM\\C0620G1-HoThiQuynhMai\\Module2\\src\\furama_resort\\data\\House.csv");
        BufferedReader bufferedReader = null;
        try {
            FileReader fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String dong = bufferedReader.readLine();
            String[] mang;
            while ((dong = bufferedReader.readLine()) != null) {
                mang = dong.split(DAU_PHAY);
                House house = new House(mang[0], mang[1], mang[2], mang[3], mang[4], mang[5], mang[6], mang[7], mang[8]);
                houseList.add(house);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            assert bufferedReader != null;
            bufferedReader.close();
        }
        return houseList;
    }

    public static void ghiFileRoom(Room room) throws IOException {
        File file = new File("D:\\CODE GYM\\C0620G1-HoThiQuynhMai\\Module2\\src\\furama_resort\\data\\Room.csv");
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(room.getId()).append(DAU_PHAY).append(room.getTenDichVu()).append(DAU_PHAY).append(room.getDienTichSuDung()).append(DAU_PHAY).append(room.getGiaThue()).append(DAU_PHAY).append(room.getSoLuongNguoiThue()).append(DAU_PHAY).append(room.getKieuThue()).append(DAU_PHAY).append(room.getDichVuMienPhiDiKem());
            bufferedWriter.write(stringBuilder.toString());
            bufferedWriter.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bufferedWriter.flush();
            bufferedWriter.close();
        }
    }

    public static List<Room> docFileRoom() throws IOException {
        List<Room> roomList = new ArrayList<>();
        File file = new File("D:\\CODE GYM\\C0620G1-HoThiQuynhMai\\Module2\\src\\furama_resort\\data\\Room.csv");
        BufferedReader bufferedReader = null;
        try {
            FileReader fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String dong = bufferedReader.readLine();
            String[] mang;
            while ((dong = bufferedReader.readLine()) != null) {
                mang = dong.split(DAU_PHAY);
                Room room = new Room(mang[0], mang[1], mang[2], mang[3], mang[4], mang[5], mang[6]);
                roomList.add(room);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            assert bufferedReader != null;
            bufferedReader.close();
        }
        return roomList;
    }

    public static void ghiFileCustomer(Customer customer) throws IOException {
        File file = new File("D:\\CODE GYM\\C0620G1-HoThiQuynhMai\\Module2\\src\\furama_resort\\data\\Customer.csv");
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(customer.getHoTen()).append(DAU_PHAY).append(customer.getNgaySinh()).append(DAU_PHAY).append(customer.getGioiTinh()).append(DAU_PHAY).append(customer.getCmnd()).append(DAU_PHAY).append(customer.getSoDT()).append(DAU_PHAY).append(customer.getEmail()).append(DAU_PHAY).append(customer.getLoaiKhach()).append(DAU_PHAY).append(customer.getDiaChi());
            bufferedWriter.write(stringBuilder.toString());
            bufferedWriter.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bufferedWriter.flush();
            bufferedWriter.close();
        }
    }

    public static List<Customer> docFileCustomer() throws IOException {
        List<Customer> customerList = new ArrayList<>();
        File file = new File("D:\\CODE GYM\\C0620G1-HoThiQuynhMai\\Module2\\src\\furama_resort\\data\\Customer.csv");
        BufferedReader bufferedReader = null;
        try {
            FileReader fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String dong = bufferedReader.readLine();
            String[] mang;
            while ((dong = bufferedReader.readLine()) != null) {
                mang = dong.split(DAU_PHAY);
                Customer customer = new Customer(mang[0], mang[1], mang[2], mang[3], mang[4], mang[5], mang[6], mang[7]);
                customerList.add(customer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            assert bufferedReader != null;
            bufferedReader.close();
        }
        return customerList;
    }

    public static void ghiFileBooking(Customer customer) throws IOException {
        File file = new File("D:\\CODE GYM\\C0620G1-HoThiQuynhMai\\Module2\\src\\furama_resort\\data\\Booking.csv");
        BufferedWriter bufferedWriter = null;
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(customer.getHoTen()).append(DAU_PHAY).append(customer.getNgaySinh()).append(DAU_PHAY).append(customer.getGioiTinh()).append(DAU_PHAY).append(customer.getCmnd()).append(DAU_PHAY).append(customer.getSoDT()).append(DAU_PHAY).append(customer.getEmail()).append(DAU_PHAY).append(customer.getLoaiKhach()).append(DAU_PHAY).append(customer.getDiaChi()).append(" === Dịch vụ: ").append(customer.getDichVu());
            bufferedWriter.write(stringBuilder.toString());
            bufferedWriter.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bufferedWriter.flush();
            bufferedWriter.close();
        }
    }

    public static List<Employee> docFileEmployee() throws IOException {
        List<Employee> employeeList = new ArrayList<>();
        File file = new File("D:\\CODE GYM\\C0620G1-HoThiQuynhMai\\Module2\\src\\furama_resort\\data\\Employee.csv");
        BufferedReader bufferedReader = null;
        try {
            FileReader fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String dong = bufferedReader.readLine();
            String[] mang;
            while ((dong = bufferedReader.readLine()) != null) {
                mang = dong.split(DAU_PHAY);
                Employee employee = new Employee(mang[0],mang[1], mang[2], mang[3]);
                employeeList.add(employee);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            assert bufferedReader != null;
            bufferedReader.close();
        }
        return employeeList;
    }
}
