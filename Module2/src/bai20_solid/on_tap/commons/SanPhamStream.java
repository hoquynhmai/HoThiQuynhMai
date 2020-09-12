//package bai20_solid.on_tap.commons;
//
//import bai20_solid.on_tap.models.SanPham;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class SanPhamStream {
//    private static final String SANPHAM_FILE_NAME = "D:\\CODE GYM\\C0620G1-HoThiQuynhMai\\Module2\\src\\bai20_solid.on_tap\\data\\product.csv";
//    public static void ghiFile(List<SanPham> danhSachSP) {
//        FileOutputStream fos = null;
//        ObjectOutputStream oos = null;
//        try {
//            fos = new FileOutputStream(new File(SANPHAM_FILE_NAME));
//            oos = new ObjectOutputStream(fos);
//            oos.writeObject(danhSachSP);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            closeStream(fos);
//            closeStream(oos);
//        }
//    }
//
//    public static List<SanPham> docFile() {
//        List<SanPham> productList = new ArrayList<>();
//        FileInputStream fis = null;
//        ObjectInputStream ois = null;
//        try {
//            fis = new FileInputStream(new File(SANPHAM_FILE_NAME));
//            ois = new ObjectInputStream(fis);
//            productList = (List<SanPham>) ois.readObject();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            closeStream(fis);
//            closeStream(ois);
//        }
//        return productList;
//    }
//
//    private static void closeStream(InputStream is) {
//        if (is != null) {
//            try {
//                is.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//
//    private static void closeStream(OutputStream os) {
//        if (os != null) {
//            try {
//                os.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
