package bai17_io_binary_file_serialization.bai_tap.quan_ly_san_pham_luu_ra_file_nhi_phan;

import java.util.List;
import java.util.Scanner;

public class ProductManageFile {
    public static Scanner scanner = new Scanner(System.in);
    private List<Product> productList;
    private ProductStream productStream;

    public ProductManageFile() {
        productStream = new ProductStream();
        productList = productStream.read();
    }

    public void add() {
        int id = (productList.size() > 0) ? (productList.size() + 1) : 1;
        System.out.println("Mã sản phẩm: " + id);
        String name = inputName();
        float cost = inputCost();
        String producer = inputProducer();
        String description = inputDescription();
        Product product = new Product(id, name, cost, producer, description);
        productList.add(product);
        productStream.write(productList);
    }

    public void edit(int id) {
        boolean isExisted = false;
        int size = productList.size();
        System.out.println("Hiện có " + size + " sản phẩm");
        for (int i = 0; i < size; i++) {
            if (productList.get(i).getId() == id) {
                isExisted = true;
                productList.get(i).setName(inputName());
                productList.get(i).setCost(inputCost());
                productList.get(i).setProducer(inputProducer());
                productList.get(i).setDescription(inputDescription());
                break;
            }
        }
        if (!isExisted) {
            System.out.printf("Mã sản phẩm = %d không tồn tại.\n", id);
        } else {
            productStream.write(productList);
        }
    }

    public void delete(int id) {
        Product product = null;
        int size = productList.size();
        System.out.println("Hiện có " + size + " sản phẩm");
        for (int i = 0; i < size; i++) {
            if (productList.get(i).getId() == id) {
                product = productList.get(i);
                break;
            }
        }
        if (product != null) {
            productList.remove(product);
            productStream.write(productList);
        } else {
            System.out.printf("Mã sản phẩm = %d Không tồn tại.\n", id);
        }
    }

    public void show() {
        for (Product product : productList) {
            System.out.println("Mã sản phẩm: " + product.getId()
                               + " _ Tên sản phẩm: " + product.getName()
                               + " _ Giá Sản Phẩm: " + product.getCost()
                               + " _ Hãng sản xuất: " + product.getProducer()
                               + " _ Miêu tả sản phẩm: " + product.getDescription());
        }
    }

    public int inputId() {
        System.out.print("Nhập mã sản phẩm: ");
        while (true) {
            try {
                int id = Integer.parseInt((scanner.nextLine()));
                return id;
            } catch (NumberFormatException ex) {
                System.out.print("Không hợp lệ! Nhập lại mã sản phẩm: ");
            }
        }
    }

    private String inputName() {
        System.out.print("Nhập tên sản phẩm: ");
        return scanner.nextLine();
    }

    private String inputProducer() {
        System.out.print("Nhập hãng sản xuất: ");
        return scanner.nextLine();
    }

    private String inputDescription() {
        System.out.print("Nhập miêu tả sản phẩm: ");
        return scanner.nextLine();
    }

    private float inputCost() {
        System.out.print("Nhập giá sản phẩm: ");
        while (true) {
            try {
                float cost = Float.parseFloat((scanner.nextLine()));
                if (cost < 0.0)
                    throw new IllegalArgumentException();
                return cost;
            } catch (NumberFormatException e) {
                System.out.print("Không hợp lệ! Nhập lại giá sản phẩm: ");
            }
        }
    }

    // getter && setter
    public List<Product> getStudentList() {
        return productList;
    }

    public void setStudentList(List<Product> studentList) {
        this.productList = studentList;
    }
}

