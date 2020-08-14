package bai10_dsa_danh_sach.bai_tap.trien_khai_phuong_thuc_arraylist;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> listInteger = new MyList<>();
        listInteger.add(1);
        listInteger.add(2);
        listInteger.add(3);
        listInteger.add(4);
        listInteger.add(5);
        listInteger.add(6);
        listInteger.add(7);
        listInteger.add(5);
        listInteger.add(9);
        listInteger.add(10);

        System.out.println("Chiều dài Array List: " + listInteger.size());
        System.out.println("List Interger = {" + listInteger.get(0) + "," + listInteger.get(1) + "," + listInteger.get(2) + "," +  listInteger.get(3) + "," + listInteger.get(4) + "," + listInteger.get(5)+ "," + listInteger.get(6) + "," + listInteger.get(7)+ "," + listInteger.get(8)+ "," + listInteger.get(9) + "}");
        System.out.println("Kiểm tra phần tử có chứa trong mảng ko: " + listInteger.contains(new Integer(2)));
        System.out.println("Trả về chỉ số đầu tiên của phần tử được tìm kiếm: " + listInteger.indexOf(5));
        System.out.println("Phần tử muốn xóa: " + listInteger.remove(3));
    }
}
// Chưa ổn
