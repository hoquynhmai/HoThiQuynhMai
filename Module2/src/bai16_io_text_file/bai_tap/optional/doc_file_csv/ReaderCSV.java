package bai16_io_text_file.bai_tap.optional.doc_file_csv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReaderCSV {
    public static void main(String[] args) {
        String csvFile = "D:\\CODE GYM\\C0620G1-HoThiQuynhMai\\Module2\\src\\bai16_io_text_file\\bai_tap\\optional\\doc_file_csv\\nation.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // Sử dụng dấu phẩy làm dấu phân cách
                String[] country = line.split(cvsSplitBy);

                System.out.println("Country [code = " + country[4] + " , name = " + country[5] + "]");

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
