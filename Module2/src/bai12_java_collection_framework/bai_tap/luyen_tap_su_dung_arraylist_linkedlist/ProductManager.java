package bai12_java_collection_framework.bai_tap.luyen_tap_su_dung_arraylist_linkedlist;

import java.util.*;

public class ProductManager {
    public static Scanner input = new Scanner(System.in);
    public static List<Product> productList = new ArrayList<>();

    public static void add() {
        int cost = 0;
        System.out.print("Nhập tên sản phẩm: ");
        String name = input.nextLine();
        do {
            System.out.print("Nhập giá sản phẩm: ");
            String inputCost = input.nextLine();
            if (testInputNumber(inputCost)) {
                cost = Integer.parseInt(inputCost);
                break;
            } else System.out.println("Giá bạn nhập không hợp lệ");
        } while (true);
        productList.add(new Product(name, cost));
        System.out.println("Đã thêm sản phẩm thành công");
    }

    public static void repair() {
        System.out.print("Nhập ID bạn muốn sửa: ");
        String id = input.nextLine();
        if (testID(id) > -1) {
            System.out.print("Nhập tên bạn muốn sửa: ");
            String name = input.nextLine();
            productList.get(testID(id)).setName(name);
            int cost;
            do {
                System.out.print("Nhập giá bạn muốn sửa: ");
                String inputCost = input.nextLine();
                if (testInputNumber(inputCost)) {
                    cost = Integer.parseInt(inputCost);
                    break;
                } else System.out.println("Giá bạn nhập không hợp lệ");
            } while (true);
            productList.get(testID(id)).setCost(cost);
            System.out.println("Đã sửa sản phẩm thành công");
        } else System.out.println("ID không hợp lệ. Hiện tại danh sách có: " + productList.size() + " sản phẩm");
    }

    public static List<Product> display() {
        return productList;
    }

    public static void delete() {
        System.out.print("Nhập ID bạn muốn xóa: ");
        String id = input.nextLine();
            if (testID(id) > -1) {
                productList.remove(testID(id));
                System.out.println("Đã xóa sản phẩm thành công");
            } else System.out.println("ID không hợp lệ. Hiện tại danh sách có: " + productList.size() + " sản phẩm");
    }

    public static Object search() {
        System.out.println("Tên sản phẩm bạn muốn tìm kiếm: ");
        String name = input.nextLine();
        for (Product element : productList) {
            if (name.equals(element.getName())) {
                return element;
            }
        }
        return "Sản phẩm không có trong danh sách";
    }

    public static void arrange() {
        System.out.println("Sắp xếp: \n1. Giá Tăng Dần \n2. Giá Giảm Dần");
        int choose = input.nextInt();
        input.skip("\\R");
        if (choose == 1) {
            sortUp();
        } else {
            Collections.reverse(ProductManager.sortUp());
        }
        System.out.println(productList);
    }

    public static List<Product> sortUp() {
        productList.sort(new Comparator<Product>() {
            @Override
            public int compare(Product product1, Product product2) {
                if (product1.getCost() > product2.getCost()) {
                    return 1;
                } else if (product1.getCost() == product2.getCost()) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        return productList;
    }

    public static int testID(String id) {
        if (testInputNumber(id)) {
            int idProduct = Integer.parseInt(id) - 1;
            if (idProduct < productList.size()) {
                return idProduct;
            }
        }
        return -1;
    }

    public static boolean testInputNumber(String input) {
        return input.matches("\\d+"); //\\d: 0-9; +: nhập nhiều số
    }
}
