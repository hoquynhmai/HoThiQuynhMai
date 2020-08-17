package bai12_java_collection_framework.bai_tap.luyen_tap_su_dung_arraylist_linkedlist;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice;
        System.out.println("Menu: "
                + "\n1. Thêm Sản Phẩm"
                + "\n2. Sửa "
                + "\n3. Hiển thị"
                + "\n4. Xóa"
                + "\n5. Tìm Kiếm"
                + "\n6. Sắp xếp"
                + "\n7. Thoát");
        do {
            System.out.print("Chọn: ");
            Scanner scanner = new Scanner(System.in);
            String choose = scanner.nextLine();
            if(ProductManager.testInputNumber(choose)){
                choice = Integer.parseInt(choose);
                if(choice >= 1 && choice <= 7){
                    switch (choice) {
                        case 1:
                            ProductManager.add();
                            break;
                        case 2:
                            ProductManager.repair();
                            break;
                        case 3:
                            System.out.println(ProductManager.display());
                            break;
                        case 4:
                            ProductManager.delete();
                            break;
                        case 5:
                            System.out.println(ProductManager.search());
                            break;
                        case 6:
                            ProductManager.arrange();
                            break;
                        case 7:
                            System.exit(0);
                    }
                } else System.out.println("Lựa chọn của bạn không tồn tại");
            } else System.out.println("Lựa chọn của bạn không hợp lệ");
        } while (true);
    }
}
