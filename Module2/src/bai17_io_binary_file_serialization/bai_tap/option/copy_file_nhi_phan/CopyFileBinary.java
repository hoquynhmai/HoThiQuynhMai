package bai17_io_binary_file_serialization.bai_tap.option.copy_file_nhi_phan;

import java.io.*;

public class CopyFileBinary {
   public static void copyFile() throws IOException {
        InputStream inStream = null;
        OutputStream outStream = null;

        try {
            inStream = new FileInputStream(new File("D:\\CODE GYM\\C0620G1-HoThiQuynhMai\\Module2\\src\\bai17_io_binary_file_serialization\\bai_tap\\option\\copy_file_nhi_phan\\source.txt"));
            outStream = new FileOutputStream(new File("D:\\CODE GYM\\C0620G1-HoThiQuynhMai\\Module2\\src\\bai17_io_binary_file_serialization\\bai_tap\\option\\copy_file_nhi_phan\\dest.txt"));

            int length;
            byte[] buffer = new byte[1024];

            //1 character = 1 byte
            while ((length = inStream.read(buffer)) > 0) {
                outStream.write(buffer, 0, length);
                System.out.println("Số byte đã sao chép được: " + length + " bytes");
            }
            System.out.println("Đã sao chép thành công!");
            System.out.println("\nNội dung đã sao chép: ");
            for(int i = 0; i < buffer.length; i++){
                System.out.print((char)buffer[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            inStream.close();
            outStream.close();
        }
    }

    public static void main(String[] args) throws IOException {
        copyFile();
    }
}