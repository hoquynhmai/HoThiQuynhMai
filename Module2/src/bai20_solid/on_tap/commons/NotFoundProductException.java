package bai20_solid.on_tap.commons;

public class NotFoundProductException extends Exception {
    public void thongBao(){
        System.out.println("Sản phẩm không tồn tại");
    }
}
