package bai20_solid.on_tap.commons;

import bai20_solid.on_tap.models.Animal;
import bai20_solid.on_tap.models.AnimalNK;
import bai20_solid.on_tap.models.AnimalXK;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DocGhiFileCSV {
    private static final String SAN_PHAM_FILE = "D:\\CODE GYM\\C0620G1-HoThiQuynhMai\\Module2\\src\\bai20_solid.on_tap\\data\\product.csv";
    public static final String DAU_PHAY = ",";

    public static void ghiFileSP(Animal sanPham) {
        File file = new File(SAN_PHAM_FILE);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            StringBuilder stringBuilder = new StringBuilder();
            if (sanPham instanceof AnimalNK) {
                stringBuilder.append(sanPham.getIdSP()).append(DAU_PHAY).append(sanPham.getMaSP()).append(DAU_PHAY)
                        .append(sanPham.getTenSP()).append(DAU_PHAY).append(sanPham.getGiaBan()).append(DAU_PHAY)
                        .append(sanPham.getSoLuong()).append(DAU_PHAY).append(sanPham.getNhaSanXuat()).append(DAU_PHAY)
                        .append(((AnimalNK) sanPham).getGiaNhapKhau()).append(DAU_PHAY)
                        .append(((AnimalNK) sanPham).getTinhThanhNhap())
                        .append(DAU_PHAY).append(((AnimalNK) sanPham).getThueNhapKhau());
            } else {
                stringBuilder.append(sanPham.getIdSP()).append(DAU_PHAY).append(sanPham.getMaSP()).append(DAU_PHAY)
                        .append(sanPham.getTenSP()).append(DAU_PHAY).append(sanPham.getGiaBan()).append(DAU_PHAY)
                        .append(sanPham.getSoLuong()).append(DAU_PHAY).append(sanPham.getNhaSanXuat()).append(DAU_PHAY)
                        .append(((AnimalXK) sanPham).getGiaXuatKhau()).append(DAU_PHAY)
                        .append(((AnimalXK) sanPham).getQuocGiaNhapSP());
            }
            bufferedWriter.write(stringBuilder.toString());
            bufferedWriter.write("\n");
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

    public static List<Animal> docFileSP() {
        List<Animal> danhSachSP = new ArrayList<>();
        File file = new File(SAN_PHAM_FILE);
        if (file.isFile()) {
            FileReader fileReader = null;
            BufferedReader bufferedReader = null;
            try {
                fileReader = new FileReader(file);
                bufferedReader = new BufferedReader(fileReader);
                Animal sanPham;
                String[] mang;
                String dong;
                while ((dong = bufferedReader.readLine()) != null) {
                    mang = dong.split(DAU_PHAY);
                    if (mang.length == 9) {
                        sanPham = new AnimalNK(Integer.parseInt(mang[0]), mang[1], mang[2], mang[3], mang[4], mang[5], mang[6], mang[7], mang[8]);
                        danhSachSP.add(sanPham);
                    }
                    if (mang.length == 8) {
                        sanPham = new AnimalXK(Integer.parseInt(mang[0]), mang[1], mang[2], mang[3], mang[4], mang[5], mang[6], mang[7]);
                        danhSachSP.add(sanPham);
                    }
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
        return danhSachSP;
    }

    public static void capNhatFile(List<Animal> danhSachSP) {
        File file = new File(SAN_PHAM_FILE);
        if (file.delete()) System.out.println("Cập Nhật File Sản Phẩm");
        try {
            if (file.createNewFile()) System.out.println("Cập nhật thành công");
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Animal element : danhSachSP) {
            ghiFileSP(element);
        }
    }

//    public static void ghiFileSPXuatKhau(SanPhamXuatKhau sanPham) throws IOException {
//        File file = new File(SAN_PHAM_FILE);
//        FileWriter fileWriter = new FileWriter(file, true);
//        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//        try {
//            StringBuilder stringBuilder = new StringBuilder();
//            stringBuilder.append(sanPham.getIdSP()).append(DAU_PHAY).append(sanPham.getMaSP()).append(DAU_PHAY).append(sanPham.getTenSP()).append(DAU_PHAY).append(sanPham.getGiaBan()).append(DAU_PHAY).append(sanPham.getSoLuong()).append(DAU_PHAY).append(sanPham.getNhaSanXuat()).append(DAU_PHAY).append(sanPham.getGiaXuatKhau()).append(DAU_PHAY).append(sanPham.getQuocGiaNhapSP());
//            bufferedWriter.write(stringBuilder.toString());
//            bufferedWriter.write("\n");
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            bufferedWriter.flush();
//            bufferedWriter.close();
//        }
//    }
//
//    public static List<SanPhamXuatKhau> docFileSPXuatKhau() throws IOException {
//        List<SanPhamXuatKhau> danhSachSP = new ArrayList<>();
//        File file = new File(SAN_PHAM_FILE);
//        BufferedReader bufferedReader = null;
//        try {
//            FileReader fileReader = new FileReader(file);
//            bufferedReader = new BufferedReader(fileReader);
//            String dong = bufferedReader.readLine();
//            String[] mang;
//            while ((dong = bufferedReader.readLine()) != null) {
//                mang = dong.split(DAU_PHAY);
//                SanPhamXuatKhau sanPhamXuatKhau = new SanPhamXuatKhau(mang[0], mang[1], mang[2], mang[3], mang[4], mang[5], mang[6], mang[7]);
//                danhSachSP.add(sanPhamXuatKhau);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            assert bufferedReader != null;
//            bufferedReader.close();
//        }
//        return danhSachSP;
//    }
}
