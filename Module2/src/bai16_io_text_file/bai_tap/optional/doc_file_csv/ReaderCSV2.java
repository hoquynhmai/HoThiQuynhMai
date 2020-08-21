package bai16_io_text_file.bai_tap.optional.doc_file_csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderCSV2 {
    public static void main(String[] args) {
        String csvFile = "D:\\CODE GYM\\C0620G1-HoThiQuynhMai\\Module2\\src\\bai16_io_text_file\\bai_tap\\optional\\doc_file_csv\\nation.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // Sử dụng dấu phẩy làm dấu phân cách
                String[] country = line.split(cvsSplitBy);

                System.out.println("Country [code = " + country[4] + " , name = " + country[5] + "]");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
