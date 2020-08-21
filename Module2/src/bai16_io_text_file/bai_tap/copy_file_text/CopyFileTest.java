package bai16_io_text_file.bai_tap.copy_file_text;

import java.util.Scanner;

public class CopyFileTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập File cần sao chép: ");
        String inputFile = scanner.nextLine();

        System.out.println("Nhập địa chỉ cần sao chép đến File: ");
        String outputFile = scanner.nextLine();

        System.out.println("\nKết quả sau khi sao chép dữ liệu  là: ");
        CopyFile.testCopyFile(inputFile, outputFile);
    }
}

