package bai17_io_binary_file_serialization.bai_tap.quan_ly_san_pham_luu_ra_file_nhi_phan;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String choose;
        boolean exit = false;
        ProductManageFile productManageFile = new ProductManageFile(); //***
        int productID;

        showMenu();
        while (true) {
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    productManageFile.add();
                    break;
                case "2":
                    productManageFile.show();
                    productID = productManageFile.inputId();
                    productManageFile.edit(productID);
                    break;
                case "3":
                    productManageFile.show();
                    productID = productManageFile.inputId();
                    productManageFile.delete(productID);
                    break;
                case "4":
                    productManageFile.show();
                    break;
                case "0":
                    System.out.println("Thoát");
                    exit = true;
                    break;
                default:
                    System.out.println("Không hợp lệ! Chọn lại:");
                    break;
            }
            if (exit) {
                break;
            }
            // show menu
            showMenu();
        }
    }

    public static void showMenu() {
        System.out.println("-----------Menu------------");
        System.out.println("1. Thêm sản phẩm");
        System.out.println("2. Sửa sản phẩm bằng ID");
        System.out.println("3. Xóa sản phẩm bằng ID");
        System.out.println("4. Hiển thị thông tin sản phẩm");
        System.out.println("0. Exit.");
        System.out.println("---------------------------");
        System.out.print("Chọn: ");
    }
}
