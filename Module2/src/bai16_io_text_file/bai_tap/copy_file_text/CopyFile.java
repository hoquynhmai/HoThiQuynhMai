package bai16_io_text_file.bai_tap.copy_file_text;

import java.io.*;

public class CopyFile {
    static void testCopyFile(String inputFile,String outputFile) {
        //Đọc từng dòng của File cần sao chép
        try (BufferedReader input = new BufferedReader(new FileReader(inputFile))) {
            //Ghi chép nội dung vào file output; chép vào text
            try (BufferedWriter output = new BufferedWriter(new FileWriter(outputFile))) {
                String text = null;
                while ((text = input.readLine()) != null) {
                    System.out.println(text);
                    output.write(text);
                    output.newLine();
                }
            }
            System.out.println("Thông báo: Đã sao chép Xong");
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
