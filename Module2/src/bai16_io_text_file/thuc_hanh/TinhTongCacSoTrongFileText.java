package bai16_io_text_file.thuc_hanh;

import java.util.Scanner;

public class TinhTongCacSoTrongFileText {

    public static void main(String[] args) {
        System.out.println("Nhập đường dẫn file: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();

        ReadFileExample readfileEx = new ReadFileExample();
        readfileEx.readFileText(path);
    }
}
