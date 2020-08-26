package bai17_io_binary_file_serialization.bai_tap.quan_ly_san_pham_luu_ra_file_nhi_phan;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductStream {
    private static final String PRODUCT_FILE_NAME = "D:\\CODE GYM\\C0620G1-HoThiQuynhMai\\Module2\\src\\bai17_io_binary_file_serialization\\bai_tap\\quan_ly_san_pham_luu_ra_file_nhi_phan\\product.txt";
    public void write(List<Product> productList) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(new File(PRODUCT_FILE_NAME));
            oos = new ObjectOutputStream(fos);
            oos.writeObject(productList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeStream(fos);
            closeStream(oos);
        }
    }

    public List<Product> read() {
        List<Product> productList = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(new File(PRODUCT_FILE_NAME));
            ois = new ObjectInputStream(fis); // ***
            productList = (List<Product>) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeStream(fis);
            closeStream(ois);
        }
        return productList;
    }

    private void closeStream(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void closeStream(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

