package bai20_solid.bai_tap.commons;

import bai20_solid.bai_tap.models.ConNguoi;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DocGhiFile {
    private static final String DANH_BA_FILE = "D:\\CODE GYM\\C0620G1-HoThiQuynhMai\\Module2\\src\\bai20_solid\\bai_tap\\data\\people.csv";
    public static final String DAU_PHAY = ",";

    public static void ghiFile(List<ConNguoi> danhSach) {
        File file = new File(DANH_BA_FILE);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);

            for (ConNguoi element : danhSach){
               bufferedWriter.append(element.hienThiThongTin());
               bufferedWriter.append("\n");
            }

            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null) {
                    if (bufferedWriter != null) bufferedWriter.close();
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<ConNguoi> docFile() {
        List<ConNguoi> danhSach = new ArrayList<>();
        File file = new File(DANH_BA_FILE);
        if (file.isFile()) {
            FileReader fileReader = null;
            BufferedReader bufferedReader = null;
            try {
                fileReader = new FileReader(file);
                bufferedReader = new BufferedReader(fileReader);
                ConNguoi thongTin;
                String[] mang;
                String dong;
                while ((dong = bufferedReader.readLine()) != null) {
                    mang = dong.split(DAU_PHAY);
                    thongTin = new ConNguoi(mang[0], mang[1], mang[2], mang[3], mang[4], mang[5], mang[6]);
                    danhSach.add(thongTin);
                }
            } catch (FileNotFoundException e) {
                System.out.print(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fileReader != null) {
                        if (bufferedReader != null) bufferedReader.close();
                        fileReader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            try {
                if (file.createNewFile()) {
                    System.out.println("File đang trống");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return danhSach;
    }
}
